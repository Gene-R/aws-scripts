package example.lambdaconsumer;

import java.util.Map;

public class RequestClass {
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
