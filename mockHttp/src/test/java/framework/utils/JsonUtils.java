package framework.utils;

import aquality.selenium.logger.Logger;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class JsonUtils {

    private static final Logger logger = Logger.getInstance();

    public static String convertToJson(Object object) {
        logger.info("Convert object to json" + object.getClass());
        return new Gson().toJson(object, object.getClass());
    }

    public static <T> T jsonToObject(String bodyResponse, Class<T> tClass) {
        logger.info("Get object from json response");
        return new Gson().fromJson(bodyResponse, tClass);
    }
}
