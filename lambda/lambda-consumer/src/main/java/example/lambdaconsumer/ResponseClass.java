package example.lambdaconsumer;

public class ResponseClass {
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