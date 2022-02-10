---
title: "Architecture"
date: 2022-02-04T14:02:33+03:00
weight: 15
pre: "<b>3.6 </b>"
chapter: true
---


## Architecture

The architecture page visualizes the whole structure of the projects and Lambda Functions that use the Thundra API key we get from the projects page in previous steps of this workshop.

When you navigate to the architecture page, there will be a scheme same as we explained in the Trace Map subtitle inside the Invocation Details section because we triggered only this flow.


![Architerture Old](/images/_monitoring/architecture_old.png)


As you can remember from the introduction of this workshop, the demo application has 1 more Lambda Function named Web Content Retriever. Now, let's invoke this function too and see what is gonna change on this page.

To do this, we need the API endpoint of the Web Content Retriever Lambda. You can get it from the deployment output of the sam template we already mentioned, or you can simply go to this function's API gateway from the AWS console.


