---
title: "Monitoring Integration Tests"
chapter: true
weight: 3
---

# Monitoring Integration Tests


#### Overview

On the dashboard, you can see two Lambda integration tests, **SNS Writer Lambda Integration Tests** and **Web Content Retriever Lambda Integration Tests**.
![Integration Tests](/images/_foresight/_test_monitoring/integration-01.png)

⭐ 1. Web Content Retreiver Lambda Test Suite

⭐ 2. SNS Writer Lambda Test Suite

⭐ 3. Test Case


Each integration test has a connection between local API and Lambda function where we deployed at [Run Test Locally](/integrate-foresight/local-tests.html) section.

---

#### Performance Details

On the dashboard, you can see the performance metrics of the Lambda integration tests.
![Integration Tests](/images/_foresight/_test_monitoring/integration-02.png)

⭐ 1. Performance Section

⭐ 2. Performance Metrics

---

#### Integration Trace Map

On the dashboard, if you click **Trace Map** button, you can see the integration test trace map.

![Trace Map Button](/images/_foresight/_test_monitoring/integration-03.png)


⭐ 1. Trace Map Button

![Trace Map](/images/_foresight/_test_monitoring/integration-04.png)


⭐ 1. Test Case From Local API

⭐ 2. SNS Writer Lambda Endpoint


{{% notice note %}}

In this demo project, integration tests do not have any output metrics of **Log**, **Screenshots**
You will see these metrics in the other chapters.

{{% /notice %}}
