---
title: "Create AWS Account"
date: 2022-02-05T01:43:33+03:00
chapter: true
weight: 2
---

# Create AWS Account


{{% notice warning %}}

You are responsible for the cost of the AWS services used while running this workshop in your AWS account. We highly recommend you to create a separate AWS Trail account for this workshop.
{{% /notice %}}


* <b>If you do not have any AWS account, you can create one by the instructions ➡️ [Create an AWS Account](https://aws.amazon.com/tr/getting-started/)</b>
* <b>If you already have an AWS account, you can follow the instructions below.</b>


### Create a new user from AWS Account

1. Go to the AWS console: https://console.aws.amazon.com/

2. Click on the **IAM** tab
![AWS IAM Section](/images/create-accounts/create-aws-account/open-iam-console.png)

3. Click on the **Users** tab, then **Add Users** button
![Create User](/images/create-accounts/create-aws-account/create-user.gif)

4. Enter a username
5. Select **Access key - Programmatic access** type
6. Click Next
![Create User](/images/create-accounts/create-aws-account/create-user.png)

7. Now Select **Adminitstrator** role, then click **Next**
![Select Permissions](/images/create-accounts/create-aws-account/select-perms.png)

8. Do not need to do any additional steps just clicking the "**Next**" button
9. Now, Copy the access key and secret key
![AWS CLI Configure](/images/create-accounts/create-aws-account/user-secret.png)

10. Then, configure your AWS user credentials in the **AWS CLI**.

**INSTALL:** If AWS CLI is not installed, you must install the AWS CLI by following the instructions ➡️ [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html) 

![AWS CLI Configure](/images/create-accounts/create-aws-account/aws-cli-screen.png)


---
#### Next Step :arrow_right: [Pre-Requirements](/pre-requirements.html)