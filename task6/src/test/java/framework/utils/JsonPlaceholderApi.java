package framework.utils;

import aquality.selenium.logger.Logger;
import project.models.ResponseFromApi;

public class JsonPlaceholderApi {

    private static final Logger logger = Logger.getInstance();

    public static ResponseFromApi executeGetRequest(Object... args) throws Throwable {
        logger.info("Execute GET request");
        return ApiUtils.sendGet(createStringRequest(args));
    }

    public static ResponseFromApi executeSendRequest(String jsonString, Object... args) throws Throwable {
        logger.info("Execute POST request");
        return ApiUtils.sendPost(createStringRequest(args), jsonString);
    }

    private static String createStringRequest(Object... args) {
        logger.info("Create string request");
        StringBuilder request = new StringBuilder(ReaderUtils.getUrl());
        for (Object argument : args) {
            request.append(argument).append("/");
        }
        return request.toString();
    }
}
