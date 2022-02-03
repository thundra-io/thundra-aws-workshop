const { AWS, S3_BUCKET_NAME } = require('../constants/aws');

const s3 = new AWS.S3();

const getStaticContent = async (key) => {
    const params = {
        Bucket: S3_BUCKET_NAME,
        Key: key
    };

    try {
        const data = await s3.getObject(params).promise();
        return data.Body.toString('utf-8');
    }
    catch (error) {
        console.log(error);
        return null;
    }

}


module.exports = {
    getStaticContent
}
