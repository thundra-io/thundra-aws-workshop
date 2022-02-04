const { AWS, DYNAMODB_TABLE_NAME } = require('../constants/aws');

const dynamodb = new AWS.DynamoDB.DocumentClient();

const createItemToDynamoDB = async (entity) => {
    if (!DYNAMODB_TABLE_NAME) {
        return false;
    }

    const params = {
        TableName: DYNAMODB_TABLE_NAME,
        Item: entity
    };

    try {
        await dynamodb.put(params).promise();
        return true;
    } catch (error) {
        console.log(error);
        return false;
    }
};


const getDynamoDBEntity = async (itemId) => {
    if (!DYNAMODB_TABLE_NAME) {
        return null;
    }

    const params = {
        TableName: DYNAMODB_TABLE_NAME,
        Key: {
            id: itemId
        }
    };

    try {
        const data = await dynamodb.get(params).promise();
        return data.Item;
    } catch (error) {
        console.log(error);
        return null;
    }
};

module.exports = { getDynamoDBEntity, createItemToDynamoDB };
