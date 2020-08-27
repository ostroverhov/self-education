package framework.browser

import framework.logger.Logger
import framework.utils.Reader
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

import java.util.concurrent.TimeUnit

class Browser {
    private static WebDriver driver

    private Browser() {
    }

    static def getInstance() {
        Logger.info("Driver init")
        if (driver == null) {
            switch (Reader.getParameter("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup()
                    driver = new ChromeDriver(BrowserSettings.chromeSettings())
                    break
                case "firefox":
                    WebDriverManager.firefoxdriver().setup()
                    driver = new FirefoxDriver(BrowserSettings.firefoxSettings())
                    break
                default:
                    Logger.warn("browser wasn't select ")
                    throw new IllegalBrowserNameException()
            }
        }
        driver
    }

    static closeBrowser() {
        Logger.info("Close driver")
        if (driver != null) {
            driver.quit()
        }
        driver = null
    }

    static void setImplicitlyWait(def timeout) {
        Logger.info("Set wait")
        getInstance().manage().timeouts().implicitlyWait(timeout as int, TimeUnit.SECONDS)
    }

    static void setMaxSizeWindow() {
        Logger.info("Set max size window")
        getInstance().manage().window().maximize()
    }

    static void setUrl(String url) {
        Logger.info("Set URL " + url)
        getInstance().get(url)
    }
}
