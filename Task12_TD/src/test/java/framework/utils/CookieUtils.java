package framework.utils;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.Cookie;

public class CookieUtils {

    private static final Logger logger = Logger.getInstance();

    public static void addCookie(String key, String value) {
        logger.info("Add cookie " + key);
        BrowserManager.getBrowser().getDriver().manage().addCookie(new Cookie(key, value));
    }
}
