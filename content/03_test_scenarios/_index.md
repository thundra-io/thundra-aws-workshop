---
title: "Test Scenarios"
chapter: true
weight: 5
pre: "<b>3. </b>"
---

# Test Scenarios

Now that we have our project's setup on Thundra Foresight and got our credentials, we can set them in our project.

{{% notice info %}}
<p style='text-align: left;'>
If you haven't cloned our project yet, you can do by running the code below.
</p>

```bash
# Change the URL to HTTPS if you don't have SSH configured for git.
# https://github.com/thundra-io/serverless-blog-site-workshop.git
git clone git@github.com:thundra-io/serverless-blog-site-workshop.git
```
{{% /notice %}}

In our project, let's open the `Makefile`. Update `THUNDRA_APIKEY` and `THUNDRA_AGENT_TEST_PROJECT_ID`.

{{% notice warning %}}
<p style='text-align: left;'>
You might need to update the Makefile as we go over the test scenarios and change branches. So, it might be easier to save it somewhere we can copy and paste easily.
</p>
{{% /notice %}}
