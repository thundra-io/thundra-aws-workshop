---
title: "Testing the demo project"
weight: 9
chapter: true
---

## Trigger Lambda Function

Monitoring Lambda functions with Thundra APM is now possible. What needs to do is only invoke the Lambda Functions. Let's try to write data to dynamo DB by using the SNS writer function. This function will write data by using the dynamo DB writer function and SNS service.

Here is the flow that we will interact:

![Application Structure](/images/_setting_up/first_flow.png)


You can invoke your function in different ways. Here we will invoke the SNS Lambda by using its API gateway and using the test section in the AWS console.

#### Option 1 : Using AWS Console

Testing a Lambda function from AWS console is pretty simple,  go to the test section in SNS writer lambda and test the function by using the event below:

    {
        "body": "{\n    \"username\":\"Demo User\",\n    \"text\":\"AWS Lambda is an event-driven, serverless computing platform provided by Amazon as a part of Amazon Web Services.\"\n}"
    }

![Application Structure](/images/_setting_up/aws_console_test.png)

#### Option 2  : Using API Gateway

Thanks to the API gateway of SNS Lambda that we added we can invoke our function from using HTTP requests. Here, we will trigger the function by sending a request from the terminal by using *curl*.

To do this, we need to get the SNS Lambda's endpoint, in the previous section we mentioned the outputs of resources that printed to the terminal after the deployment is completed. Get the *value* from where *key* is *SnsWriter* which is the Sns Writer Lambda endpoint.

![Deployment Output](/images/_setting_up/deployment_output.png)
        <h5>*Deployment Outputs*</h5>

Then use it inside the command below:



```sh
$ curl -d '{"username":"Demo User","text":"AWS Lambda sample."}' < YOUR LAMBDA ENDPOINT >
```



#### Check the Integration


After doing one of these, the lambda function will be able to be observable in Thundra APM. To check this, go to the [Thundra APM functions page](https://apm.thundra.io/functions), you will see Sns Writer and DynamoDB Writer Lambda function's details.


Both of these functions' details are listed here even we triggered one of them because the Sns Writer Lambda triggers DynamoDB Lambda.



![Function Page](/images/_setting_up/functions_page_2_functions.png)
