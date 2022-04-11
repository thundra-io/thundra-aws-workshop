---
title: "Run Github Actions Workflow"
weight: 1
chapter: true
---

# Run GitHub Actions Workflow

Before we start running the GitHub Action, we need to configure some secrets. Let's take our API Key and Project ID from the repository card that we've created in the previous chapter.

![Get Credentials](/images/_foresight/_integration/get-credentials.png)

![Show Credentials](/images/_foresight/_integration/show-credentials.png)

Let's copy these credentials and move over to our forked repository's settings. In the repository's settings page, go over to the **Secrets**.

![Set Credentials](/images/_foresight/_integration/gh-secret-settings.png)

Click to `New repository secret` and add these following three secret to your repository.

```
- Key:    THUNDRA_APIKEY
  Value:  <YOUR_THUNDRA_APIKEY>

- Key:    THUNDRA_PROJECT_ID
  Value:  <YOUR_THUNDRA_PROJECT_ID>

- Key:    THUNDRA_WORKSHOP_STACK_URL
  Value:  <SNS_WRITER_ENDPOINT>
```

At the end, you should have these secrets ready in your repository.

![Required Secrets](/images/_foresight/_integration/required-secrets.png)

Once this is ready, let's go to the Actions page of the repository and run the workflow.

![Run Workflow](/images/_foresight/_integration/run-workflow.png)

Awesome, let's wait for it to finish and observe Foresight dashboard for results.
