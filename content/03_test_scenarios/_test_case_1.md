---
title: "Test Case #1"
chapter: true
weight: 6
pre: "<b>3.1 </b>"
---

# Test Case \#1

In our **Test Case #1**, we'll try to uncover an error in one of our lambdas using the capabilities of Thundra Foresight.

Let's checkout to the Test #1's branch by running the following command.

```bash
git checkout test-js-summit-2021/test-1
```

At this point, make sure to set your credentials correct in the `Makefile` and that Docker is ready and available.

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

![Thundra Foresight](/images/_test_scenarios/_test_1/terminal-failure.png)

And on Foresight, outcome is as such;

![Thundra Foresight](/images/_test_scenarios/_test_1/foresight-testrun-failure.png)

When we click the repository details, we'll encounter a page where our tests are sorted for various filters. We can click the specific test on the left handside to get to the details.

![Thundra Foresight](/images/_test_scenarios/_test_1/foresight-failed-testrun-detail.png)

In there, let's click to the `Trace Map` button to see our test's activity.

![Thundra Foresight](/images/_test_scenarios/_test_1/foresight-testsuite-failure.png)

In the opened window, we see the trace map. Let's click the lambda that's marked as red.

![Thundra Foresight](/images/_test_scenarios/_test_1/failed-trace-map.png)

This will open up the chart and if we click the lambda's span at the top, we'll get the request/response data from this invocation.

![Thundra Foresight](/images/_test_scenarios/_test_1/failed-trace-chart.png)

As you can see, the error we got is pretty clear. Let's check the code and see what's happening for this lambda. The handler for this lambda is in **blogApi.js**.

In line 46, we see that there is a typo in one of that status.

![Thundra Foresight](/images/_test_scenarios/_test_1/typo-in-code.png)

Let's fix the status as `SUBMITTED` and run the tests again. This time, our test should pass. Again, you can see the outcome on Thundra Foresight as before.

![Thundra Foresight](/images/_test_scenarios/_test_1/terminal-success.png)
