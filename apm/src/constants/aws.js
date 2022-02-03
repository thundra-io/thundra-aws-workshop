const AWS = require('aws-sdk');

const {
    S3_BUCKET_NAME,
    DYNAMODB_TABLE_NAME,
    SNS_TOPIC_ARN
} = process.env;

module.exports = {
    AWS,
    S3_BUCKET_NAME,
    SNS_TOPIC_ARN,
    DYNAMODB_TABLE_NAME,
}
