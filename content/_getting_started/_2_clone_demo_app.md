---
title: "Clone the demo project"
# date: 2022-02-04T13:21:12+03:00
weight: 6
chapter: true
# pre: "<b>2.1 </b>"
---

## Install and Deploy To-Do Application

In this section, we will understand the deployment template and our project structure. It is pretty simple todo-app that uses aws resurces.

Firstly, we will clone the demo application and examine the lambda functions briefly. The part that interests us is what these lambda functions do instead of how these lambda functions work. We already talked about what these functions do in the previous section briefly.

Then, we will integrate Thundra APM to our lambda functions by using the SAM configuration of Thundra APM.

Finally, we simply will trigger our lambda functions and check what will we see in the Thundra console.

Now lets start with cloning the demo project.

### Source Code

We'll clone our project to somewhere appropriate in our computer.

```bash
# Change the URL to HTTPS if you don't have SSH configured for git.
# https://github.com/thundra-io/thundra-aws-workshop-codebase.git
git clone git@github.com:thundra-io/thundra-aws-workshop-codebase.git
```

After cloning is finished, we can open the project in an editor or and IDE of your choosing. There, we can see the details about the project and its placement.

The most important file in the project is the `template.yaml` file which defines the resource we are going to create using AWS SAM.

Let's deploy our application to AWS first and then we'll move on with the Thundra APM integration.

<!--
- **static folder :** In this directory, we have some static files that are needed by our lambda functions. For instance, *bannedwords* file provides the words for SNS service and SnsWriter lambda to filter words in given input, or *todo-app.html* file includes our static web site. We are going to update this to S3 bucket after deploying the application.

- **src folder :** In this directory we have our lambda functions that writed in *node.js* codes. As we mentioned, we don't need to know how these functions work but you can examine if you wonder.

- **template.yaml :** It is an extension of the AWS CloudFormation template, we will create a deployment stack for our application by using this. Considering our deployment stack is using AWS SAM template and our lambda functions are written in node.js, we will integrate Thundra APM by following steps in related docs. You can also check other integration options from Thundra APM [docs](https://apm.docs.thundra.io/node.js/nodejs-integration-options). -->
