package framework.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import project.models.ResponseFromApi;

import java.io.IOException;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class ApiUtils {

    private static final String patternStatusCode = "HTTP\\/1\\.1 ([\\d]{3}) ";

    public static ResponseFromApi getRequest(String stringRequest) {
        HttpGet request = new HttpGet(stringRequest);
        ResponseFromApi responseFromApi = new ResponseFromApi();
        try (CloseableHttpResponse response = HttpClients.createDefault().execute(request)) {
            responseFromApi.setStatusCode(RegexpHandler.getStatusCode(patternStatusCode, response.getStatusLine().toString()));
            responseFromApi.setBody(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseFromApi;
    }

    public static ResponseFromApi sendPost(String stringRequest, String jsonString) {
        HttpPost post = new HttpPost(stringRequest);
        ResponseFromApi responseFromApi = new ResponseFromApi();
        StringEntity stringEntity = new StringEntity(jsonString, APPLICATION_JSON);
        post.setEntity(stringEntity);
        try (CloseableHttpResponse response = HttpClients.createDefault().execute(post)) {
            responseFromApi.setStatusCode(RegexpHandler.getStatusCode(patternStatusCode, response.getStatusLine().toString()));
            responseFromApi.setBody(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseFromApi;
    }
}
