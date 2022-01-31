'use strict';

const { createItemToDynamoDB } = require('./service/dynamodb-service');

module.exports.handler = async (event, context) => {
  
  if(!event.Records) 
    return {
      statusCode: 400, // Bad Request
      body: JSON.stringify({
        message: 'No records found in event'
      })
    };

  var notRegisteredEntityCount = 0;
  for (var record of event.Records){
    const snsMessage = record.Sns;
    const entity = JSON.parse(snsMessage.Message);

    Object.keys(entity).forEach(key => {
      if(typeof entity[key] === typeof [])
        entity[key] = entity[key].join(',&nbsp;');
    });

    const status = await createItemToDynamoDB(entity);
    
    if(!status) notRegisteredEntityCount++;
  }

  console.log(`${notRegisteredEntityCount} entities were not registered`);
  return {
    statusCode: 200, // OK
    body: "Successfully processed " + (event.Records.length - notRegisteredEntityCount)  + " records."
  }
};
