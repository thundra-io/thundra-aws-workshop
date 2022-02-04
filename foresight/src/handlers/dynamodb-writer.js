'use strict';

const { createItemToDynamoDB } = require('../helpers/dynamodb');
const { createResponse } = require('../helpers/view');
const STATUS = require('../constants/http-status');

module.exports.handler = async (event, context) => {
    if (!event.Records) {
        return createResponse(
            STATUS.BAD_REQUEST,
            JSON.stringify({
                message: 'No records found in event'
            })
        );
    }

    let notRegisteredEntityCount = 0;
    for (let record of event.Records) {
        const entity = JSON.parse(record.Sns.Message);

        Object.keys(entity).forEach(key => {
            if (typeof entity[key] === typeof []) {
                entity[key] = entity[key].join(', ');
            }
        });

        const status = await createItemToDynamoDB(entity);

        if (!status) notRegisteredEntityCount++;
    }

    console.log(`${notRegisteredEntityCount} entities were not registered`);

    return createResponse(
        STATUS.SUCCESS,
        `Successfully processed ${event.Records.length - notRegisteredEntityCount} records.`
    );
};
