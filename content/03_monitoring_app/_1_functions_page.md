---
title: "Functions Summary"
date: 2022-02-04T13:51:44+03:00
weight: 10
pre: "<b>3.1 </b>"
chapter: true
---

## Lambda Functions Summary

All of the functions integrated with Thundra are observable in the Thundra APM console. After logging in to Thundra, these functions are listed on the *functions* page, and summaries of these functions such as invocation time, error count, estimated costs can be examined here.

The flow that contains Sns Writer and DynamoDB Writer was triggered 27 times and in the example below, details about these functions are listed.

![Function Page 15 Minutes](/images/_setting_up/functions_page_15_minutes.png)

For instance, if these functions will keep invoking 27 times every 15 minutes, their cost will be 0.05$ and 0.03$ per month. Also, by changing the time range at the top-right of the page, we can calculate different average costs.

For another example below, the time range changed for 1 hour, now we can see the estimated cost for invoking these functions 27 times per hour will cost us 0.01$ for each, per month.

![Function Page 15 Minutes](/images/_setting_up/functions_page_1_hour.png)


Additionally, the details below can be inspected on this page:

-   Health rate of function, that meant the percentage of the errors on whole invokes.
-   Error count, occurred error count in the given time range.
-   Average duration details of the functions.
