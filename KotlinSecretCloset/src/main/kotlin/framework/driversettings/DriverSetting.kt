package framework.driversettings

import framework.utils.getParameter
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

class DriverSetting {

    fun getCapabilities(): DesiredCapabilities = with(DesiredCapabilities()) {
        setCapability(MobileCapabilityType.PLATFORM_NAME, getParameter("platformName"))
        setCapability(MobileCapabilityType.DEVICE_NAME, getParameter("deviceName"))
        setCapability(MobileCapabilityType.APP, getParameter("applicationPath"))
        return this
    }
}