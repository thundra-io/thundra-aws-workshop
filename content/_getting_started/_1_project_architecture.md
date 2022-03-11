---
title: "Project Architecture"
chapter: true
weight: 4
---

# Project Architecture


We have a simple blog system where we use different AWS resources to manage. We use three different lambda functions in our application that are used to create and read blog posts, as well as an SNS topic to make it asynchronous. We also use an S3 bucket to store some banned words list and HTML files to serve as a frontend.

![Application Architecture](/images/_project_architecture/application-architecture.png)

## Next Step

Now that we have an understanding what our application is about, we can move on to setting up on our AWS account and see how we can monitor using Thundra APM.
