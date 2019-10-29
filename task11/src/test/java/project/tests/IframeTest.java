package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.forms.MainPage;
import project.steps.IframeSteps;

public class IframeTest extends BaseTest {

    @Override
    @Test(description = "TestNG project demo test")
    public void runTest() {
        MainPage mainPage = new MainPage();
        IframeSteps.mainPageIsOpened(mainPage);
        IframeSteps.deleteAndInputText(mainPage);
        IframeSteps.makeTextBold(mainPage);


//        DemoSteps demoSteps = new DemoSteps();
//        Client client = new Client("Peter Parker", "A1QA", "+44 208 816 7320", "I'd like to contact you");
//        demoSteps.mainPageIsOpened();
//
//        demoSteps.iOpenContactUsPage();
//        demoSteps.contactUsPageIsOpened();
//
//        demoSteps.iFillContactFormUsingFollowingData(Collections.singletonList(client));
//        demoSteps.iAcceptPrivacyAndCookiesPolicy();
//        demoSteps.iClickSendButton();
//        demoSteps.notificationAboutEmptyFieldsIsPresent();
    }
}
