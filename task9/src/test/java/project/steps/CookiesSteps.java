package project.steps;

import framework.utils.CookieUtils;
import org.testng.Assert;
import project.pages.MainPage;

public class CookiesSteps {

    private static final String firstCookieName = "example_key_1";
    private static final String firstCookieValue = "example_value_1";
    private static final String secondCookieName = "example_key_2";
    private static final String secondCookieValue = "example_value_2";
    private static final String thirdCookieName = "example_key_3";
    private static final String thirdCookieValue = "example_value_3";
    private static final String thirdCookieNewValue = "example_value_300";

    public static void openMainPage(MainPage mainPage) {
        Assert.assertTrue(mainPage.isFormDisplayed(), " not found");
    }

    public static void addCookies() {
        CookieUtils.addCookie(firstCookieName, firstCookieValue);
        CookieUtils.addCookie(secondCookieName, secondCookieValue);
        CookieUtils.addCookie(thirdCookieName, thirdCookieValue);
        assertCookie(firstCookieName);
        assertCookie(secondCookieName);
        assertCookie(thirdCookieName);
    }

    public static void deleteFirstCookie() {
        CookieUtils.deleteCookie(firstCookieName);
        assertDeleteCookie(firstCookieName);
    }

    public static void changeThirdCookie() {
        CookieUtils.addCookie(thirdCookieName, thirdCookieNewValue);
        Assert.assertEquals(CookieUtils.getCookie(thirdCookieName).getValue(), thirdCookieNewValue, "Value don't change");
    }

    public static void deleteCookies() {
        CookieUtils.deleteAllCookie();
        assertDeleteCookie(firstCookieName);
        assertDeleteCookie(secondCookieName);
        assertDeleteCookie(thirdCookieName);
    }

    private static void assertCookie(String key) {
        Assert.assertTrue(CookieUtils.isExistCookie(key), "Cookie not found: " + key);
    }

    private static void assertDeleteCookie(String key) {
        Assert.assertFalse(CookieUtils.isExistCookie(key), "Cookie exist after delete " + key);
    }
}

