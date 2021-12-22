---
title: "Project Endpoints"
chapter: true
weight: 4
---

# Project Endpoints

We have a simple blog post application where a blog post goes through different stages in a distributed application. Easiest way to understand what's going on is to talk about the endpoints we have.

### Add Blog Post

The basic architecture behind this endpoint looks like this. We have an **API Gateway** that points to an **AWS Lambda**, which passes the incoming request to another lambda to process it through an **SQS Queue**.

This processor lambda then writes the post to a **DynamoDB Table** and triggers an **SNS Topic** to send out a notification to the owner. Once the write to DynamoDB finishes, it'll trigger an event to replicate the post to an **ElasticSearch Index** to make our searching capabilities much easier.

![Add Blog Post Trace](/images/_project_structure/add-blog-post-trace.png)

### Review Blog Post

In this endpoint, we'll get the blog post we've published before and update it's state to `REVIEWED`. You can see the new trace as an extension to the previous trace.

![Review Blog Post Trace](/images/_project_structure/review-blog-post-trace.png)

### Publish Blog Post

In this endpoint, we'll get the blog post we've published before and update it's state to `PUBLISHED`. You can see the new trace as an extension to the previous trace.

![Review Blog Post Trace](/images/_project_structure/publish-blog-post-trace.png)

### Search Blog Post

In this endpoint, we have a simple **AWS Lambda** to perform search in our **ElasticSearch Index**.

![Search Blog Post Trace](/images/_project_structure/search-blog-post-trace.png)

## Next Step

Now that we have an understanding what our application is about, we can move on.
