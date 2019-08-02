package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

class RequestClass {
    private String field1;
    private Integer field2;

    public RequestClass() {
    }

    public RequestClass(String field1, Integer field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Integer getField2() {
        return field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "RequestClass{" +
                "field1='" + field1 + '\'' +
                ", field2=" + field2 +
                '}';
    }
}


class ResponseClass {
    private String body;
    private Integer code;
    private String url;

    public ResponseClass() {
    }

    public ResponseClass(String body, Integer code, String url) {
        this.body = body;
        this.code = code;
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ResponseClass{" +
                "body='" + body + '\'' +
                ", code=" + code +
                ", url='" + url + '\'' +
                '}';
    }
}


public class MyLambdaFunc implements RequestHandler<RequestClass, ResponseClass> {


    public ResponseClass handleRequest(RequestClass input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Step 1 => myCount=" + input);
        try {
            ResponseClass response = new ResponseClass("responce: "
                    + input, 0, "http://ZZZZ/123123");
            logger.log("SUCCESS in handleRequest(" + input + ") call: " + response);
            return response;
        } catch (Exception ex) {
            logger.log("ERRROR in handleRequest(" + input + ") call: " + ex);
            return null;
        }
    }
}