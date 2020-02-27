package project.utils;

import aquality.selenium.logger.Logger;
import framework.utils.JsonUtils;
import framework.utils.ReaderUtils;
import org.testng.Assert;
import project.models.BodyStab;
import project.models.Response;
import project.models.ResponseFromApi;

import java.util.HashMap;
import java.util.Map;

public class MappingUtils {

    private static final Logger logger = Logger.getInstance();

    public static String createStringRequest(String request) {
        logger.info("Create string request");
        return String.format(ReaderUtils.getParameter("urlApi"), ReaderUtils.getParameter("port"), request);
    }

    public static String createStringRequestWithParameters(String request, HashMap<String, String> parameters){
        logger.info("Create string request with parameters");
        StringBuilder builder = new StringBuilder();
        builder.append(createStringRequest(request)).append("?");
        for (Map.Entry<String, String > entry:parameters.entrySet()) {
            builder.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return builder.toString();
    }

    public static void assertResponses(ResponseFromApi responseSendStub, ResponseFromApi responseCheckStub){
        logger.info("Assert stumb");
        Response responseFromStub = JsonUtils.jsonToObject(responseSendStub.getBody(), BodyStab.class).getResponse();
        Assert.assertEquals(new ResponseFromApi().setBody(responseFromStub.getBody()).setStatusCode(String.valueOf(responseFromStub.getStatus())),
                responseCheckStub, "Check stub");
    }
}
