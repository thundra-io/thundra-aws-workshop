const { AWS, SNS_TOPIC_ARN } = require('../constants/aws');

const sns = new AWS.SNS();

const writeToSNS = async (entity) => {
    const params = {
        Message: JSON.stringify(entity),
        TopicArn: SNS_TOPIC_ARN
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
    writeToSNS
}
