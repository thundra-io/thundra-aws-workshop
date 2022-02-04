'use strict';

const STATUS = require('../constants/http-status');

const { TextAnalyzer } = require('../helpers/text-analyzer');
const { writeToSNS } = require('../helpers/sns');
const { getStaticContent } = require('../helpers/s3');
const { createResponse } = require('../helpers/view')

const { BANNED_WORDS } = require('../constants/template-resources')

module.exports.handler = async (event, context) => {
    const body = JSON.parse(event.body);

    if (!body) {
        return createResponse(
            STATUS.BAD_REQUEST,
            JSON.stringify({ error: 'Invalid request body' })
        );
    }

    const { username, text } = body;

    if (!username || !text) {
        return createResponse(
            STATUS.BAD_REQUEST,
            JSON.stringify({ error: 'Missing username or text' })
        );
    }

    if (typeof username !== 'string' || typeof text !== 'string') {
        return createResponse(
            STATUS.BAD_REQUEST,
            JSON.stringify({ error: 'Invalid request entity types' })
        );
    }

    const bannedWords = await getStaticContent(BANNED_WORDS);
    const analyzedText = new TextAnalyzer(text, JSON.parse(bannedWords) || []);

    const entity = {
        id: Math.random().toString(36).substring(2, 9),
        username,
        ...analyzedText.toEntity()
    };

    const success = await writeToSNS(entity);

    if (success) {
        return createResponse(
            STATUS.CREATED,
            JSON.stringify(entity)
        );
    } else {
        return createResponse(
            STATUS.INTERNAL_SERVER_ERROR,
            JSON.stringify({ error: 'Failed to write to SNS' })
        );
    }
}
