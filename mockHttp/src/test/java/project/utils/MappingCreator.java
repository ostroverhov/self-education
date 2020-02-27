package project.utils;

import aquality.selenium.logger.Logger;
import framework.utils.JsonUtils;
import framework.utils.RandomUtils;
import framework.utils.ReaderUtils;
import project.models.BodyStab;
import project.models.Headers;
import project.models.Request;
import project.models.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MappingCreator {

    private static final Logger logger = Logger.getInstance();
    private static final int randomStringLength = 100;
    private static final int randomStringLengthForThirdMapping = 20;
    private static final String headerMappingOne = "text/plain";
    private static final String headerMappingTwo = "application/json";
    private static final String pathToFileJson = "src/test/resources/settings.json";
    private static final String urlPattern = "\\?testqueryparam=([a-z]*)";
    private static final int delay = 10000;

    public static String getFirstMapping(String urlMappingOne) {
        logger.info("Create mapping for GET request");
        BodyStab bodyStab = new BodyStab();
        bodyStab.setRequest(new Request().setUrl(urlMappingOne)
                                        .setMethod(ReaderUtils.getParameter("methodGet")))
                .setResponse(new Response().setStatus(ReaderUtils.getParameter("statusOk"))
                                        .setBody(RandomUtils.generateRandomString(randomStringLength))
                                        .setHeaders(new Headers().setContentType(headerMappingOne)));
        return JsonUtils.convertToJson(bodyStab);
    }

    public static String getSecondMapping(String urlMappingTwo) {
        logger.info("Create mapping for GET request with parameter");
        BodyStab bodyStab = new BodyStab();
        bodyStab.setRequest(new Request().setUrlPattern(urlMappingTwo + urlPattern)
                                        .setMethod(ReaderUtils.getParameter("methodGet")))
                .setResponse(new Response().setStatus(ReaderUtils.getParameter("statusOk"))
                                        .setBody(ReaderUtils.readFile(pathToFileJson))
                                        .setHeaders(new Headers().setContentType(headerMappingTwo)));
        return JsonUtils.convertToJson(bodyStab);
    }

    public static String getThirdMapping(String urlMappingThree, String body, String header) {
        logger.info("Create mapping for POST request with parameters body and headers");
        BodyStab bodyStab = new BodyStab();
        List<Object> bodyPatterns = new ArrayList<>();
        HashMap<String, String> pattern = new HashMap<>();
        pattern.put("equalTo", body);
        bodyPatterns.add(pattern);
        HashMap<String, String> customTypeHeader = new HashMap<>();
        customTypeHeader.put("equalTo", header);
        bodyStab.setRequest(new Request().setUrl(urlMappingThree)
                                        .setMethod(ReaderUtils.getParameter("methodPost"))
                                        .setHeaders(new Headers().setContentType(customTypeHeader))
                                        .setBodyPatterns(bodyPatterns))
                .setResponse(new Response().setStatus(ReaderUtils.getParameter("statusError"))
                                        .setBody(RandomUtils.generateRandomString(randomStringLengthForThirdMapping))
                                        .setHeaders(new Headers().setContentType(headerMappingOne)));
        return JsonUtils.convertToJson(bodyStab);
    }

    public static String getFourMapping(String urlMappingFour, String proxyBaseUrl) {
        logger.info("Create mapping for PUT request with redirect");
        BodyStab bodyStab = new BodyStab();
        bodyStab.setRequest(new Request().setUrl(urlMappingFour)
                                        .setMethod(ReaderUtils.getParameter("methodGet")))
                .setResponse(new Response().setHeaders(new Headers().setLocation(proxyBaseUrl))
                                        .setStatus("302")
                                        .setFixedDelayMilliseconds(delay));
        return JsonUtils.convertToJson(bodyStab);
    }
}
