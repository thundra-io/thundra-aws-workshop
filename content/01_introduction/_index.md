---
title: "Introduction"
chapter: true
weight: 3
pre: "<b>1. </b>"
---

# Introduction

In this workshop, we're going to launch our distributed application on our local with LocalStack, a tool that emulates AWS services on your machine, and run our tests against it.

We'll have three different test scenarios in three different branches for the sake of simplicity and isolation. Then, we'll see the full trace chart of our distributed, end-to-end tests as well as other features that'll help us diagnose the failures. Such as, Time Travel Debugging and Chaos Engineering...

### Prerequisite

We should have the following requirements set up on our computer.

- AWS CLI
- Node.js 10.x+
- Python 3.6+
- Docker

### Source Code

The project we're going to use is hosted at [https://github.com/thundra-io/serverless-blog-site-workshop](https://github.com/thundra-io/serverless-blog-site-workshop).

Let's clone our project and talk about what it is in the next page.

```bash
# Change the URL to HTTPS if you don't have SSH configured for git.
# https://github.com/thundra-io/serverless-blog-site-workshop.git
git clone git@github.com:thundra-io/serverless-blog-site-workshop.git
```
