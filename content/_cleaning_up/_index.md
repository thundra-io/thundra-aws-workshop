---
title: "Cleaning Up"
chapter: true
weight: 20
---

# Cleaning Up

To clean up the resources we created usin SAM on AWS, we first need to empty the S3 Bucket we've created.

```bash
$ aws s3 rm s3://<BUCKET_NAME> --recursive

```

Once the static files we've uploaded got deleted, we can simply run the following command and approve to delete the rest of the CloudFormation stack.


```bash
$ sam delete --stack-name <STACK_NAME>

```

If you encountered any issue while deleting the stack, simply visit the CloudFormation on AWS Console.
