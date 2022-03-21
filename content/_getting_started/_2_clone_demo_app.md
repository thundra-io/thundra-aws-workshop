---
title: "Clone the demo project"
# date: 2022-02-04T13:21:12+03:00
weight: 6
chapter: true
# pre: "<b>2.1 </b>"
---

### Source Code

We'll clone our project to somewhere appropriate in our computer.

```bash
# Change the URL to HTTPS if you don't have SSH configured for git.
# https://github.com/thundra-io/thundra-aws-workshop-codebase.git
git clone git@github.com:thundra-io/thundra-aws-workshop-codebase.git
```

After cloning is finished, we can open the project in an editor or and IDE of your choosing. There, we can see the details about the project and its placement.

The most important file in the project is the `template.yaml` file which defines the resource we are going to create using AWS SAM.

Let's deploy our application to AWS first and then we'll move on with the Thundra APM integration.
