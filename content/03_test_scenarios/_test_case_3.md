---
title: "Test Case #3"
chapter: true
weight: 8
pre: "<b>3.3 </b>"
---

# Test Case \#3

In our **Test Case #3**, we'll try to uncover another error in one of our lambdas using the capabilities of Thundra Foresight.

Let's clear what we've done in Test #3 and checkout to Test #3's branch with the following command.

```bash
git checkout test-js-summit-2021/test-3
```

Again, make sure to set your credentials correct in the `Makefile` and that Docker is ready and available.

> If you've already in a virtual environment, you can skip this part.

Let's start by creating a virtual environment for Python as we'll need for both LocalStack and AWS Local CLI.

```bash
# To create a virtual environment
python3 -m venv .venv

# and then to activate it
. .venv/bin/activate
```

Once it's activated, we should see `(.venv)` at the beginning of our shell session.

Let's install the dependencies.

```bash
make install
```

And then, run the tests with;

```bash
make test
```

After some time, we can see that our test has failed.

![Thundra Foresight](/images/_test_scenarios/_test_3/terminal-failure.png)

Again, if we follow the same route on Thundra Foresight and open our Trace Map, we can see the following outcome.

![Thundra Foresight](/images/_test_scenarios/_test_3/failed-trace-map.png)

So, normally, we expect our `blogPostReplicator` to connect `ElasticSearch` and replicate the given input.

Let's click the replicator lambda and see what went wrong this time. In the trace chart, we're seeing a little **bug** icon. Let's click that span.

![Thundra Foresight](/images/_test_scenarios/_test_3/failed-trace-chart.png)

Here, we encounter a code section where we play and debug the execution that's happened.

![Thundra Foresight](/images/_test_scenarios/_test_3/time-travel-debugging.png)

Let's click the next arrow and see where it went wrong.

![Thundra Foresight](/images/_test_scenarios/_test_3/time-travel-debugging-2.png)

> To learn more about Time Travel Debugging, click here.

Interesting... The `partition` variable comes out as `0` and that fails to complete the next action in our flow.

When we check the code, changing `if (partition)` to `if (partition != undefined)` will give us the expected behaviour.

So, let's find the function in our `src/service/blogPostService.js` and change the if check.

![Thundra Foresight](/images/_test_scenarios/_test_3/correct-code.png)

Let's run our test again.

![Thundra Foresight](/images/_test_scenarios/_test_3/terminal-success.png)

Great, our test is passing now.
