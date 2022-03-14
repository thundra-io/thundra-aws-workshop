---
title: "Monitor Your Workflows"
date: 2022-02-05T01:43:33+03:00
chapter: true
weight: 5
---

# Monitor Your GitHub Action Workflows

After integrating Foresight ([Integrate Foresight](/integrate-foresight/connect-github-workflow.html))  with Github Actions Workflow, you can monitor your workflows in the Thundra Foresight dashboard.

1. Open the Thundra Foresight Dashboard

2. Select the project where we have created at [Pre-requirements](/pre-requirements.html) in the dashboard

3. Click the project name to see more details
![Open Project](/images/monitor-workflow/01.png)


## Overall Workflows Overview

Now you can see the details of github action workflows on the dashboard.
![Github Actions Workflows](/images/monitor-workflow/02.png)

🚩 **Click one of the workflow-runs to see more details.**

## Workflow Runs Detail
![More Details](/images/monitor-workflow/04.png)


#### 1. Repository and Workflow Information Section
This section shows the repository and the workflow information. You can see the execution time, commit information, branch information, and the workflow status.

#### 2. Workflow Jobs Section
This section shows the jobs of the workflow. There may be multiple jobs in the workflow. If you select one of the jobs, you can reach out to the job details.

#### 3. Workflow Job Details Section
This section shows the job details. You can see each step of the job and success/failure status.

#### 4. Time Consumption Section
This section shows the time consumption of each step of the job.

---
#### Next Step :arrow_right: [Monitor Unit Tests](/monitor-test-results/unit-test.html)