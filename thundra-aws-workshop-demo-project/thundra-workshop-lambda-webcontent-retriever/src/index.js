
const viewUtil = require('./utility/create-view');

const { getDynamoDBEntity } = require('./service/dynamodb-service');
const { getStaticHtmlFile } = require('./service/s3-content-service');

const { TODO_APP, TEXT_ANALYZER } = require('./common/template-resources');

module.exports.handler = async (event, context) => {

    
    const path = event.path === undefined ? event.rawPath : event.path;

    if(!path)
        return viewUtil.createNotFoundView();

    if(path.startsWith('/todo-app')) {
        const html = await getStaticHtmlFile(TODO_APP);
        return viewUtil.createTodoAppView(html);
    }
    else if(path.startsWith('/text-analyzer')) {

        const key = path.split('/text-analyzer/')[1];
        
        if(!key) {
            return viewUtil.createNotFoundView();
        }

        const entity = await getDynamoDBEntity(key);

        if(!entity) {
            return viewUtil.createNotFoundView();
        }

        const html = await getStaticHtmlFile(TEXT_ANALYZER);
        return viewUtil.createTextAnalyzerView(html, entity);
    }
    else
        return viewUtil.createNotFoundView();

};