---
title: "Thundra Foresight Integration"
weight: 8
chapter: true
---

# Thundra Foresight Integration

## Create a Foresight Project

1. Visit Thundra Foresight website: https://foresight.thundra.io/

2. Login with your Thundra account
![Foresight Login Page](/images/_foresight/_integration/foresight-login.png)

3. Select **Use Foresight** option
![Thundra Start](/images/_setting_up/thundra-start.png)

4. Now click the **Connect repositories** button
![Connect Repository Button](/images/_foresight/_integration/connect-repositories.png)

5. Then click the **Create Project** link, type your project name and click **Create**
![Create Project Animation](/images/_foresight/_integration/create-project.gif)

---

## Integrate the Project with Foresight

{{% notice info %}}

Before starting, you should have a GitHub account and a repository that has a GitHub Actions workflow.
If you don't have any repository, please fork the repository ➡️ [Demo Repository](https://github.com/thundra-io/thundra-aws-workshop-codebase)

{{% /notice %}}

1. Open the Thundra Foresight Dashboard

2. Select the project that we have created above, in the dashboard.

3. Click on the **Connect repositories** button.
![Select Repo](/images/_foresight/_integration/project-connect-repositories.png)

4. Select **GitHub**.
![Select GitHub](/images/_foresight/_integration/project-select-github.png)

5. **Configure** the repositories.
![Configure Repo](/images/_foresight/_integration/project-configure-github.png)

6. Then select your account to install the Thundra Foresight plugin.
![Configure Account](/images/_foresight/_integration/project-select-github-user.png)

7. Select your repositories to watch workflows and install the plugin.
![Configure Repos](/images/_foresight/_integration/project-select-github-repos.png)

8.  Now you will redirect to the Thundra Foresight web page. You can select the repositories you want to watch. Then, click **Start Watching.**
![Configure Repos In Foresight](/images/_foresight/_integration/project-select-foresight-repo.png)

9. Then you should re-run the GitHub Actions workflow of the repositories you selected. Then, you can see the traces in the Thundra Foresight dashboard.
![Select Project on Dashboard](/images/_foresight/_integration/project-foresight-dashboard.png)

10. You can see the workflow traces in the Thundra Foresight dashboard.
![Select Workflow](/images/_foresight/_integration/project-select-workflow.png)

---

## Monitoring
After choosing the workflow, you can see the detailed traces in the Thundra Foresight dashboard.
![Detailed Workflow](/images/_foresight/_integration/project-integration-monitoring.png)

#### 1. Repository and Workflow Information Section
This section shows the repository and the workflow information. You can see the execution time, commit information, branch information, and the workflow status.

#### 2. Workflow Jobs Section
This section shows the jobs of the workflow. There may be multiple jobs in the workflow. If you select one of the jobs, you can reach out to the job details.

#### 3. Workflow Job Details Section
This section shows the job details. You can see each step of the job and success/failure status. In addition, you can see the time consumed by each step.
