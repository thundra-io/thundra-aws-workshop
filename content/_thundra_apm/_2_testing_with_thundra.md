---
title: "Testing with Thundra"
weight: 9
chapter: true
---

## Trigger Lambda Function

Monitoring our Lambda functions with Thundra APM should be possible now. Let's invoke our functions and see how it looks on Thundra.

Remember our flow from before and how we triggered it. We can do the same here as well.

![First flow](/images/_setting_up/first_flow.png)

You can invoke your function in different ways.

#### Using AWS Console

Testing a Lambda function from AWS console is pretty simple. You just go to the test section in your Lambda's page, SNS Writer for this example, and test the function with using the event below:

    {
        "body": "{\n    \"username\":\"Demo User\",\n    \"text\":\"AWS Lambda is an event-driven, serverless computing platform provided by Amazon as a part of Amazon Web Services.\"\n}"
    }

![AWS Console Test](/images/_setting_up/aws_console_test.png)

#### Using API Gateway

The API Gateway setup in our SNS Writer Lambda function allows us to invoce it using HTTP requests. Here, we will trigger the function by sending a request from the terminal using `curl`.

To do this, we need to get the SNS Lambda's endpoint, in the previous section we mentioned the outputs of resources that printed to the terminal after the deployment is completed. Get the *value* from where *key* is *SnsWriter* which is the Sns Writer Lambda endpoint.

![Deployment Output](/images/_setting_up/deployment_output.png)

Then use it inside the command below:

```sh
$ curl -d '{"username":"Demo User","text":"AWS Lambda sample."}' <SNSWRITER_ENDPOINT>
```

#### Check APM Console

After triggering our function using one of the methods above, we should be able to observe our Lambda functions on Thundra APM. Let's go to the [Thundra APM functions page](https://apm.thundra.io/functions) to see the invocations of our Lambda functions.

![Function Page](/images/_setting_up/functions_page_2_functions.png)

We should see a state that's similar to the above screenshot on Thundra APM.

If that's the case, then perfect! Let's see if we can get more detail.
