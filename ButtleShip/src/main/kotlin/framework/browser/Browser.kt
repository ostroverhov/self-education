package framework.browser

import framework.utils.Logger
import framework.utils.getParameter
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.util.concurrent.TimeUnit

object Browser {

    private var driver: WebDriver? = null
    private var logger: Logger = Logger()

    fun getInstance() {
        val browser: String? = getParameter("browser")
        logger.info("Driver $browser init")
        driver = when (browser) {
            "chrome" -> {
                WebDriverManager.chromedriver().setup()
                ChromeDriver()
            }
            "firefox" -> {
                WebDriverManager.firefoxdriver().setup()
                FirefoxDriver()
            }
            else -> throw IllegalBrowserNameExceptions()
        }
    }

    fun getDriver(): WebDriver? {
        return driver
    }

    fun closeBrowser() {
        logger.info("Close driver")
        driver?.quit()
        driver = null
    }

    fun setImplicitlyWait(timeout: String?) {
        logger.info("Set implicitly wait $timeout seconds")
        driver?.manage()?.timeouts()?.implicitlyWait(timeout!!.toLong(), TimeUnit.SECONDS)
    }

    fun setMaxSizeWindow() {
        logger.info("Set max size window")
        driver?.manage()?.window()?.maximize()
    }

    fun setUrl(url: String?) {
        logger.info("Set URL $url")
        driver?.get(url)
    }
}