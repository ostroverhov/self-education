package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.forms.MainPage;
import project.steps.IframeSteps;

public class IframeTest extends BaseTest {

    @Override
    @Test(description = "Iframe test")
    public void runTest() {
        MainPage mainPage = new MainPage();
        IframeSteps.mainPageIsOpened(mainPage);
        IframeSteps.deleteAndInputText(mainPage);
        IframeSteps.makeTextBold(mainPage);
    }
}