---
title: "Clone the demo project"
date: 2022-02-04T13:21:12+03:00
chapter: true
weight: 6
pre: "<b>2.1 </b>"
---




## Clone Demo Application From GitHub
Now have information about the demo application, lets clone the project. 




### Source Code

The project we're going to use is hosted at [https://github.com/thundra-io/](www.google.com).

Let's clone our project and talk about what it is.

    # Change the URL to HTTPS if you don't have SSH configured for git.
    # https://github.com/thundra-io/....
    git clone git@github.com:thundra-io/....


After cloning the project, your folder structure will look like below.
<br><br><br><br><br>
#####  **************  foldertree.png ***********************
<br><br><br><br><br>
We can see 3 main item here:

- **static folder :** In this directory, we have some static files that are needed by our lambda functions. For instance, *bannedwords* file provides the words for SNS service and SnsWriter lambda to filter words in given input, or *todo-app.html* file includes our static web site. We are going to update this to S3 bucket after deploying the application.

- **src folder :** In this directory we have our lambda functions that writed in *node.js* codes. As we mentioned, we don't need to know how these functions work but you can examine if you wonder.

- **template.yaml :** It is an extension of the AWS CloudFormation template, we will create a deployment stack for our application by using this. Considering our deployment stack is using AWS SAM template and our lambda functions are written in node.js, we will integrate Thundra APM by following steps in related docs. You can also check other integration options from Thundra APM [docs](https://apm.docs.thundra.io/node.js/nodejs-integration-options).

