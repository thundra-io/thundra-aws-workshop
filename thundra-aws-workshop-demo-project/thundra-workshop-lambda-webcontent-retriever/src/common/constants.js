const AWS_DYNAMODB_TABLE_NAME = process.env.DYNAMODB_TABLE_NAME;
const AWS_S3_BUCKET_NAME = process.env.S3_BUCKET_NAME;

const AWS = require('aws-sdk');

module.exports = {
    AWS,
    AWS_DYNAMODB_TABLE_NAME,
    AWS_S3_BUCKET_NAME
};

