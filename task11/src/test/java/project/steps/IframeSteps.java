package project.steps;

import framework.utils.IframeUtils;
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
        switchToFrame(nameFrame);
        String randomText = RandomUtils.generateRandomString(lengthRandomString);
        mainPage.deleteAndInputText(randomText);
        Assert.assertEquals(randomText, mainPage.getTextFromTextBox(), "Text not equals");
    }

    public static void makeTextBold(MainPage mainPage) {
        mainPage.selectText();
        IframeUtils.switchToMainPage();
        mainPage.clickButtonBoldText();
        switchToFrame(nameFrame);
        Assert.assertTrue(mainPage.isStrongTextInBox(), "String not bold");
    }

    private static void switchToFrame(String nameFrame) {
        IframeUtils.switchToFrame(nameFrame);
    }
}