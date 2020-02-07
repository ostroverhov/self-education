package framework.utils;

import aquality.selenium.logger.Logger;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtils {

    private static final Logger logger = Logger.getInstance();

    public static <T> T getObjectFromJson(String path, Class<T> targetClass) {
        logger.info("Get object from json");
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(reader, targetClass);
    }

    public static void writeObjectToJson(String path, Object object) {
        logger.info("Write object in json");
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(new Gson().toJson(object));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
