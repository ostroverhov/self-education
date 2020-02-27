package framework.utils;

import aquality.selenium.logger.Logger;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import project.models.ResponseFromApi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ApiUtils {

    private static final Logger logger = Logger.getInstance();
    private static final String patternStatusCode = "HTTP\\/1\\.1 ([\\d]{3}) ";

    public static ResponseFromApi sendGet(String stringRequest) {
        logger.info("Send get request " + stringRequest);
        HttpGet request = new HttpGet(stringRequest);
        return executeRequest(request);
    }

    public static ResponseFromApi sendPut(String stringRequest) {
        logger.info("Send put request " + stringRequest);
        HttpPut request = new HttpPut(stringRequest);
        return executeRequest(request);
    }

    public static ResponseFromApi sendDelete(String stringRequest) {
        logger.info("Send delete request " + stringRequest);
        HttpDelete request = new HttpDelete(stringRequest);
        return executeRequest(request);
    }

    public static ResponseFromApi sendPost(String stringRequest, String jsonString, String header) {
        logger.info("Send post request " + stringRequest);
        HttpPost post = new HttpPost(stringRequest);
        post.addHeader("contentType", header);
        try {
            post.setEntity(new StringEntity(jsonString));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return executeRequest(post);
    }

    private static ResponseFromApi executeRequest(HttpRequestBase httpRequestBase)  {
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
            try {
                throw new IOException("Request can't be execute");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return responseFromApi;
    }
}
