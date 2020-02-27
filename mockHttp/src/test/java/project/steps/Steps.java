package project.steps;

import aquality.selenium.logger.Logger;
import framework.utils.ApiUtils;
import framework.utils.JsonUtils;
import framework.utils.ReaderUtils;
import org.testng.Assert;
import project.models.BodyStab;
import project.utils.MappingCreator;
import project.utils.MappingUtils;

import java.util.HashMap;

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
        MappingUtils.assertResponses(ApiUtils.sendPost(MappingUtils.createStringRequest(stringRequestToMapping), jsonBodyStab, ""),
                ApiUtils.sendGet(MappingUtils.createStringRequest(urlMappingOne)));
        return JsonUtils.jsonToObject(jsonBodyStab, BodyStab.class).getResponse().getBody();
    }

    public static void sendMappingTwoAndCheck() {
        logger.info("Send mapping with parameter and check");
        HashMap<String ,String> parameters = new HashMap<>();
        parameters.put(nameQueryParameter, queryParameter);
        MappingUtils.assertResponses(ApiUtils.sendPost(MappingUtils.createStringRequest(stringRequestToMapping), MappingCreator.getSecondMapping(urlMappingTwo), ""),
                ApiUtils.sendGet(MappingUtils.createStringRequestWithParameters(urlMappingTwo, parameters)));
    }

    public static void sendMappingThreeAndCheck(String bodyFirstMapping) {
        logger.info("Send mapping with parameters body and headers");
        MappingUtils.assertResponses(ApiUtils.sendPost(MappingUtils.createStringRequest(stringRequestToMapping), MappingCreator.getThirdMapping(urlMappingThree, bodyFirstMapping, headerForThirdRequest), ""),
                ApiUtils.sendPost(MappingUtils.createStringRequest(urlMappingThree), bodyFirstMapping, headerForThirdRequest));
        Assert.assertEquals(ApiUtils.sendPost(MappingUtils.createStringRequest(urlMappingThree), "", headerForThirdRequest).getStatusCode(),
                ReaderUtils.getParameter("statusNotFound"),
                "Check stub with wrong body");
        Assert.assertEquals(ApiUtils.sendPost(MappingUtils.createStringRequest(urlMappingThree), bodyFirstMapping, "").getStatusCode(),
                ReaderUtils.getParameter("statusNotFound"),
                "Check stub with wrong header");
    }

    public static void sendMappingFourAndCheck() {
        logger.info("Send mapping with redirect");
        ApiUtils.sendPost(MappingUtils.createStringRequest(stringRequestToMapping), MappingCreator.getFourMapping(urlMappingFour, urlMappingOne), "");
        Assert.assertEquals(ApiUtils.sendGet(MappingUtils.createStringRequest(urlMappingFour)),
                ApiUtils.sendGet(MappingUtils.createStringRequest(urlMappingOne)),
                "Check redirect stumb");
    }

    public static void deleteAllMappings() {
        logger.info("Delete all mappings");
        ApiUtils.sendDelete(MappingUtils.createStringRequest(stringRequestToMapping));
    }

    public static void getAllMappings(){
        logger.info("Get all mappings");
        ApiUtils.sendPost(MappingUtils.createStringRequest(stringRequestToRecord), "{}", "");
    }
}
