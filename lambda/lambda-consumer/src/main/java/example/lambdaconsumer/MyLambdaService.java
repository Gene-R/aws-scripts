package example.lambdaconsumer;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

import java.util.Map;

public interface MyLambdaService {
    @LambdaFunction(functionName = "javaTestFunc")
    String doSomething(Map<String, Object> input);
}
