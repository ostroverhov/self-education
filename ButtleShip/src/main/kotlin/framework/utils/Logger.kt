package framework.utils

import org.apache.log4j.Logger

class Logger {

    private val logger: Logger = Logger.getLogger(Logger::class.java.name)

    fun step(message: String) {
        logger.info("Step: $message")
    }

    fun info(message: String) {
        logger.info("Info:   $message")
    }

    fun warn(message: String) {
        logger.warn("warn: $message")
    }
}