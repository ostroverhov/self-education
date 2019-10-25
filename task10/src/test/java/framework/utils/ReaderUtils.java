package framework.utils;

import aquality.selenium.logger.Logger;
import aquality.selenium.utils.JsonFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReaderUtils {

    private static final Logger logger = Logger.getInstance();
    private static JsonFile configurationFile = new JsonFile("environment/stage/config.json");

    public static String getUrl() {
        logger.info("Get URL from config");
        return String.valueOf(configurationFile.getValue("/startUrl"));
    }

    public static String getParameter(String parameter) {
        Properties property = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/testrail.properties");
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(parameter);
    }
}
