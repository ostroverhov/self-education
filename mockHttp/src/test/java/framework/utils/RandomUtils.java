package framework.utils;

import aquality.selenium.logger.Logger;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomUtils {

    private static final Logger logger = Logger.getInstance();

    public static String generateRandomString(int lengthRandomString) {
        logger.info("Generate random string");
        return RandomStringUtils.randomAlphabetic(lengthRandomString);
    }
}
