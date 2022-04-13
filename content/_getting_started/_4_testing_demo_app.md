---
title: "Testing the demo project"
weight: 7
chapter: true
---

When we first visit the **WebContentRetrieverApi** URL in the stack's output, it'll return a **Not Found** page as expected since we haven't created any post yet. So, let's change that.

We can use `curl` to send a POST request to the **SnsWriter** endpoint. Following `curl` command should be enough. You can change the values as you wish.

Replace the **\<SNSWRITER_ENDPOINT\>** to the correct URL.

```bash
$ curl -d '{"username":"Demo User","text":"AWS Lambda sample."}' <SNSWRITER_ENDPOINT>

```

This will return a response with the blog post object that has an ID similar to the following output:

```json
{"id":"kmpdfce","username":"Demo User","content":"AWS Lambda sample.","textLength":18,"mostUsedWord":["AWS","Lambda","sample"],"leastUsedWord":["AWS","Lambda","sample"],"bannedWord":[],"maxLengthWord":["Lambda","sample"],"minLengthWord":["AWS"]}

```

Let's use the ID of this document and visit the **SNS Writer** endpoint. Make sure to change the ID part to your post's ID.

```text
https://<SNSWRITER_ENDPOINT>/kmpdfce

```

When we visit the post detail page, we should see page that looks like the following:

![Post Detail Page](/images/_testing/post-detail.png)

Great. We can confirm that our application is up and running. Let's add some observability to it via Thundra APM.
