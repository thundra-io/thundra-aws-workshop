---
title: "Run Local Tests"
date: 2022-02-05T01:43:33+03:00
chapter: true
weight: 3
---

# Run Tests Locally

1. Open the Thundra Foresight Dashboard then select the project where we have created at [Pre-requirements](/pre-requirements.html) in the dashboard.

2. Get the project API key and Project ID.
![Get Project ID](/images/integrate-foresight/run-test/01.png)

3. You will use the API key and Project ID to run the tests.
![Show Repository Secrets](/images/integrate-foresight/run-test/02.png)

4. Create a empty folder in your local machine.

5. Open the folder in your local machine.

6. Clone the git repository.

        git clone https://github.com/thundra-io/thundra-aws-workshop-codebase .

{{% notice warning %}}
**INSTALL**: Before running the tests, make sure you have download suitable Chromedriver in "*test*" folder for your Google Chrome. Download here :arrow_right: [Chromedriver](https://chromedriver.storage.googleapis.com/index.html)
{{% /notice %}}


1. Run the run-test script.

        ./run-test // for Windows
        
        ./run-test.sh // for Linux or Mac OS

2. Then type the aws stack name default is **thundra-foresight-aws-workshop**.

3. Then type the aws region default is **eu-west-1**.

4. Now you must put your Thundra API Key and Project ID in the prompts.
![Copy Project ID](/images/integrate-foresight/run-test/05.png)

5. Now, wait until **all processes** are finished. 

6. Your tests will be shown in the dashboard in 4-5 minutes in the **Test Runs** section.
![Open tests](/images/integrate-foresight/run-test/04.gif)


---

#### Next Step :arrow_right: [Monitor Github Actions Workflow](/monitor-workflow.html)