const { AWS, AWS_S3_BUCKET_NAME, AWS_S3_BUCKET_KEY } = require('../common/constants');

const s3 = new AWS.S3();

const getBannedWordsFromS3 = async () => {
    const params = {
        Bucket: AWS_S3_BUCKET_NAME,
        Key: AWS_S3_BUCKET_KEY
    };

    try {
        const data = await s3.getObject(params).promise();
        return JSON.parse(data.Body.toString('utf-8'));
    }
    catch (err) {
        console.log(err);
        return [];
    }
}

module.exports = {
    getBannedWordsFromS3
}