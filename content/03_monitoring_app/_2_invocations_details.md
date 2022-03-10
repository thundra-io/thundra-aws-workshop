---
title: "Invocation Details"
date: 2022-02-04T13:57:27+03:00
weight: 11
pre: "<b>3.2 </b>"
chapter: true
---

## Invocation Details of Lambda

You can navigate to the Invocations tab by selecting any function. Invocation details that Thundra APM provides help us to understand Lamda Function's behavior and the function's invocation history can be observed in more detail.

In this context, the resource usage change of the Lambda Function is observable for repeated invocations.

![Invocations Summary](/images/_monitoring/invocations_summary.gif)

### Trace Chart

There is a trace chart in each invocation, these resource usages can be studied in more detail by selecting any invocation. You can navigate the  trace chart by selecting any invocation.

On the trace chart page, all interactions of the function are represented. Each request and response between other resources and the Lambda Function can be examined on this page. For instance, here we can see the requests, responses, and other details of the interactions of the SNS Writer Lambda Function with the SNS service and S3 Bucket.


![Trace Chart](/images/_monitoring/trace_chart.gif)


### Trace Map

Trace map is the visualization of the resource's all interactions for an invocation. It provides a visual look at a transaction with a flowchart representation, which helps to easily understand a specific trace.

![Trace Map](/images/_monitoring/trace_map.png)

Here the APM created a scheme of the flow we explained in the introduction section. Each time spent between resources can be observable in this scheme. Also, the resource's details can be studied by selecting a resource's icon here, such as the trace map section.
