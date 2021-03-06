package project.hooks;

import aquality.selenium.browser.Browser;
import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import framework.configurations.Configuration;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriverException;
import project.utils.CarStore;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Hook {

    protected final Logger logger = Logger.getInstance();

    /**
     * Before Class method
     * Configure environment
     * Make a browser window
     */
    @Before
    public void before() throws WebDriverException {
        logger.info("=== PRECONDITIONS ===");
        getBrowser().goTo(Configuration.getCurrentEnvironment().getStartUrl());
        getBrowser().maximize();
        CarStore.putJsonCarInStorage("car1");
        CarStore.putJsonCarInStorage("car2");
        CarStore.putJsonCarInStorage("car3");
    }

    /**
     * Close browser and made screenshot
     */
    @After
    public void afterMethod() {
        makeScreenshot();
        logger.info("=== TEST FINISHED ===");
        getBrowser().quit();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return getBrowser().getScreenshot();
    }

    private Browser getBrowser() {
        return BrowserManager.getBrowser();
    }
}
