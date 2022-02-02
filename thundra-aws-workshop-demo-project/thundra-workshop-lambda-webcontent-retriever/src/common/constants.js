const DYNAMODB_TABLE_NAME = process.env.DYNAMODB_TABLE_NAME;
const S3_BUCKET_NAME = process.env.S3_BUCKET_NAME;

const AWS = require('aws-sdk');

module.exports = {
    AWS,
    DYNAMODB_TABLE_NAME,
    S3_BUCKET_NAME
};

