package framework.utils;

import aquality.selenium.logger.Logger;
import project.models.ResponseFromApi;

public class XmlPlaceholderApi {

    private static final Logger logger = Logger.getInstance();

    public static ResponseFromApi executeGetRequest() throws Throwable {
        logger.info("Execute GET request");
        return ApiUtils.sendGetRequestXML(ReaderUtils.getUrl());
    }
}
