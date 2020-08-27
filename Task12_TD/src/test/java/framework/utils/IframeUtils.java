package framework.utils;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;

public class IframeUtils {

    private static final Logger logger = Logger.getInstance();

    public static void switchToFrame(String nameFrame) {
        logger.info("Switch to frame " + nameFrame);
        BrowserManager.getBrowser().getDriver().switchTo().frame(nameFrame);
    }

    public static void switchToMainPage() {
        logger.info("Switch to main page");
        BrowserManager.getBrowser().getDriver().switchTo().defaultContent();
    }
}
