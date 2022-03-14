---
title: "Lambda Integration Tests"
date: 2022-02-05T01:43:33+03:00
chapter: true
weight: 2
---

# Integration Test Result

#### Overview

On the dashboard, you can see two lambda integration tests, **SNS Writer Lambda Integration Tests** and **Web Content Retriever Lambda Integration Tests**. 
![Integration Tests](/images/monitor-test-results/integration-01.png) 

⭐ 1. Web Content Retreiver Lambda Test Suite

⭐ 2. SNS Writer Lambda Test Suite

⭐ 3. Test Case


Each integration test has a connection between local API and lambda function where we deployed at [Run Test Locally](/integrate-foresight/local-tests.html) section.

---

### Performance Details

On the dashboard, you can see the performance metrics of the lambda integration tests.
![Integration Tests](/images/monitor-test-results/integration-02.png)

⭐ 1. Performance Section

⭐ 2. Performance Metrics

---

#### Integration Trace Map

On the dashboard, if you click **Trace Map** button, you can see the integration test trace map.

![Trace Map Button](/images/monitor-test-results/integration-03.png)


⭐ 1. Trace Map Button

![Trace Map](/images/monitor-test-results/integration-04.png)


⭐ 1. Test Case From Local API

⭐ 2. SNS Writer Lambda Endpoint


---

{{% notice note %}}

In this demo project, integration tests do not have any output metrics of **Log**, **Screenshots**
You will see these metrics in the other chapters.

{{% /notice %}}


---
#### Next Step :arrow_right: [Monitor Selenium Tests](/monitor-test-results/selenium-test.html)
