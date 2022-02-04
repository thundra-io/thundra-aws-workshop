const STATUS = require('../constants/http-status');

const createHTMLResponse = (html) => {
    return {
        statusCode: STATUS.SUCCESS,
        headers: {
            'Content-Type': 'text/html',
        },
        body: html,
    };
}

const createTextAnalyzerView = (html, entity) => {
    Object.keys(entity).forEach(key => {
        html = html.replace(`{{ ${key} }}`, entity[key]);
    });

    return createHTMLResponse(html);
}

const createNotFoundView = () => {
    return {
        statusCode: STATUS.NOT_FOUND,
        headers: {
            'Content-Type': 'text/html',
        },
        body: `<h1>Not Found</h1>`,
    };
}

const createResponse = (statusCode, body) => {
    return {
        statusCode,
        body: body
    };
}

module.exports = {
    createTodoAppView: createHTMLResponse,
    createTextAnalyzerView,
    createNotFoundView,
    createResponse
};
