---
title: "Time Travel Debugging*"
date: 2022-02-04T13:55:43+03:00
weight: 14
pre: "<b>3.5 </b>"
chapter: true
---

## Time Travel Debugging
TimeTravel Debugging makes it possible to travel back in time to previous states of your application by getting a snapshot of when each line is executed. You can step over each line of the code and track the values of the variables captured during execution.

You can easily activate time travel debugging by adding the variable below to environment variables.

    thundra_agent_lambda_trace_instrument_traceableConfig: handlers/sns-writer.*[traceLineByLine=true]

It activates time travel debugging for only *SNS Writer Lambda*. You can modify this for any function you want to activate time travel debugging in.

Check out the [docs](https://apm.docs.thundra.io/node.js/ttd-time-travel-debugging) for more information.

![Offline Debug](/images/_monitoring/offline_debuging.png)
