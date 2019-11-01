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

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class ApiUtils {

    private static final Logger logger = Logger.getInstance();

    public static String sendGet(String stringRequest, String encoding) throws Throwable {
        logger.info("Send get request " + stringRequest);
        HttpGet request = new HttpGet(stringRequest);
        return executeRequest(request, encoding);
    }

    public static String sendPost(String stringRequest, String jsonString, String encoding) throws Throwable {
        logger.info("Send post request " + stringRequest);
        HttpPost post = new HttpPost(stringRequest);
        post.setEntity(new StringEntity(jsonString, APPLICATION_JSON));
        return executeRequest(post, encoding);
    }

    private static String executeRequest(HttpRequestBase httpRequestBase, String encoding) throws Throwable {
        logger.info("Get response from request");
//        String encoding = Base64.getEncoder().encodeToString((ReaderUtils.getParameter("login") + ":" + ReaderUtils.getParameter("password")).getBytes());
        httpRequestBase.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        httpRequestBase.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        try (CloseableHttpResponse response = HttpClients.createDefault().execute(httpRequestBase)) {
            String responseEntity = EntityUtils.toString(response.getEntity());
            logger.info("Get response entity " + responseEntity);
            return responseEntity;
        } catch (IOException e) {
            throw new IOException("Request can't be execute");
        }
    }
}
