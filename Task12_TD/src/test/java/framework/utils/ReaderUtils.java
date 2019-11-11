package framework.utils;

import aquality.selenium.logger.Logger;

import java.io.*;
import java.util.Properties;

public class ReaderUtils {

    private static final Logger logger = Logger.getInstance();
    private static String pathToCredentials = "src/test/resources/credentials.properties";

    public static String getParameter(String parameter) {
        logger.info("Get parameter of credentials " + parameter);
        Properties property = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToCredentials);
            property.load(fileInputStream);
        } catch (IOException e) {
            logger.warn("Can't read parameter " + parameter);
        }
        return property.getProperty(parameter);
    }

    public static String readFile(String fileName) {
        logger.info("Read file " + fileName);
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(new File(fileName)));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            logger.warn("Can't read file " + fileName);
        }
        return stringBuilder.toString();
    }
}
