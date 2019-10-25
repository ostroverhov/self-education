package framework.utils;

import aquality.selenium.logger.Logger;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Base64;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class ApiUtils {

    private static final Logger logger = Logger.getInstance();

    public static String sendGet(String stringRequest) throws Throwable { //todo вынести
        logger.info("Send get httpGet " + stringRequest);
        HttpGet httpGet = new HttpGet(stringRequest);

        String encoding = Base64.getEncoder().encodeToString((ReaderUtils.getParameter("user") + ":" + ReaderUtils.getParameter("password")).getBytes());
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        System.out.println("executing httpGet " + httpGet.getRequestLine());
        try (CloseableHttpResponse response = HttpClients.createDefault().execute(httpGet)) {
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new IOException("Request can't be execute");
        }
    }

    public static String sendPost(String stringRequest, String jsonString) throws Throwable {
        HttpPost httpPost = new HttpPost(stringRequest);

        String encoding = Base64.getEncoder().encodeToString((ReaderUtils.getParameter("user") + ":" + ReaderUtils.getParameter("password")).getBytes());
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);
        System.out.println("executing request " + httpPost.getRequestLine());
        httpPost.setEntity(new StringEntity(jsonString, APPLICATION_JSON));
        try (CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost)) {
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new IOException("Request can't be execute");
        }
    }


}
