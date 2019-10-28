package framework.utils;

import aquality.selenium.logger.Logger;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Base64;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class ApiUtils {

    private static final Logger logger = Logger.getInstance();

    public static String sendGet(String stringRequest) throws Throwable { //todo вынести
        logger.info("Send get request " + stringRequest);
        HttpGet httpGet = new HttpGet(stringRequest);
        return executeRequest(httpGet);
    }

    public static String sendPost(String stringRequest, String jsonString) throws Throwable {
        logger.info("Send post request " + stringRequest);
        HttpPost httpPost = new HttpPost(stringRequest);
        httpPost.setEntity(new StringEntity(jsonString, APPLICATION_JSON));
        return executeRequest(httpPost);
    }

    private static String executeRequest(HttpRequestBase httpRequestBase) throws IOException {
        String encoding = Base64.getEncoder().encodeToString((ReaderUtils.getParameter("user") + ":" + ReaderUtils.getParameter("password")).getBytes());
        httpRequestBase.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        httpRequestBase.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        try (CloseableHttpResponse response = HttpClients.createDefault().execute(httpRequestBase)) {
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new IOException("Request can't be execute");
        }
    }
}
