---
title: "Test Case #2"
chapter: true
weight: 7
pre: "<b>3.2 </b>"
---

# Test Case \#2

In our **Test Case #2**, we'll try to uncover another error in one of our lambdas using the capabilities of Thundra Foresight.

Let's clear what we've done in Test #1 and checkout to Test #2's branch with the following command.

```bash
git checkout test-js-summit-2021/test-2
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

![Thundra Foresight](/images/_test_scenarios/_test_2/terminal-failure.png)

Again, if we follow the same route on Thundra Foresight and open our Trace Map, we can see the following outcome.

![Thundra Foresight](/images/_test_scenarios/_test_2/failed-trace-map.png)

Let's click the erroneous lambda and see what went wrong this time.

![Thundra Foresight](/images/_test_scenarios/_test_2/failed-trace-chart.png)

Now, we see a custom error message that says `Elasticsearch Chaos Injected!`. This is injected by Thundra agent to mimic a failure in our system.

We can find the configuration for this injection in the following file;

![Thundra Foresight](/images/_test_scenarios/_test_2/chaos-file.png)

> To learn more about Chaos Engineering, click here.

If we change the `injectPercentage` to `0`, we can stear clear from this error for now.
