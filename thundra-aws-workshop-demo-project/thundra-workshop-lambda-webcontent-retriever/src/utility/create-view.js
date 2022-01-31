const httpStatus = require('../common/http-status');

const createHTMLResponse = (html) => {
    return {
        statusCode: httpStatus.SUCCESS,
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
        statusCode: httpStatus.NOT_FOUND,
        headers: {
            'Content-Type': 'text/html',
        },
        body: `<h1>Not Found</h1>`,
    };
}

module.exports = {
    createTodoAppView: createHTMLResponse,
    createTextAnalyzerView,
    createNotFoundView
};