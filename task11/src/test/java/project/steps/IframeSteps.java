package project.steps;

import framework.utils.RandomUtils;
import org.testng.Assert;
import project.forms.MainPage;

public class IframeSteps {

    private static final int lengthRandomString = 10;
    private static final String nameFrame = "mce_0_ifr";

    public static void mainPageIsOpened(MainPage mainPage) {
        Assert.assertTrue(mainPage.isFormDisplayed(), "Main page is opened");
    }

    public static void deleteAndInputText(MainPage mainPage) {
        mainPage.switchToFrame(nameFrame);
        String randomText = RandomUtils.generateRandomString(lengthRandomString);
        mainPage.deleteAndInputText(randomText);
        Assert.assertEquals(randomText, mainPage.IsPresentText(), "text not equals");
    }

    public static void makeTextBold(MainPage mainPage) {
        mainPage.selectText();
        mainPage.switchToMainPage();
        mainPage.clickButtonBoldText();
        mainPage.switchToFrame(nameFrame);
        Assert.assertTrue(mainPage.isStrongTextInBox(), "String not bold");
    }
}
