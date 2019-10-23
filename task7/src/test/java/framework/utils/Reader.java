package framework.utils;

import aquality.selenium.logger.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Reader {

    private static final Logger logger = Logger.getInstance();

    public static String getParameter(String parameter) throws IOException {
        logger.info("Get parameter " + parameter);
        Properties property = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/cloudinary.properties");
            property.load(fileInputStream);
        } catch (IOException e) {
            throw new IOException("Parameter not found");
        }
        return property.getProperty(parameter);
    }
}
