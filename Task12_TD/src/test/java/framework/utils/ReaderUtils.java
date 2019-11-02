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
            e.printStackTrace();
        }
        return property.getProperty(parameter);
    }

    public static String readFile(String fileName) throws IOException {
        logger.info("Read file " + fileName);
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}
