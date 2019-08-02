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
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@SpringBootApplication
public class LambdaConsumerApplication {


    @RequestMapping("/test")
    public String lambdaTest() {


//		client.setRegion(Region);
//		AWS.config.credentials = new AWS.CognitoIdentityCredentials({ IdentityPoolId: 'us-east-2:194da67f-6e30-4832-8440-37886e82cbe4' });
//
//		console.log('Lambda function variable declaration ...');
//		var lambda = new AWS.Lambda({ region: REGION, apiVersion: '2015-03-31' });
//		console.log('create JSON object for parameters for invoking Lambda function ...');
//		var pullParams = {
//				//FunctionName: 'lambdaTest000',
//				FunctionName: 'listS3buckets',
//				InvocationType: 'RequestResponse',
//				LogType: 'None'
//};


//		CreateFunctionRequest request = new CreateFunctionRequest().withFunctionName("javaTestFunc").withRuntime("java8")
//				//replace with the actual arn of the execution role you created
//				//.withRole("arn:aws:iam::123456789012:role/service-role/role-name")
//				//is of the form of the name of your source file and then name of your function handler
//				//.withHandler("souce_file.handler_name")
//				.withCode(new FunctionCode()).withDescription("").withTimeout(15).withMemorySize(128).withPublish(true)
//				.withVpcConfig(new VpcConfig());


        try {
            //AWSLambda client = AWSLambdaClientBuilder.standard().build();
            Map<String, Object> inputData = new LinkedHashMap<>();
            inputData.put("my-input-data1", 201777);
            inputData.put("my-input-data2", 201888);
            inputData.put("my-input-data3", 201999);
//            JsonDataConverter jsonStr = new JsonDataConverter();

            InvokeRequest request = new InvokeRequest().withFunctionName("javaTestFunc")
                    .withPayload("{\"my-input-data1\": 201777},\"my-input-data2\": 201333,\"my-input-data3\": 20155");

//				.withInvocationType("Event").withLogType("Tail").withClientContext("MyApp")
//				.withPayload(ByteBuffer.wrap("fileb://file-path/input.json".getBytes())).withQualifier("1")



            final MyLambdaService mySvc = LambdaInvokerFactory.builder()
                    .lambdaClient(AWSLambdaClientBuilder.defaultClient())
                    .build(MyLambdaService.class);
            String res = mySvc.doSomething(inputData);
            return res;
        } catch (Exception ex) {
            return ex.toString();
        }


    }

    public static void main(String[] args) {
        SpringApplication.run(LambdaConsumerApplication.class, args);
    }

}
