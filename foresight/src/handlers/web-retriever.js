const viewHelper = require('../helpers/view');

const { getDynamoDBEntity } = require('../helpers/dynamodb');
const { getStaticContent } = require('../helpers/s3');

const { TODO_APP, TEXT_ANALYZER } = require('../constants/template-resources');

module.exports.handler = async (event, context) => {
    const path = event.path || event.rawPath;

    if (!path) {
        return viewHelper.createNotFoundView();
    }

    if (path === '/todo-app') {
        const html = await getStaticContent(TODO_APP);
        return viewHelper.createTodoAppView(html);
    } else if (path.startsWith('/text-analyzer')) {
        const id = path.split('/text-analyzer/')[1];

        if (!id) {
            return viewHelper.createNotFoundView();
        }

        const entity = await getDynamoDBEntity(id);

        if (!entity) {
            return viewHelper.createNotFoundView();
        }

        const html = await getStaticContent(TEXT_ANALYZER);
        return viewHelper.createTextAnalyzerView(html, entity);
    }

    return viewHelper.createNotFoundView();
};
