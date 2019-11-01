package framework.utils;

import aquality.selenium.logger.Logger;
import aquality.selenium.utils.JsonFile;

import java.io.*;
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
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/credentials.properties");//todo путь вынеси
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(parameter);
    }

    public static String readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}
