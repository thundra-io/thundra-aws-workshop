---
title: "Thundra Apm Integration"
date: 2022-02-04T13:24:26+03:00
weight: 7
chapter: true
pre: "<b>2.2 </b>"
---
<style>
h5 {text-align: center;}
</style>


## Thundra APM Integration

Now we have the demo application, it is time to deploy it to our AWS account but before deployment, we are gonna integrate Thundra APM. 


### 1. Get we Thundra Api Key

APM integration is pretty easy, first we need a Thundra account and Thundra API key. Go to [Thundra](https://start.thundra.io) and sign up free, then choose **Thundra APM**.


![Apm selection](/images/_setting_up/apm_selection.png)
<h5>*we can also check Thundra' Foresight and Sidekick products*</h5>



When we enter the Thundra APM home page we will see the projects section in the lower-left corner of the page, route the page to the projects section and wer API key will appear next to wer default project. Copy it and do not share it with anyone.

![Apm selection](/images/_setting_up/apm_get_api_key.gif)




### 2. Update SAM template

There are a few changes in themplate.yaml file. We will add the Thundra layer to our lambda functions, we can check Thundra docs for all other languages except Node.js.



* First, define the *ThundraNodeLayerVersion* and *ThundraAWSAccountNo* in parameters section. So we can get the lambda layer by using them. 



        Parameters:
            ThundraAWSAccountNo:
                Type: Number
                Default: 269863060030
            ThundraNodeLayerVersion:
                Type: Number
                Default: 105 # Or use any other version



* Second, get the Thundra Layer in global section, also add the *THUNDRA_APIKEY* environment variable using wer Thundra API key.


        Globals:
            Function:
                Environment:
                    Variables:
                        THUNDRA_APIKEY: <YOUR-THUNDRA-API-KEY>
                Layers:
                - !Sub arn:aws:lambda:${AWS::Region}:${ThundraAWSAccountNo}:layer:thundra-lambda-node-layer:${ThundraNodeLayerVersion}

* Finally, replace lambda handlers with Thundra lambda handler.

        Resources:
            DynamoDbWriter:
                Type: AWS::Serverless::Function
                Properties:
                    Handler: thundra_handler.wrapper 
                    ..
                    



    Also add lambda's old handler to the function's environment variables:

        Resources:
            DynamoDbWriter
                ..
                Environment:
                    Variables:
                        THUNDRA_AGENT_LAMBDA_HANDLER: handlers/dynamodb-writer.handler
                ..
                

We integrated the APM to the *DynamoDbWriter* lambda now. Do the final step for our other 2 lambda function. After doing all, template.yaml will look like this:

    AWSTemplateFormatVersion: "2010-09-09"
    Transform: AWS::Serverless-2016-10-31
    Description: AWS Thundra APM Workshop

    Parameters:
        ThundraAWSAccountNo:
            Type: Number
            Default: '269863060030'
        ThundraNodeLayerVersion:
            Type: Number
            Default: '105' 

    Globals:
        Function:
            Timeout: 5
            Environment:
            Variables:
                THUNDRA_APIKEY: 4e4e5098-2c37-4e31-b6bf-1e21c0c75b73 #<Your-Thundra-Api-Key>
            Layers:
            - !Sub arn:aws:lambda:${AWS::Region}:${ThundraAWSAccountNo}:layer:thundra-lambda-node-layer:${ThundraNodeLayerVersion}




    Resources:
        DynamoDbWriter:
            Type: AWS::Serverless::Function
            Properties:
                CodeUri: ./src/
                Handler: thundra_handler.wrapper               
                Runtime: nodejs14.x
                Events:
                    SNSEvent:
                    Type: SNS
                    Properties:
                        Topic: !Ref SnsTopic
                Environment:
                    Variables:
                    THUNDRA_AGENT_LAMBDA_HANDLER: handlers/dynamodb-writer.handler
                    DYNAMODB_TABLE_NAME: !Ref DynamoDBTable
                Policies:
                    - DynamoDBCrudPolicy:
                        TableName: "*"

        SnsWriter:
            Type: AWS::Serverless::Function
            Properties:
                CodeUri: ./src/
                Handler: thundra_handler.wrapper               
                Runtime: nodejs14.x
                Policies:
                    - SNSCrudPolicy:
                        TopicName: "*"
                    - S3ReadPolicy:
                        BucketName: "*"
                Environment:
                    Variables:
                    THUNDRA_AGENT_LAMBDA_HANDLER: handlers/sns-writer.handler
                    S3_BUCKET_NAME: !Ref SrcBucket
                    SNS_TOPIC_ARN: !Ref SnsTopic
                Events:
                    HttpPost:
                    Type: Api
                    Properties:
                        Method: post
                        Path: /

        WebContentRetriever:
            Type: AWS::Serverless::Function
            Properties:
                CodeUri: ./src/
                Handler: thundra_handler.wrapper               
                Runtime: nodejs14.x
                Policies:
                    - DynamoDBCrudPolicy:
                        TableName: "*"
                    - S3ReadPolicy:
                        BucketName: "*"
                Environment:
                    Variables:
                    THUNDRA_AGENT_LAMBDA_HANDLER: handlers/web-retriever.handler
                    DYNAMODB_TABLE_NAME: !Ref DynamoDBTable
                    S3_BUCKET_NAME: !Ref SrcBucket
                Events:
                    GetContent:
                    Type: Api
                    Properties:
                        Method: get
                        Path: /{proxy+}

        SnsTopic:
            Type: AWS::SNS::Topic
            Properties:
                DisplayName: "thundra-workshop-lambda-sns-topic"
                TopicName: "thundra-workshop-lambda-sns-topic"

        DynamoDBTable:
            Type: AWS::DynamoDB::Table
            Properties:
                AttributeDefinitions:
                    - AttributeName: id
                    AttributeType: S
                KeySchema:
                    - AttributeName: id
                    KeyType: HASH
                ProvisionedThroughput:
                    ReadCapacityUnits: 5
                    WriteCapacityUnits: 5

        SrcBucket:
            Type: AWS::S3::Bucket
            DeletionPolicy: Delete

    Outputs:
        S3Bucket:
            Description: "The bucket's name that we will store static web content in it"
            Value: !Ref SrcBucket
        WebContentRetrieverApi:
            Description: "API Gateway endpoint URL for Web Content Retriever function"
            Value: !Sub "https://${ServerlessRestApi}.execute-api.${AWS::Region}.amazonaws.com/Prod"
        SnsWriter:
            Description: "API Gateway endpoint URL for Sns Writer function"
            Value: !Sub "https://${ServerlessRestApi}.execute-api.${AWS::Region}.amazonaws.com/Prod"




### 3. Deploy the application


 In this application, we are using some static files such as our HTML site that will be uploaded to s3, so after deployment of our stack, we need to upload these files to our newly created s3 bucket. 
 
To do this, there is a makefile that deploys the stack and uploads static files to S3  by running the *makefile* command. Also deploying the application and uploading files are be able to do by using *AWS CLI*.

Choose the one of the steps below:

*   **Using Makefile**

    Deploy the application and files by running the*make* command below:

    $ <code>make -f deploy.mk</code>

    After answering a few question, application will be deloyed.


*   **Using AWS CLI Manually**

    Instead of this, deploy the application manually is pretty simple too. 

    *   *First*, deploy the stack:

        $ <code>sam deploy --guided </code>

        Outputs of some of our resources will appear when stack deployment is completed.
        

        ![Deployment Output](/images/_setting_up/deployment_output.png)
        <h5>*Deployment Outputs*</h5>

    *   *Second*, we need the S3 bucket name to upload the files. So copy the *value* where *key* is *S3Bucket* from the outputputs. Use it inside the *aws sycn* command below:

        $ <code>  aws s3 sync static/ s3://< S3 BUCKET NAME >/static/</code> 

        The 3 uploaded files' logs will appear in the terminal.


Both of these ways doing the same job, you will get the same outputs whichever you follow. 