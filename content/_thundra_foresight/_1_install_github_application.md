---
title: "Install GitHub Application"
weight: 1
chapter: true
---

# Thundra Foresight GitHub Integration

We've already prepared a workflow to run the tests on GitHub Actions. Before we start integration Thundra Foresight, let's fork the GitHub repository to our account.

Visit [thundra-io/thundra-aws-workshop-codebase](https://github.com/thundra-io/thundra-aws-workshop-codebase) and click the Fork button on top right. If you want to learn more about **Forks**, visit [GitHub Docs](https://docs.github.com/en/get-started/quickstart/fork-a-repo).

Now that you have the repository in your own account, let's connect Thundra Foresigth to your GitHub account and start watching the forked repository.

Visit Thundra Foresight website: https://foresight.thundra.io/ and login with your Thundra account. In the Foresight dashboard, let's click the **Connecty Repositories** button.

Create a new project and name it as you wish.

![Create Project](/images/_foresight/_integration/create-project.png)

Then, select **GitHub**.
![Select GitHub](/images/_foresight/_integration/select-github.png)

This will redirect you to GitHub to install the Foresight application. In this page, select the account that you want to work with.

![Install GitHub App](/images/_foresight/_integration/select-github.png)


Select the repositories that you want to give access to. For this example, we can select our own repository that we've forked earlier.
![Configure Repos](/images/_foresight/_integration/select-github-repos.png)

This will redirect to the Thundra Foresight web page. Here, you can select the repositories you want to watch. Then, click **Start Watching.**

![Configure Repos In Foresight](/images/_foresight/_integration/select-foresight-repo.png)

Great. Now, you should see the repository card on the dashboard. Let's configure our action and start monitoring our tests.
