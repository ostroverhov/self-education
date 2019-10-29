package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.pages.MainPage;
import project.steps.CookiesSteps;

public class TestCookies extends BaseTest {

    @Override
    @Test
    public void runTest() {
        MainPage mainPage = new MainPage();
        CookiesSteps.openMainPage(mainPage);
        CookiesSteps.addCookies();
        CookiesSteps.deleteFirstCookie();
        CookiesSteps.changeThirdCookie();
        CookiesSteps.deleteCookies();
    }
}
