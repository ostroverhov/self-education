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

public class Steps {

    private static final Logger logger = Logger.getInstance();
    private static final String stringRequestToMapping = "/__admin/mappings";
    private static final String stringRequestToRecord = "/__admin/recordings/snapshot";
    private static final String urlMappingOne = "/plaintext/mapping1";
    private static final String urlMappingTwo = "/jsontext/mapping2/?testqueryparam=*";
    private static final String urlMappingThree = "/jsontext/mapping3";
    private static final String urlMappingFour = "/*";
    private static final String pathToFileJson = "src/test/resources/settings.json";

    public static void sendMappingOneAndCheck() {
        assertResponses(ApiUtils.sendPost(createStringRequest(stringRequestToMapping), MappingCreator.getFirstMapping(urlMappingOne)),
                ApiUtils.sendGet(createStringRequest(urlMappingOne)));
    }

    public static void sendMappingTwoAndCheck() {
        assertResponses(ApiUtils.sendPost(createStringRequest(stringRequestToMapping), MappingCreator.getSecondMapping(urlMappingTwo)),
                ApiUtils.sendGet(createStringRequest(urlMappingTwo)));
    }

    public static void sendMappingThree() {
        ApiUtils.sendPost(createStringRequest(stringRequestToMapping), MappingCreator.getThirdMapping(urlMappingThree));
        ApiUtils.sendPost(createStringRequest(urlMappingThree), "qwe");
    }

    public static void sendMappingFour() {
        ApiUtils.sendPost(createStringRequest(stringRequestToMapping), MappingCreator.getFourMapping(urlMappingFour, createStringRequest(urlMappingOne)));
        ApiUtils.sendPut(createStringRequest(urlMappingFour));
    }

    public static void deleteAllMappings() {
        ApiUtils.sendDelete(createStringRequest(stringRequestToMapping));
    }

    public static void getAllMappings(){
        ApiUtils.sendPost(createStringRequest(stringRequestToRecord), "{}");
    }

    private static String createStringRequest(String request) {
        return String.format("http://localhost:%s%s", ReaderUtils.getParameter("port"), request);
    }

    private static void assertResponses(ResponseFromApi responseSendMapping, ResponseFromApi responseCheckMapping){
        logger.info("Assert stumb");
        Response responseFromStub = JsonUtils.jsonToObject(responseSendMapping.getBody(), BodyStab.class).getResponse();
        Assert.assertEquals(responseFromStub.getBody(), responseCheckMapping.getBody(), "Check body");
        Assert.assertEquals(String.valueOf(responseFromStub.getStatus()), responseCheckMapping.getStatusCode(), "Check status");
    }
}
