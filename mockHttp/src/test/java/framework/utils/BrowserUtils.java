package framework.utils;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;

public class BrowserUtils {

    private static final Logger logger = Logger.getInstance();

    public static void refreshPage() {
        logger.info("Refresh page");
        BrowserManager.getBrowser().getDriver().navigate().refresh();
    }

    public static void goBack() {
        logger.info("Open main page");
        BrowserManager.getBrowser().goBack();
    }
}
