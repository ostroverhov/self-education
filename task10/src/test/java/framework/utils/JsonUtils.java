package framework.utils;

import aquality.selenium.logger.Logger;
import com.google.gson.Gson;

public class JsonUtils {

    private static final Logger logger = Logger.getInstance();

    public static <T> T jsonToObject(String bodyResponse, Class<T> tClass) {
        logger.info("Get object from json response");
        return new Gson().fromJson(bodyResponse, tClass);
    }
}
