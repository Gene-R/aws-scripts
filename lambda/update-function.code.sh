cd my-lambda-func
mvn clean install
cd -
[[ $? == 0 ]] && aws lambda update-function-code --function-name "javaTestFunc" --zip-file "fileb://my-lambda-func/target/my-lambda-func-1.0-SNAPSHOT.jar" || echo "Build with error"
