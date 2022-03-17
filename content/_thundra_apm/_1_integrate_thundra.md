---
title: "Thundra Apm Integration"
# date: 2022-02-04T13:24:26+03:00
weight: 8
chapter: true
# pre: "<b>2.3 </b>"
---

## Thundra APM Integration

In the previous section, we've successfully deployed our demo application to AWS and confirmed that it's working without any problem. Let's see what we can do with Thundra APM.

### 1. Get the Thundra API Key

APM integration is pretty easy. First, we need a Thundra account and Thundra API key. Go to [Thundra](https://start.thundra.io) and sign up free, then choose **Thundra APM**.

![APM Selection](/images/_setting_up/apm_selection.png)

After navigating to the Thundra APM home page, we will see the *data source* section in the lower-left corner of the page. In this page, you will see the source types. Since we are integrating NodeJS Lambda functions, select Serverless and go to the **NodeJS** section.

![Get API Key](/images/_setting_up/get_api_key.gif)

The API key will appear at the beginning of this page. The page also shows the Thundra APM integration with *using layer*, you can also check all other integration options from the [APM docs](https://apm.docs.thundra.io/node.js/nodejs-integration-options).

{{% notice info %}}
<p style='text-align: left;'>
When you first log in to the Thundra APM console, you will see some sample data. You can freely browse them and see what's the extend of Thundr APM. These datas will disappear once you send your first invocation data.
</p>
{{% /notice %}}


### 2. Update SAM template

There are a few changes we need to do in the `template.yaml` file. We will add the Thundra layer to our Lambda functions and set the API key that we got earlier.

There are multiple ways to integrate Thundra to your functions. You can see them in our [docs](https://apm.docs.thundra.io/node.js/nodejs-integration-options). For this example, we'll be using Thundra layer and do the handler switch via a `NODE_OPTION` parameter. Since we'll be setting this in our global settings, it'll affect all of our 3 Lambda functions.

So, let's change our `Global` settings in the `template.yaml` to the following.

```yaml
Globals:
  Function:
    Timeout: 5
    Environment:
      Variables:
        THUNDRA_APIKEY: <THUNDRA_APIKEY>
        NODE_OPTIONS: "-r @thundra/core/dist/bootstrap/Lambda"
    Layers:
      - !Sub arn:aws:Lambda:${AWS::Region}:269863060030:layer:thundra-Lambda-node-layer:105
```

### 3. Deploy the changes

Now, since we already applied our SAM template and deployed before, we can simly build the template and re-apply.

{{% notice info %}}
<p style='text-align: left;'>
If you removed the previous stack or just reading this chapter, I suggest you to visit deployment instructions in the [Getting Started](...) chapter.
</p>
{{% /notice %}}


Let's run the following two commands.

```bash
$ sam build

```

This will build the template and warn if it has any issue validating the `template.yaml`. Once it's done, we can deploy our stack.

Beware that when you change something in your template, you need to **build** before you deploy your SAM template.

```bash
$ sam deploy

```

When we see that our stack is successfully updated, we can move on to the next chapter where we trigger our application and check if we see the result on Thundra APM.
