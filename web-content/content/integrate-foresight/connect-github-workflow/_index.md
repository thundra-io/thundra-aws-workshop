---
title: "Connect GitHub Workflow"
date: 2022-02-05T01:43:33+03:00
chapter: true
weight: 2
---

# Connect GitHub Workflows to Thundra Foresight


{{% notice info %}}

Before starting, you should have a GitHub account and a repository that has a GitHub Actions workflow.
If you don't have any repository, please fork the repository :arrow_right:  [Demo Repository](https://github.com/thundra-io/thundra-aws-workshop-codebase)

{{% /notice %}}

1. Open the Thundra Foresight Dashboard

2. Select the project where we have created at [Pre-requirements](/pre-requirements.html) in the dashboard

3. Click on the **Connect repositories** button.
![Select Repo](/images/integrate-foresight/connect-github/select-repo.png)

4. Select **GitHub**.
![Select GitHub](/images/integrate-foresight/connect-github/select-github.png)

5. **Configure** the repositories.
![Configure Repo](/images/integrate-foresight/connect-github/configure-repo.png)

6. Then select your account to install the Thundra Foresight plugin.
![Configure Account](/images/integrate-foresight/connect-github/install-to-account.png)

7. Select your repositories to watch workflows and install the plugin.
{{% notice info %}}

You can select multiple repositories. If you have already forked the [Demo Repository](https://github.com/thundra-io/thundra-aws-workshop-codebase), you should use it.

{{% /notice %}}
![Configure Repo](/images/integrate-foresight/connect-github/select-github-repository.png)

8. Now you will redirect to the Thundra Foresight web page. You can select the repositories you want to watch.
![Select Repo](/images/integrate-foresight/connect-github/select-git-from-foresight.png)

9. Then you should re-run the GitHub Actions workflow of the repositories you selected. Then you can see the traces in the Thundra Foresight dashboard.
![Select Repo](/images/integrate-foresight/connect-github/open-project.png)

10. You can see the workflow traces in the Thundra Foresight dashboard.
![Select Repo](/images/integrate-foresight/connect-github/final-screen.png)

---
#### Next Step :arrow_right: [Run Local Tests](/integrate-foresight/local-tests.html)