package project.utils;

import aquality.selenium.logger.Logger;
import framework.utils.JsonUtils;
import framework.utils.RandomUtils;
import framework.utils.ReaderUtils;
import project.models.BodyStab;
import project.models.Headers;
import project.models.Request;
import project.models.Response;

import java.util.HashMap;
import java.util.Map;

public class MappingCreator {

    private static final Logger logger = Logger.getInstance();
    private static final int randomStringLength = 100;
    private static final String headerMappingOne = "text/plain";
    private static final String headerMappingTwo = "application/json";
    private static final String pathToFileJson = "src/test/resources/settings.json";

    public static String getFirstMapping(String urlMappingOne) {
        logger.info("Get object and create request");
        BodyStab bodyStab = new BodyStab();
        bodyStab.setRequest(new Request().setUrl(urlMappingOne)
                                        .setMethod(ReaderUtils.getParameter("methodGet")))
                .setResponse(new Response().setStatus(ReaderUtils.getParameter("statusOk"))
                                        .setBody(RandomUtils.generateRandomString(randomStringLength))
                                        .setHeaders(new Headers().setContentType(headerMappingOne)));
        return JsonUtils.convertToJson(bodyStab);
    }

    public static String getSecondMapping(String urlMappingTwo) {
        logger.info("Get object and create request");
        BodyStab bodyStab = new BodyStab();
        bodyStab.setRequest(new Request().setUrl(urlMappingTwo)
                                        .setMethod(ReaderUtils.getParameter("methodGet")))
                .setResponse(new Response().setStatus(ReaderUtils.getParameter("statusOk"))
                                        .setBody(ReaderUtils.readFile(pathToFileJson))
                                        .setHeaders(new Headers().setContentType(headerMappingTwo)));
        return JsonUtils.convertToJson(bodyStab);
    }

    public static String getThirdMapping(String urlMappingThree) {
        logger.info("Get object and create request");
        BodyStab bodyStab = new BodyStab();
        HashMap<String, String> bodyPatterns = new HashMap<>();
        bodyPatterns.put("equalToJson", "{}");
        HashMap<String, String> customTypeHeader = new HashMap<>();
        customTypeHeader.put("equalTo", headerMappingOne);
        bodyStab.setRequest(new Request().setUrl(urlMappingThree)
                .setMethod(ReaderUtils.getParameter("methodPost"))
//                .setBodyPatterns(bodyPatterns)
        )
                .setResponse(new Response().setStatus(ReaderUtils.getParameter("statusError"))
                        .setBody("qwe")
                        .setHeaders(new Headers().setCustomType(customTypeHeader)));
        return JsonUtils.convertToJson(bodyStab);
    }

    public static String getFourMapping(String urlMappingFour, String proxyBaseUrl) {
        logger.info("Get object and create request");
        BodyStab bodyStab = new BodyStab();
        bodyStab.setRequest(new Request().setUrl(urlMappingFour)
                .setMethod(ReaderUtils.getParameter("methodPut"))) //todo PUT
                .setResponse(new Response().setProxyBaseUrl(proxyBaseUrl));
        return JsonUtils.convertToJson(bodyStab);
    }


}
