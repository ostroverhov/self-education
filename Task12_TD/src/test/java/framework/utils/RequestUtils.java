package framework.utils;

import aquality.selenium.logger.Logger;

public class RequestUtils {

    private static final Logger logger = Logger.getInstance();

    public static String createStringRequest(String baseForRequest, Object... args) {
        logger.info("Create string request");
        StringBuilder request = new StringBuilder(baseForRequest);
        for (Object argument : args) {
            request.append(argument);
        }
        return request.toString();
    }
}
