package framework.application

import aquality.selenium.logger.Logger
import framework.utils.getParameter
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import java.util.concurrent.TimeUnit

object App {

    private var driver: AppiumDriver<MobileElement>? = null
    private val logger: Logger = Logger.getInstance()

    fun setUpDriver() {
        logger.info("Set up driver")
        driver = AppFactory().getDriver()
        driver?.let {
            it.manage()?.timeouts()?.implicitlyWait(getParameter("timeout")!!.toLong(), TimeUnit.SECONDS)
        }
    }

    fun getDriver(): AppiumDriver<MobileElement>? {
        logger.info("Get driver")
        return driver
    }

    fun quit() {
        logger.info("Quit driver")
        driver?.quit()
        driver = null
    }
}