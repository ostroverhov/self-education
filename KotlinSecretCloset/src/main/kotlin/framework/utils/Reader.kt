package framework.utils

import aquality.selenium.logger.Logger
import java.io.FileInputStream
import java.util.*

private const val pathToConfig: String = "src/test/resources/config.properties"
val logger: Logger = Logger.getInstance()

fun getParameter(parameter: String?): String? {
    logger.info("Get $parameter  from config file")
    val property = Properties()
    property.load(FileInputStream(pathToConfig))
    return property.getProperty(parameter)
}
