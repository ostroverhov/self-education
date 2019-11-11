package project.projectutils;

import aquality.selenium.logger.Logger;
import framework.utils.ApiUtils;
import framework.utils.ReaderUtils;
import project.models.ResponseFromApi;

public class XmlPlaceholderApi {

    private static final Logger logger = Logger.getInstance();
    private static final String request = "5daedf5b320000ec71d95dd7";
    private static final String version = "v2";

    public static ResponseFromApi executeGetRequest() throws Throwable {
        logger.info("Execute GET request");
        return ApiUtils.sendGetRequest(createStringRequest(version, request));
    }

    private static String createStringRequest(Object... args) {
        logger.info("Create string request");
        StringBuilder request = new StringBuilder(ReaderUtils.getUrl());
        for (Object argument : args) {
            request.append("/").append(argument);
        }
        return request.toString();
    }
}
