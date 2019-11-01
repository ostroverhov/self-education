package framework.utils;

import aquality.selenium.logger.Logger;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonUtils {

    private static final Logger logger = Logger.getInstance();

    public static <T> T readObjectFromJson(Class<T> tClass, String pathToJson) throws Throwable {
        logger.info("Read object from json " + tClass);
        T object;
        try {
            object = new Gson().fromJson(new FileReader(pathToJson), tClass);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File json not found");
        }
        return object;
    }

    public static String convertToJson(Object object) {
        logger.info("Convert object to json" + object.getClass());
        return new Gson().toJson(object, object.getClass());
    }

    public static <T> ArrayList<T> jsonToArray(String bodyResponse, Type itemsListType) {
        logger.info("Convert json to list object");
        ArrayList<T> result = new ArrayList<>();
        try {
            result = new Gson().fromJson(bodyResponse, itemsListType);
        } catch (com.google.gson.JsonSyntaxException ex) {
            throw new com.google.gson.JsonSyntaxException("Format response not json");
        }
        return result;
    }


    public static <T> T jsonToObject(String bodyResponse, Class<T> tClass) {
        logger.info("Get object from json response");
        return new Gson().fromJson(bodyResponse, tClass);
    }
}
