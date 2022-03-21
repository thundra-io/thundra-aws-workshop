---
title: "Deploy the demo project"
weight: 7
chapter: true
---

### Stack Deployment

Deploying this stack to AWS is pretty simple. We just need to run the following command in the project's directory.

```bash
$ sam deploy --guided

```

If it's the first time we are deploying this stack, it will give us a questionnaire to answer first. With this, we can decide what our stack name is and other properties relating to it.

For the most of it, we can leave it as it is. You can change the **Stack Name** and **AWS Region** as you wish. One thing that you need to do is to say **Y** to the *authorization warning* messages and let SAM know that it's OK to not have it defined.

![AWS SAM CLI Questionnaire](/images/_deployment/sam-cli-questionnaire.png)

Once you answered all the questions, it'll create a changeset first and then start applying the changeset to AWS.

![AWS SAM CLI Changeset](/images/_deployment/sam-cli-changeset.png)

And at the end, it'll show the result of this stack.

![AWS SAM CLI Stack Creation Complete](/images/_deployment/sam-cli-stack-complete.png)

### Static Files

Before we visit the above URLs, we need to send our static HTML files to our S3 Bucket. Let's select the **S3Bucket**'s value from the output above and replace the **\<BUCKET_NAME\>** in the command below.

```bash
$ aws s3 sync static/ s3://<BUCKET_NAME>/static/

```
