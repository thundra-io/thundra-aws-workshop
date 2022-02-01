'use strict';

const { TextAnalyzer } = require('./service/text-analyzer');
const { getBannedWordsFromS3 } = require('./service/s3-reader');

const snsService = require('./service/sns-writer');
const httpStatus = require('./common/http-status');

const createResponse = require('./utility/create-response');

module.exports.handler = async (event, context) => {

    const body = JSON.parse(event.body);

    if(!body)
        return createResponse(httpStatus.BAD_REQUEST, { error: 'Invalid request body' });

    const {userName, text} = body;

    if(!userName || !text)
        return createResponse(httpStatus.BAD_REQUEST, { error: 'Missing username or text' });

    if(typeof userName !== 'string' || typeof text !== 'string')
        return createResponse(httpStatus.BAD_REQUEST, { error: 'Invalid request entity types' });

    const bannedWords = await getBannedWordsFromS3();
    const analyzedText = new TextAnalyzer(text, bannedWords || []);

    const entity = {
        id: Math.random().toString(36).substr(2, 9),
        userName,
        ...analyzedText.toEntity()
    };

    await snsService.subscribe();
    const success = await snsService.writeToSNS(entity);

    return success ? createResponse(httpStatus.CREATED, entity) : 
                     createResponse(httpStatus.INTERNAL_SERVER_ERROR, { error: 'Failed to write to SNS' });
}

