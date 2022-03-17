---
title: "Thundra APM in Details"
weight: 10
# date: 2022-02-04T13:55:52+03:00
chapter: true
---

## Monitor The Application In Thundra APM

We deployed the demo applicaiton and integrated Thundra APM to it, now we can explore APM's features. Home page of Thundra APM is the function page and when you log in to APM, the Lambda functions which are invoked at least one time will be listed.

![Function Page](/images/_setting_up/functions_page_2_functions.png)


{{% notice info %}}
<p style='text-align: left;'>
If you are not able to see any function in this page, check your Lambda dunction Thundra API Key or change the time range from top-right of corner of the page if you sure your API Key is right.
</p>
{{% /notice %}}

Under this section we will examine the subtitels below:

-   Invocations of Lambda Functions.
-   Trace chart and trace map of a Lambda Function.
-   Summary of the project on the dashboard page.
-   Inspecting the errors that integrated Lambda Functions occurred.
-   Setting alerts for desired constraints.
-   General architecture and trace map of the whole project.
