
const {AWS, AWS_DYNAMODB_TABLE_NAME } = require('../common/constants');
const dynamodb = new AWS.DynamoDB.DocumentClient();


const getDynamoDBEntity = async (itemId) => {
    
    if(!AWS_DYNAMODB_TABLE_NAME)
        return null;

    const params = {
        TableName: AWS_DYNAMODB_TABLE_NAME,
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

module.exports = { getDynamoDBEntity };