import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;

import java.io.IOException;

public class ServletTest {
    @Test
    public void test01() throws IOException {
//        HttpClient httpClient = new HttpClient();
//        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(150);
//        GetMethod getMethod = new GetMethod("http://192.168.8.124:8080/servletDemo");
//        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,60);
//        getMethod.addRequestHeader("Content-Type","application/json");
//        httpClient.executeMethod(getMethod);
//        String response = getMethod.getResponseBodyAsString();
//        getMethod.releaseConnection();
//        System.out.println(response);
    }

    @Test
    public void test02() {
        System.out.println("-----------test0222Success----");
    }
}
