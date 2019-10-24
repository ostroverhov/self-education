package framework.utils;

import aquality.selenium.browser.BrowserManager;
import org.openqa.selenium.Cookie;

public class CookieUtils {

    public static void addCookie(String key, String value) {
        BrowserManager.getBrowser().getDriver().manage().addCookie(new Cookie(key, value));
    }

    public static boolean isExistCookie(String key) {
        return BrowserManager.getBrowser().getDriver().manage().getCookies().contains(getCookie(key));
    }

    public static void deleteCookie(String key) {
        BrowserManager.getBrowser().getDriver().manage().deleteCookie(getCookie(key));
    }

    public static Cookie getCookie(String key) {
        return BrowserManager.getBrowser().getDriver().manage().getCookieNamed(key);
    }

    public static void deleteAllCookie() {
        BrowserManager.getBrowser().getDriver().manage().deleteAllCookies();
    }
}
