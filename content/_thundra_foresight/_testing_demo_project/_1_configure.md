---
title: "Configuration"
chapter: true
weight: 1
---

# Configuration Local Tests


## Select Project

1. Open the Thundra Foresight Dashboard then select the project that we have created before, in the dashboard.

2. Then, get the project API key and Project ID.
![Get Project ID](/images/_foresight/_test_run/test-run-select-repo.png)

3. You will use the API key and Project ID to run the tests.
![Show Repository Secrets](/images/_foresight/_test_run/test-run-get-api-key.png)

4. Clone the git repository.

        git clone git@github.com:thundra-io/thundra-aws-workshop-codebase.git



## Run the Tests

{{% notice warning %}}
**INSTALL**: Before running the tests, make sure you have download suitable Chromedriver in "**test**" folder for your Google Chrome. Download here :arrow_right: [Chromedriver](https://chromedriver.storage.googleapis.com/index.html)
{{% /notice %}}


1. Open the repository folder you have cloned before in your local machine.

2. Open **.env** file and set the environment variables:

        THUNDRA_APIKEY=<Your Thundra API key>
        THUNDRA_PROJECT_ID=<Your Thundra Project ID>
        THUNDRA_WORKSHOP_STACK_URL=<Your Thundra Workshop Stack URL>

    To **THUNDRA_APIKEY**, you should use Thundra API key that you copied above. <br/>
    To **THUNDRA_PROJECT_ID**, you should use Thundra Project ID that you copied above.<br/>
    To **THUNDRA_WORKSHOP_STACK_URL**, you should get the URL from [Thundra Workshop Stack Deployment](/_getting_started/_3_deploy_demo_app.html)

1. Then run the **run-test** script.

        ./run-test // for Windows

        ./run-test.sh // for Linux or Mac OS

5. Now, wait until **all processes** are finished.

6. Your tests will be shown in the dashboard in 4-5 minutes in the **Test Runs** section.
![Open tests](/images/_foresight/_test_run/test-run-monitor-tests.gif)
