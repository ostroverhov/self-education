package framework.utils;

import aquality.selenium.logger.Logger;

import java.util.Random;

public class RandomUtils {

    private static final Logger logger = Logger.getInstance();

    public static int generateRandomNumber(int randomRange) {
        logger.info("Generate random number");
        return new Random().nextInt(randomRange);
    }
}
