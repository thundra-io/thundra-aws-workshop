const AWS = require('aws-sdk');
const dynamodb = new  AWS.DynamoDB.DocumentClient();

const { AWS_DYNAMODB_TABLE_NAME, AWS_REGION } = process.env;

AWS.config.update({ region: AWS_REGION || 'eu-west-2' });

const createItemToDynamoDB = async (entity) => {

    if(!AWS_DYNAMODB_TABLE_NAME) 
        return false;

    const params = {
        TableName: AWS_DYNAMODB_TABLE_NAME,
        Item: entity
    };

    try{
        await dynamodb.put(params).promise();
        return true;
    } catch (error) {
        return false;
    }
};


module.exports = { createItemToDynamoDB };