const AWS = require('aws-sdk');
const dynamodb = new AWS.DynamoDB.DocumentClient();

const { AWS_DYNAMODB_TABLE_NAME } = process.env;

const createItemToDynamoDB = async (entity) => {

    if (!AWS_DYNAMODB_TABLE_NAME)
        return false;

    const params = {
        TableName: AWS_DYNAMODB_TABLE_NAME,
        Item: entity
    };

    try {
        await dynamodb.put(params).promise();
        return true;
    } catch (error) {
        return false;
    }
};


module.exports = { createItemToDynamoDB };
