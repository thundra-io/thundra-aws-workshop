const { AWS, AWS_SNS_TOPIC_ARN, AWS_DYNAMODB_WRITER_LAMBDA_ARN } = require('../common/constants');

const sns = new AWS.SNS();

var isSubscribed = false;
const subscribe = async () => {
    if (!AWS_SNS_TOPIC_ARN || !AWS_DYNAMODB_WRITER_LAMBDA_ARN) 
        return;

    const params = {
        Protocol: 'lambda',
        TopicArn: AWS_SNS_TOPIC_ARN,
        Endpoint: AWS_DYNAMODB_WRITER_LAMBDA_ARN
    };

    try {
        await sns.subscribe(params).promise();
        isSubscribed = true;
    }
    catch (err) {
        console.log(err);
        isSubscribed = false;
    }
}



const writeToSNS = async (entity) => {
    if (!isSubscribed) 
        return false;

    
    const params = {
        Message: JSON.stringify(entity),
        TopicArn: AWS_SNS_TOPIC_ARN
    };

    try {
        await sns.publish(params).promise();
        return true;
    }
    catch (err) {
        console.log(err);
        return false;
    }

}

module.exports = {
    subscribe,
    writeToSNS
}