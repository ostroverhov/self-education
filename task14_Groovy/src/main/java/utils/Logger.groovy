package utils

class Logger {
    public static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class.getName())

    static void info(String message) {
        logger.info("Info: " + message)
    }

    static void warn(String message) {
        logger.warn("warn: " + message)
    }
}
