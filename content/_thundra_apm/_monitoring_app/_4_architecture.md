---
title: "Architecture"
# date: 2022-02-04T14:02:33+03:00
weight: 13
# pre: "<b>3.4 </b>"
chapter: true
---

## Architecture

The architecture page visualizes the whole structure of the projects and Lambda Functions that use the Thundra API key we get from the projects page in previous steps of this workshop.

When you navigate to the architecture page, there will be a scheme same as we explained in the Trace Map subtitle inside the Invocation Details section because we triggered only this flow.


![Architerture Old](/images/_monitoring/architecture_old.png)


As you can remember from the introduction of this workshop, the demo application has 1 more Lambda Function named Web Content Retriever. Now, let's invoke this function too and see what is gonna change on this page.


### Trigger Web Content Retriever Lambda

We need 2 things to trigger Web Content Retriever Lambda, first the endpoint of Lambda, the second, the id of one of the rows we wrote in dynamo DB.

 You can get the endpoint of Lambda from the deployment output of the sam template we already mentioned, or you can simply go to this function's API gateway from the AWS console.

For any item id, go to the dynamo DB table and get one of the IDs.

![DynamoDB](/images/_monitoring/dynamodb_items.png)


<code> < Your Retriever Endpoint>/text-anlyzer/< Item Id> </code>

Then, add the text-analyzer keyword at the end of your endpoint and finally add the item id. You will be directed to the text analyzer page which analyzes the given item's text.

![Text Analyzer](/images/_monitoring/text_analyzer.png)


This Lambda read static website files from the S3 bucket and got an item from the dynamo DB, so used some common resources with the SNS Writer Lambda's flow.

#### Examine Whole Architecture

Now let's go to the architecture page and see what is happening.

![Architecture New](/images/_monitoring/architecture.png)

It is the whole flow scheme of the demo application as you can remember. All invoked resources are visualized by Thundra APM here.

In this image, we see that some connections are thicker and some resource images are bigger than others, which means the thicker connections and bigger resource images are invoked more than others.

#### Resource Details

The architecture page allows you to examine resources, you can inspect invocation details of any resource by clicking its image.

![Architecture Details](/images/_monitoring/architecture_with_resource_details.png)


#### Connections

Just as the thickness of these links has meaning, their color also has a meaning. In the example below, we can see the resource fails to access another one and in this scenario, the connections arrow goes red.

![Architecture Error](/images/_monitoring/architecture_with_error.png)
