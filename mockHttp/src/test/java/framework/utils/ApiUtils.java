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
import project.models.ResponseFromApi;

import java.io.IOException;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class ApiUtils {

    private static final Logger logger = Logger.getInstance();
    private static final String patternStatusCode = "HTTP\\/1\\.1 ([\\d]{3}) ";

    public static ResponseFromApi sendGet(String stringRequest) throws Throwable {
        logger.info("Send get request " + stringRequest);
        HttpGet request = new HttpGet(stringRequest);
        return executeRequest(request);
    }

    public static ResponseFromApi sendPost(String stringRequest, String jsonString) throws Throwable {
        logger.info("Send post request " + stringRequest);
        HttpPost post = new HttpPost(stringRequest);
        post.setEntity(new StringEntity(jsonString, APPLICATION_JSON));
        return executeRequest(post);
    }

    private static ResponseFromApi executeRequest(HttpRequestBase httpRequestBase) throws Throwable {
        logger.info("Get response from request");
        ResponseFromApi responseFromApi = new ResponseFromApi();
        try (CloseableHttpResponse response = HttpClients.createDefault().execute(httpRequestBase)) {
            String statusLine = response.getStatusLine().toString();
            logger.info("Get status line " + statusLine);
            responseFromApi.setStatusCode(RegExpUtils.getPartFromString(patternStatusCode, statusLine));
            String responseEntity = EntityUtils.toString(response.getEntity());
            logger.info("Get response entity " + responseEntity);
            responseFromApi.setBody(responseEntity);
        } catch (IOException e) {
            throw new IOException("Request can't be execute");
        }
        return responseFromApi;
    }
}
