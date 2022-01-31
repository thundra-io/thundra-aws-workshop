'use strict';

const { TextAnalyzer } = require('./service/text-analyzer');
const { getBannedWordsFromS3 } = require('./service/s3-reader');

const snsService = require('./service/sns-writer');
const httpStatus = require('./common/http-status');

module.exports.handler = async (event, context) => {

    const body = JSON.parse(event.body);
    const {userName, text} = body;

    const bannedWords = await getBannedWordsFromS3();
    const analyzedText = new TextAnalyzer(text, bannedWords || []);

    const entity = {
        id: Math.random().toString(36).substr(2, 9),
        userName,
        ...analyzedText.toEntity()
    };

    snsService.subscribe();
    const success = await snsService.writeToSNS(entity);

    return {
        statusCode: success ? httpStatus.CREATED : httpStatus.INTERNAL_SERVER_ERROR,
        body: JSON.stringify(success ? entity : {message: 'Failed to write to SNS'})
    };
}

