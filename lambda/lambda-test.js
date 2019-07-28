console.log('Import AWS SDK ...');
var AWS = require('aws-sdk/dist/aws-sdk-react-native');

var REGION = 'us-east-2';

var AWS = require('aws-sdk');
AWS.config.update({
  region: REGION
});

console.log('Configure SDK for JS ...');
AWS.config.update({ region: REGION });
AWS.config.credentials = new AWS.CognitoIdentityCredentials({ IdentityPoolId: 'us-east-2:194da67f-6e30-4832-8440-37886e82cbe4' });

console.log('Lambda function variable declaration ...');
var lambda = new AWS.Lambda({ region: REGION, apiVersion: '2015-03-31' });
console.log('create JSON object for parameters for invoking Lambda function ...');
var pullParams = {
    //FunctionName: 'lambdaTest000',
    FunctionName: 'listS3buckets',
    InvocationType: 'RequestResponse',
    LogType: 'None'
};

console.log('create variable to hold data returned by the Lambda function ...');
var pullResults;
var data;
var error;


console.log('Invoking lambda function ...');
lambda.invoke(pullParams, function (error, data) {
    if (error) {
        console.log("ERROR: " + error);
    } else {
        console.log("Success!!!");
        console.log(data);
        pullResults = JSON.parse(data.Payload);

        console.log('DATA:' + pullResults.errorMessage);

        console.log('CODE:' + pullResults.statusCode);
        console.log('BODY:' + pullResults.body);
    }
});

