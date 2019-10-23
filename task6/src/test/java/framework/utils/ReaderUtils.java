package framework.utils;

import aquality.selenium.logger.Logger;
import aquality.selenium.utils.JsonFile;

public class ReaderUtils {

    private static final Logger logger = Logger.getInstance();
    private static JsonFile configurationFile = new JsonFile("environment/stage/config.json");

    public static String getUrl() {
        logger.info("Get URL from config");
        return String.valueOf(configurationFile.getValue("/startUrl"));
    }
}
