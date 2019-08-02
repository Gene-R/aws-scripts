package example.lambdaconsumer;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;
import com.amazonaws.services.lambda.model.*;
import com.amazonaws.services.robomaker.model.VPCConfig;
import com.amazonaws.services.simpleworkflow.flow.JsonDataConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class LambdaConsumerApplication {

    @RequestMapping("/test")
    public String lambdaTest(@RequestParam int id) {
        try {
            RequestClass req = new RequestClass("Test ID", id);
            MyLambdaService mySvc = LambdaInvokerFactory.builder()
                    .lambdaClient(AWSLambdaClientBuilder.defaultClient())
                    .build(MyLambdaService.class);

            ResponseClass res = mySvc.doSomething(req);
            return res.toString();
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(LambdaConsumerApplication.class, args);
    }

}
