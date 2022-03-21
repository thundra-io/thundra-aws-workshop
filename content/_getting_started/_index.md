---
title: "Getting Started"
chapter: true
weight: 2
# pre: "<b>1. </b>"
---

# Introduction

In this workshop, we will deploy a demo application that uses some of AWS resources such as AWS Lambda, SNS, and DynamoDB. After we deployed the demo application, we will integrate our code with Thundra APM and examine the benefits it brings.

### Prerequisite

Before we start getting our hands dirty, we should set up the necessary stuff to make progress throughout the workshop.

1. NodeJS
    - See [NodeJS](https://nodejs.org/en/).
    - Version 14.x or higher should suffice.
    - NPM should be installed together with it. However, if you plan to use Yarn, see [Yarn](https://yarnpkg.com/).
2. Git SCM
    - See [Git SCM](https://git-scm.com/).
    - We'll be hosting our source-code on [GitHub](https://github.com/).
3. GitHub Account
    - See [GitHub](https://github.com/).
    - This part is only necessary if you want to follow the Thundra Foresight CI monitoring section.
4. Java
    - See [Java Download Options](https://www.java.com/en/download/help/download_options.html/).
    - See [SDKMAN](https://sdkman.io/) for an easy setup.
    - Version 8 will suffice.
    - This part is only necessary if you want to follow the Thundra Foresight Selenium and test monitoring section.
4. AWS Account
    - See [Amazon AWS Console](https://aws.amazon.com/).
    - We'll be using mostly **serverless** resources and we'll clear everything we've created at the end of our workshop. However, beware that betwen these times, our usage of these resources will be billable. Although, it should not be more than a few dollars. Of course, it's still depending on our usage.
5. AWS CLI
    - See [AWS CLI User Guide](https://docs.aws.amazon.com/cli/latest/userguide/).
6. AWS SAM
    - See [AWS SAM User Guide](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-getting-started.html).
    - We need AWS SAM to deploy our application and resource as a CloudFormatin Stack.

Once these prerequisites are set up and ready, we can clone our source-code and start working.

Let's talk about our project's architecture and what we are going to use.
