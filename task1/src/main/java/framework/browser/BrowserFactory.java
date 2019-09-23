package framework.browser;

import framework.utils.MyLogger;
import framework.utils.Reader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    private static WebDriver driver;

    private BrowserFactory() {
    }

    public static WebDriver getInstance() throws IllegalBrowserNameException {
        if (driver == null) {
            MyLogger.info("driver init");
            switch (Reader.getParametr("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(BrowserSettings.chromeSettings());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(BrowserSettings.firefoxSettings());
                    break;
                default:
                    MyLogger.warn("browser wasn't select ");
                    throw new IllegalBrowserNameException();
            }
        }
        return driver;
    }

    public static void closeBrowser() {
        MyLogger.info("close driver");
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    public static void setImplicityWait(int timeout) {
        getInstance().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    public static void setMaxSizeWindow() {
        MyLogger.info("set max size window");
        driver.manage().window().maximize();
    }

    public static void setUrl(String url) {
        MyLogger.info("set URL " + url);
        driver.get(url);
    }
}
