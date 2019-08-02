package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Date;
import java.util.Map;

public class MyLambdaFunc implements RequestHandler<Map<String, Object>, String> {


    public String handleRequest(Map<String, Object> input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Step 1 => myCount=" + input);
        try {
            logger.log("SUCCESS in handleRequest(" + input + ") call");
            logger.log("Step 2 ...");
            return "{\"responseData\": AAAADDDDD=" + new Date().getTime() + "}";
        } catch (Exception ex) {
            logger.log("ERRROR in handleRequest(" + input + ") call: " + ex);
            return null;
        }
    }
}