---
title: "Error Inspector"
# date: 2022-02-04T14:04:09+03:00
weight: 12
# pre: "<b>3.3 </b>"
chapter: true
---

## Error Inspector

Error inspector page offers you to see all the errors that occurred in your lambda functions without making any extra integration but APM.

You can inspect where errors occurred inside the code, how many times this error in this function occurred or you can set a notification for this error.




When you first navigate to this page, you will see the list of occurred errors in your functions if any exists, you can expand these errors to inspect details. Probably there are no errors on this page in our case, let's create some errors.

We can easily get an error from SNS Writer Lambda. If you check this lambda function's handler in *src/handlers/sns-writer.js*, you see this method that converts JSON to an object in the 13th code line:

    const body = JSON.parse(event.body);

So when you send any event that is not supported by this line, the function will occur an error.

Let's go to test section of AWS Console and try to send the request with one absent bracket like that:

    {
    "body": "\n    \"username\":\"Demo User\",\n    \"text\":\"AWS Lambda is an event-driven, serverless computing platform provided by Amazon as a part of Amazon Web Services.\"\n}"
    }

{{% notice info %}}
<p style='text-align: left;'>
The value of <em>body</em> key should start with curl braces like the example below:
<code>
{
  "body": "<b>{</b> \n    \"username\":\"Demo User\",\n ....\"\n}"
}</code>
</p>
{{% /notice %}}


This should return an error, let's check it from the error inspector in APM.

![Error Inspector](/images/_monitoring/error_inspector.png)



Here we go, we can examine the *stack trace* of error and all other details or create notification for the repetition of this error:

![Error Inspector](/images/_monitoring/create_notification.gif)
