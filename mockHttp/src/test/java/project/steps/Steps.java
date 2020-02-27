package project.steps;

import aquality.selenium.logger.Logger;
import framework.utils.ApiUtils;
import framework.utils.JsonUtils;
import framework.utils.ReaderUtils;
import org.testng.Assert;
import project.models.BodyStab;
import project.models.Response;
import project.models.ResponseFromApi;
import project.utils.MappingCreator;

import java.util.HashMap;
import java.util.Map;

public class Steps {

    private static final Logger logger = Logger.getInstance();
    private static final String stringRequestToMapping = "/__admin/mappings";
    private static final String stringRequestToRecord = "/__admin/recordings/snapshot";
    private static final String urlMappingOne = "/plaintext/mapping1/";
    private static final String urlMappingTwo = "/jsontext/mapping2/";
    private static final String nameQueryParameter = "testqueryparam";
    private static final String queryParameter = "query";
    private static final String urlMappingThree = "/jsontext/mapping3";
    private static final String urlMappingFour = "/*";
    private static final String headerForThirdRequest = "CustomValue";

    public static String sendMappingOneAndCheck() {
        logger.info("Send mapping and check");
        String jsonBodyStab = MappingCreator.getFirstMapping(urlMappingOne);
        assertResponses(ApiUtils.sendPost(createStringRequest(stringRequestToMapping), jsonBodyStab, ""),
                ApiUtils.sendGet(createStringRequest(urlMappingOne)));
        return JsonUtils.jsonToObject(jsonBodyStab, BodyStab.class).getResponse().getBody();
    }

    public static void sendMappingTwoAndCheck() {
        logger.info("Send mapping with parameter and check");
        HashMap<String ,String> parameters = new HashMap<>();
        parameters.put(nameQueryParameter, queryParameter);
        assertResponses(ApiUtils.sendPost(createStringRequest(stringRequestToMapping), MappingCreator.getSecondMapping(urlMappingTwo), ""),
                ApiUtils.sendGet(createStringRequestWithParameters(urlMappingTwo, parameters)));
    }

    public static void sendMappingThreeAndCheck(String bodyFirstMapping) {
        logger.info("Send mapping with parameters body and headers");
        assertResponses(ApiUtils.sendPost(createStringRequest(stringRequestToMapping), MappingCreator.getThirdMapping(urlMappingThree, bodyFirstMapping, headerForThirdRequest), ""),
                ApiUtils.sendPost(createStringRequest(urlMappingThree), bodyFirstMapping, headerForThirdRequest));
        Assert.assertEquals(ApiUtils.sendPost(createStringRequest(urlMappingThree), "", headerForThirdRequest).getStatusCode(),
                ReaderUtils.getParameter("statusNotFound"),
                "Check stub with wrong body");
        Assert.assertEquals(ApiUtils.sendPost(createStringRequest(urlMappingThree), bodyFirstMapping, "").getStatusCode(),
                ReaderUtils.getParameter("statusNotFound"),
                "Check stub with wrong header");
    }

    public static void sendMappingFourAndCheck() {
        logger.info("Send mapping with redirect");
        ApiUtils.sendPost(createStringRequest(stringRequestToMapping), MappingCreator.getFourMapping(urlMappingFour, urlMappingOne), "");
        Assert.assertEquals(ApiUtils.sendGet(createStringRequest(urlMappingFour)),
                ApiUtils.sendGet(createStringRequest(urlMappingOne)),
                "Check redirect stumb");
    }

    public static void deleteAllMappings() {
        logger.info("Delete all mappings");
        ApiUtils.sendDelete(createStringRequest(stringRequestToMapping));
    }

    public static void getAllMappings(){
        logger.info("Get all mappings");
        ApiUtils.sendPost(createStringRequest(stringRequestToRecord), "{}", "");
    }

    private static String createStringRequest(String request) {
        logger.info("Create string request");
        return String.format(ReaderUtils.getParameter("urlApi"), ReaderUtils.getParameter("port"), request);
    }

    private static String createStringRequestWithParameters(String request, HashMap<String, String> parameters){
        logger.info("Create string request with parameters");
        StringBuilder builder = new StringBuilder();
        builder.append(createStringRequest(request)).append("?");
        for (Map.Entry<String, String > entry:parameters.entrySet()) {
            builder.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return builder.toString();
    }

    private static void assertResponses(ResponseFromApi responseSendStub, ResponseFromApi responseCheckStub){
        logger.info("Assert stumb");
        Response responseFromStub = JsonUtils.jsonToObject(responseSendStub.getBody(), BodyStab.class).getResponse();
        Assert.assertEquals(new ResponseFromApi().setBody(responseFromStub.getBody()).setStatusCode(String.valueOf(responseFromStub.getStatus())),
                responseCheckStub, "Check stub");
    }
}
