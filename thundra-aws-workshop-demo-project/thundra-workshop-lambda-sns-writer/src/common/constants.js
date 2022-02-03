const AWS_S3_BUCKET_NAME = process.env.AWS_S3_BUCKET_NAME;
const AWS_S3_BUCKET_KEY = 'static/banned-words.json';

const AWS_SNS_TOPIC_ARN = process.env.AWS_SNS_TOPIC_ARN;
const AWS_DYNAMODB_WRITER_LAMBDA_ARN = process.env.DYNAMODB_WRITER_LAMBDA_ARN;

const AWS_REGION = process.env.AWS_REGION || 'eu-west-1';

const AWS = require('aws-sdk');
AWS.config.update({ region: AWS_REGION });


module.exports = {
    AWS,
    AWS_S3_BUCKET_NAME,
    AWS_S3_BUCKET_KEY,
    AWS_SNS_TOPIC_ARN,
    AWS_DYNAMODB_WRITER_LAMBDA_ARN
}