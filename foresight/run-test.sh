
if [ ! -f "./test/thundra-agent-bootstrap.jar" ]; then
    echo "thundra-agent-bootstrap.jar is downloading..."
    wget "https://repo.thundra.io/service/local/artifact/maven/redirect?r=thundra-releases&g=io.thundra.agent&a=thundra-agent-bootstrap&v=LATEST" -O ./test/thundra-agent-bootstrap.jar 
fi


if [ ! -f ./test/chromedriver ]; then
    echo "Chromedriver not found in test folder. Please download suitable version from https://chromedriver.storage.googleapis.com/index.html"
    exit 1
fi


read -p "Please Enter the AWS Stack name (default thundra-foresight-aws-workshop): " stack_name
read -p "Please Enter the AWS Region (default eu-west-1): " aws_region

if(test -z "$stack_name")
then
    stack_name="thundra-foresight-aws-workshop"
fi

if(test -z "$aws_region")
then
    aws_region="eu-west-1"
fi

echo ""
echo "Please create a Thundra Foresight project: https://foresight.docs.thundra.io/"
read -p "Please Enter the Thundra Foresight API Key: " api_key
read -p "Please Enter the Thundra Foresight Project ID: " project_id

if(test -z "$api_key")
then
    echo "Please enter a valid Thundra Foresight API Key"
    exit 1
fi

if(test -z "$project_id")
then
    echo "Please enter a valid Thundra Foresight Project ID"
    exit 1
fi

unset sns_writer_url
unset web_content_retriever_url

JSON=$(aws cloudformation describe-stacks --stack-name $stack_name --region $aws_region --output json)

unset bucket_name

function run_tests() {

    cd "./test"
    
    sed -i "s/<API_KEY>/$api_key/g" "pom.xml"
    sed -i "s/<PROJECT_ID>/$project_id/g" "pom.xml"

    export THUNDRA_WORKSHOP_SNS_WRITER_URL=$sns_writer_url
    export THUNDRA_WORKSHOP_WEB_RETRIEVER_URL=$web_content_retriever_url

    mvn clean test
    
    unset THUNDRA_WORKSHOP_SNS_WRITER_URL
    unset THUNDRA_WORKSHOP_WEB_RETRIEVER_URL

    sed -i "s/$api_key/<API_KEY>/g" "pom.xml"
    sed -i "s/$project_id/<PROJECT_ID>/g" "pom.xml"

    cd "../"
}

function deploy_stack() {
    
    sam deploy --stack-name $stack_name  --region $aws_region --template-file template.yaml --capabilities CAPABILITY_IAM --resolve-s3
    JSON=$(aws cloudformation describe-stacks --stack-name $stack_name --region $aws_region --output json)

   
    if [ -z "$(echo $JSON | jq '.Stacks[0].StackStatus')" ]; then
        echo "Stack creation failed"
        exit 1
    fi

    if [ "$(echo $JSON | jq '.Stacks[0].StackStatus')" != "\"CREATE_COMPLETE\"" ]; then
        echo "Stack creation failed"
        exit 1
    fi
    
    bucket_name=$(echo $JSON | jq '.Stacks[0].Outputs[] | select(.OutputKey=="S3Bucket") | .OutputValue')
    sns_writer_url=$(echo $JSON | jq '.Stacks[0].Outputs[] | select(.OutputKey == "SnsWriter") | .OutputValue')
    web_content_retriever_url=$(echo $JSON | jq '.Stacks[0].Outputs[] | select(.OutputKey == "WebContentRetrieverApi") | .OutputValue')


    if [ -z "$bucket_name" ] || [ -z "$sns_writer_url" ] || [ -z "$web_content_retriever_url" ]; then
        echo "Stack creation failed"
        exit 1
    fi

    bucket_name=$(echo $bucket_name | sed 's/\"//g')
    sns_writer_url=$(echo $sns_writer_url | sed 's/\"//g')
    web_content_retriever_url=$(echo $web_content_retriever_url | sed 's/\"//g')

    aws s3 sync ./static s3://$bucket_name/static/
    JSON=$(aws s3 ls --output json s3://$bucket_name/static/ --recursive)

    if [ -z "$(echo $JSON)" ]; then
        echo "Static files not uploaded"
        exit 1
    fi
   
}
function delete_stack(){

    bucket_name=$(echo $JSON | jq '.Stacks[0].Outputs[] | select(.OutputKey=="S3Bucket") | .OutputValue')
    bucket_name=$(echo $bucket_name | sed 's/\"//g')

    if [ -n "$bucket_name" ]; then
        aws s3 rm s3://$bucket_name/static/ --recursive
        aws s3 rm s3://$bucket_name/ --recursive
    fi

    sam delete --stack-name $stack_name --region $aws_region --no-prompts

    JSON=$(aws cloudformation describe-stacks --stack-name $stack_name --region $aws_region --output json)

    if [ $(echo $JSON | jq '.Stacks | length') > 0 ]; then
        echo "Stack deletion failed"
        exit 1
    fi
}

if [ $(echo $JSON | jq '.Stacks | length') > 0 ]; then
    delete_stack
fi


deploy_stack
run_tests
delete_stack