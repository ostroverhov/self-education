package framework.application

import aquality.selenium.logger.Logger
import framework.driversettings.DriverSetting
import framework.utils.getParameter
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import java.net.URL

class AppFactory {

    fun getDriver(): AppiumDriver<MobileElement>? {
        val platformName = getParameter("platformName")
        val capabilities = DriverSetting().getCapabilities()
        val driver: AppiumDriver<MobileElement>?
        driver = when (platformName) {
            "android" -> AndroidDriver(getUrl(), capabilities)
            "ios" -> IOSDriver(getUrl(), capabilities)
            else -> throw getWrongPlatformNameException()
        }
        return driver
    }

    private fun getUrl(): URL {
        return URL(getParameter("remoteConnectionUrl"))
    }

    private fun getWrongPlatformNameException(): IllegalArgumentException {
        val message = "Platform name is not supported"
        val exception = IllegalArgumentException(message)
        Logger.getInstance().fatal(message, exception)
        return exception
    }
}