package framework.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

public class AllureUtils {

    public static void createEnvironmentProperties(Map<String, String> environmentProperties) {
        Properties properties = new Properties();
        properties.putAll(environmentProperties);
        try (OutputStream outputStream = new FileOutputStream(Reader.getParametr("allureProperties"))) {
            properties.putAll(environmentProperties);
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
