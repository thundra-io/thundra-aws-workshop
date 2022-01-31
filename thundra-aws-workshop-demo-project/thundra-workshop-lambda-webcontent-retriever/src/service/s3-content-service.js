const { AWS, AWS_S3_BUCKET_NAME } = require('../common/constants');
const s3 = new AWS.S3();


const getStaticHtmlFile = async (key) => {
    const params = {
        Bucket: AWS_S3_BUCKET_NAME,
        Key: key
    };

    try {
        const data = await s3.getObject(params).promise();
        return data.Body.toString('utf-8');
    }
    catch (error) {
        console.log(error);
        return "<h1>Error</h1>";
    }

}


module.exports = { getStaticHtmlFile};