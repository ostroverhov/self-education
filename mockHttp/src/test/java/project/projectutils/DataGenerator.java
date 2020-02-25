package project.projectutils;

import aquality.selenium.logger.Logger;
import framework.utils.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataGenerator {

    private static final Logger logger = Logger.getInstance();

    private static final int randomLength = 5;
    private static final int randomStatus = 4;
    private static final String patternDateTime = "yyyy-MM-dd hh:mm:ss";
    private static final String browserName = "chrome";

    private static String generateDate() {
        logger.info("Generate date");
        return new SimpleDateFormat(patternDateTime).format(Calendar.getInstance().getTime());
    }

    private static String generateRandomString() {
        logger.info("Generate random string");
        return RandomUtils.generateRandomString(randomLength);
    }
}
