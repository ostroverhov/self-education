package framework.logger

class Logger {
    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class.getName())

    static info(def message) {
        logger.info("Info: " + message)
    }

    static step(def message) {
        logger.info("Step: " + message)
    }

    static warn(def message) {
        logger.warn("warn: " + message)
    }
}
