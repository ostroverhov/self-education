package framework.utils;

import aquality.selenium.logger.Logger;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import project.models.ResponseFromApi;

import java.io.IOException;

public class ApiUtils {

    private static final Logger logger = Logger.getInstance();
    private static final String patternStatusCode = "HTTP\\/1\\.1 ([\\d]{3}) ";

    public static ResponseFromApi sendGetRequestXML(String stringRequest) throws Throwable {
        logger.info("Send get request " + stringRequest);
        HttpGet request = new HttpGet(stringRequest);
        ResponseFromApi responseFromApi = new ResponseFromApi();
        try (CloseableHttpResponse response = HttpClients.createDefault().execute(request)) {
            responseFromApi.setStatusCode(RegexpHandler.getNumbers(patternStatusCode, response.getStatusLine().toString()));
            responseFromApi.setBody(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            throw new IOException("Request can't be execute");
        }
        return responseFromApi;
    }
}
