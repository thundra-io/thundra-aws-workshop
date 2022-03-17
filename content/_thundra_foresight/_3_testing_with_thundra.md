---
title: "Testing Demo Project"
weight: 9
chapter: true
---

# Run Local Test with Foresight


## Create Project

1. Open the Thundra Foresight Dashboard then select a project or create a new one in the dashboard.

2. Then, get the project API key and Project ID.
![Get Project ID](/images/_foresight/_test_run/test-run-select-repo.png)

3. You will use the API key and Project ID to run the tests.
![Show Repository Secrets](/images/_foresight/_test_run/test-run-get-api-key.png)

4. Clone the git repository.

        git clone git@github.com:thundra-io/thundra-aws-workshop-codebase.git

---

## Run the Tests

{{% notice warning %}}
**INSTALL**: Before running the tests, make sure you have download suitable Chromedriver in "**test**" folder for your Google Chrome. Download here :arrow_right: [Chromedriver](https://chromedriver.storage.googleapis.com/index.html)
{{% /notice %}}


1. Open the project directory then run the **run-test** script.

        ./run-test // for Windows

        ./run-test.sh // for Linux or Mac OS

2. Then type the aws stack name default is **thundra-foresight-aws-workshop**.

3. Then type the aws region default is **eu-west-1**.

4. Now you must put your Thundra API Key and Project ID in the prompts.
![Copy Project ID](/images/_foresight/_test_run/test-run-terminal.png)

5. Now, wait until **all processes** are finished.

6. Your tests will be shown in the dashboard in 4-5 minutes in the **Test Runs** section.
![Open tests](/images/_foresight/_test_run/test-run-monitor-tests.gif)


---

## Monitoring

### Unit Tests

#### Overview

On the dashboard, you can see **Unit Test** section. There are three results, one is **Passed**, rest is **Failed**. You can click on one to see details.

![Unit Tests](/images/_foresight/_test_monitoring/unit-01.png)

⭐ 1. Unit Test Suite

⭐ 2. Unit Test Cases

---

#### Error Details
If the test case is failed then you can see the **Error** section to see error details.

![Unit Tests](/images/_foresight/_test_monitoring/unit-02.png)

⭐ 1. Error Section

⭐ 2. Error Details

⭐ 3. Error Stack Trace

---

#### Performance Details
In this section you can trace the performance metrics of the test case.

![Unit Tests](/images/_foresight/_test_monitoring/unit-03.png)

⭐ 1. Performance Section

⭐ 2. Performance Metrics

{{% notice note %}}

In this demo project, unit tests do not have any output metrics of **Log**, **Screenshots**, and **Trace Map**.
You will see these metrics in the other chapters.

{{% /notice %}}

---


### Lambda Integration Tests


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


---

### Selenium Tests


#### Overview

On the dashboard, you can see **SeleniumTest** section. You can click on one to see details.
![Selenium Test Result](/images/_foresight/_test_monitoring/selenium-01.png)

⭐ 1. Selenium Test Suite

⭐ 2. Selenium Test Case

---

#### Performance Details

In this section you can trace the performance metrics of the test case.

![Selenium Test Result](/images/_foresight/_test_monitoring/selenium-02.png)


⭐ 1. Performance Section

⭐ 2. Performance Metrics

---

#### Logs

In this section you can see the logs of the test case.

![Logs](/images/_foresight/_test_monitoring/selenium-03.png)

⭐ 1. Logs Section

⭐ 2. Logs Outputs

---

#### Screenshots

In this section you can see screenshot feature in Thundra Foresight.

![Screenshots](/images/_foresight/_test_monitoring/selenium-04.gif)

---

#### Trace Map

To click on **Trace Map** button, you can see the Selenium test trace map.
![Trace Map Button](/images/_foresight/_test_monitoring/selenium-05.png)

⭐ 1. Trace Map Button

![Trace Map](/images/_foresight/_test_monitoring/selenium-06.png)

⭐ 1. Test Case From Local API

⭐ 2. Selenium Driver Endpoint


---

### E2E Tests


#### Overview

On the dashboard, you can see **E2ETest** section. You can click on one to see details.

![E2E Test Result](/images/_foresight/_test_monitoring/e2e-01.png)

⭐ 1. E2E Test Suite

⭐ 2. E2E Test Case

---

#### Performance Details

In this section you can trace the performance metrics of the test case.

![E2E Test Performance](/images/_foresight/_test_monitoring/e2e-02.png)


⭐ 1. Performance Section

⭐ 2. Performance Metrics

---

#### Logs

In this section you can see the logs of the test case.

![E2E Test Result](/images/_foresight/_test_monitoring/e2e-03.png)

⭐ 1. Logs Section

⭐ 2. Logs Outputs

---

#### Screenshots
In this section you can see screenshot feature in Thundra Foresight.

![E2E Test Result](/images/_foresight/_test_monitoring/e2e-04.gif)

---

#### Trace Map
To see the trace map, you need to click on the **Trace Map** button.

![E2E Test Result](/images/_foresight/_test_monitoring/e2e-05.png)

⭐ 1. Trace Map Button

![E2E Test Result](/images/_foresight/_test_monitoring/e2e-06.png)

⭐ 1. Test Case From Local API

⭐ 2. Selenium Driver Endpoint

⭐ 3. Lambda Endpoint

---
