if ((Test-Path "./test/chromedriver.exe") -eq $false) {
    Write-Host "Chromedriver not found in test folder. Please download suitable version from https://chromedriver.storage.googleapis.com/index.html"
    exit 1
}

$global:STACK_NAME = Read-Host "Please Enter the AWS Stack name (default thundra-foresight-aws-workshop)"
$global:AWS_REGION = Read-Host "Please enter the AWS region (default eu-west-1)"

Write-Host ""

Write-Host "Please create a Thundra Foresight project: https://foresight.docs.thundra.io/"

if(!$global:STACK_NAME) {
    $global:STACK_NAME = "thundra-foresight-aws-workshop"
}

if(!$global:AWS_REGION) {
    $global:AWS_REGION = "eu-west-1"
}


$global:API_KEY = Read-Host "Please enter your Thundra API key"
$global:PROJECT_ID = Read-Host "Please enter your Thundra Project ID"


if ($global:API_KEY -eq $null -or $global:PROJECT_ID -eq $null) {
    Write-Host "API key or project ID is invalid. Please restart script."
    exit 1
}

$global:SNS_WRITER_URL = $null
$global:WEB_CONTENT_RETRIEVER_URL = $null

try {
    $global:JSON = (aws cloudformation describe-stacks --stack-name $global:STACK_NAME --region $global:AWS_REGION) | ConvertFrom-Json
}
catch {
    $global:JSON = $null
}

function RunTests{
    cd ./test

    $pom_content = Get-Content pom.xml
    $pom_content = $pom_content.replace("<API_KEY>", $global:API_KEY)
    $pom_content = $pom_content.replace("<PROJECT_ID>", $global:PROJECT_ID)

    Set-Content pom.xml $pom_content

    $env:THUNDRA_WORKSHOP_SNS_WRITER_URL = $global:SNS_WRITER_URL
    $env:THUNDRA_WORKSHOP_WEB_RETRIEVER_URL = $global:WEB_CONTENT_RETRIEVER_URL

    mvn clean install

    $env:THUNDRA_WORKSHOP_SNS_WRITER_URL = $null
    $env:THUNDRA_WORKSHOP_WEB_RETRIEVER_URL = $null

    $pom_content = Get-Content pom.xml
    $pom_content = $pom_content.replace("$global:API_KEY", "<API_KEY>")
    $pom_content = $pom_content.replace("$global:PROJECT_ID", "<PROJECT_ID>")

    Set-Content pom.xml $pom_content
    cd ..
}

function DeployStack {
    sam deploy --stack-name $global:STACK_NAME  --region $global:AWS_REGION --template-file template.yaml --capabilities CAPABILITY_IAM --resolve-s3
    $JSON = (aws cloudformation describe-stacks --stack-name $global:STACK_NAME --region $global:AWS_REGION) | ConvertFrom-Json
    
    if($JSON.Stacks.Count -eq 0) {
        throw "Stack not found"
    }

    if($JSON.Stacks[0].Outputs.Count -eq 0) {
        throw "No outputs found"
    }

    foreach ($output in $JSON.Stacks[0].Outputs) {
        if($output.OutputKey -eq "S3Bucket") {
            $BUCKET_NAME = $output.OutputValue
        }

        if($output.OutputKey -eq "SnsWriter") {
            $global:SNS_WRITER_URL = $output.OutputValue
        }
        if($output.OutputKey -eq "WebContentRetrieverApi") {
            $global:WEB_CONTENT_RETRIEVER_URL = $output.OutputValue
        }
    }

    if($BUCKET_NAME -eq $null -or $global:SNS_WRITER_URL -eq $null -or $global:WEB_CONTENT_RETRIEVER_URL -eq $null) {
        throw "Unable to find output values"
    }

    aws s3 sync ./static/ s3://$BUCKET_NAME/static/

    $JSON = (aws --output json s3 ls s3://$BUCKET_NAME/static/) | ConvertTo-Json 

    if($JSON.Count -eq 0) {
        throw "No files found in bucket"
    }    
}



function DeleteStack {

    Write-Host "Deleting exist stack..."

    foreach ($output in $JSON.Stacks[0].Outputs) {
        if($output.OutputKey -eq "S3Bucket") {
            $BUCKET_NAME = $output.OutputValue
        }
    }

    if($BUCKET_NAME -ne $null ) {
        aws s3 rm s3://$BUCKET_NAME/static/ --recursive
        aws s3 rm s3://$BUCKET_NAME/ --recursive
    }


    sam delete --stack-name $global:STACK_NAME --region $global:AWS_REGION --no-prompts

    $JSON = (aws cloudformation describe-stacks --stack-name $global:STACK_NAME --region $global:AWS_REGION) | ConvertFrom-Json

    if($JSON.Stacks.Count -ne 0) {
        throw "Stack not deleted"
    }

}


if($global:JSON -ne $null) {   
    DeleteStack
}

DeployStack
RunTests

