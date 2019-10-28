package framework.utils;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieUtils {

    private static final Logger logger = Logger.getInstance();

    public static void addCookie(String key, String value) {
        logger.info("Add cookie " + key);
        getManager().addCookie(new Cookie(key, value));
    }

    public static boolean isExistCookie(String key) {
        logger.info("Check cookie is exist " + key);
        return getManager().getCookies().contains(getCookie(key));
    }

    public static void deleteCookie(String key) {
        logger.info("Delete cookie " + key);
        getManager().deleteCookie(getCookie(key));
    }

    public static Cookie getCookie(String key) {
        logger.info("Get cookie " + key);
        return getManager().getCookieNamed(key);
    }

    public static void deleteAllCookie() {
        logger.info("Delete all cookies");
        getManager().deleteAllCookies();
    }

    private static WebDriver.Options getManager() {
        logger.info("Get manager");
        return BrowserManager.getBrowser().getDriver().manage();
    }
}
