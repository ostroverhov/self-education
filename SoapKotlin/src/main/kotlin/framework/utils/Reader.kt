package framework.utils

import java.io.FileInputStream
import java.util.*

private const val pathToConfig: String = "src/main/resources/config.properties"

fun getParameter(parameter: String?): String? {
    logger.info("Get $parameter from config file")
    Properties().also {
        it.load(FileInputStream(pathToConfig))
        return it.getProperty(parameter)
    }
}
