package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.forms.MainPage;
import project.steps.StepsTD;

import static project.enums.NameProject.NEXAGE;

public class TestTD extends BaseTest {

    @Override
    @Test(description = "TestNG project demo test")
    public void runTest() throws Throwable {
        MainPage mainPage = new MainPage();
        String token = StepsTD.getToken();
        StepsTD.setVariant(mainPage, token);
        StepsTD.goToPageNexage(mainPage, NEXAGE);
//        StepsTD.createNewProject(mainPage);
//        TestModel testModel = DataGenerator.generateTestExample();
//
//        StepsTD.addTestToProject(mainPage, testModel);
//        StepsTD.checkLastTest(testModel);


    }
}
