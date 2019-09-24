package framework.utils;

import org.apache.log4j.Logger;

public class MyLogger {

    private static final Logger logger = Logger.getLogger(MyLogger.class.getName());

    public static void step(String message) {
        logger.info("Step: " + message);
    }

    public static void info(String message) {
        logger.info("Info:   " + message);
    }

    public static void warn(String message) {
        logger.warn("warn: " + message);
    }
}
