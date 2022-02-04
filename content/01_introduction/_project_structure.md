---
title: "Project Structure"
chapter: true
weight: 4
---



# Project Structure
We have a to-do app where to-do entries goes though different stages in distrubuted application.
We will understand these stages by examining the scheme below now.  






![Application Structure](/images/_project_structure/application-structure.png)

 There are 3 lambda functions  in our application that we will monitor from Thundra APM and these are the their responsibilities:


-**Sns Writer**: Analyzes the given input and sends a message to the SNS.

-**DynamoDB Writer**: Gets SNS responses and write them to DynamoDB.

-**Web Retrieve**: Retrieves the static website from the s3 bucket and presents the do-to records by getting them from DynamoDB..


## Next Step

Now that we have an understanding what our application is about, we can move on.
