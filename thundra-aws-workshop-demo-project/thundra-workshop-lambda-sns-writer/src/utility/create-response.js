const createResponse = (statusCode, body) => {
    return {
        statusCode,
        body: JSON.stringify(body)
    };
}

module.exports = createResponse;