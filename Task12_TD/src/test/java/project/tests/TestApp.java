package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.forms.MainPage;
import project.forms.ProjectPage;
import project.models.TestModel;
import project.projectutils.DataGenerator;
import project.steps.StepsApp;

import static project.enums.NameProject.NEXAGE;

public class TestApp extends BaseTest {

    @Override
    @Test(description = "Test of application")
    public void runTest() throws Throwable {
        MainPage mainPage = new MainPage();
        ProjectPage projectPage = new ProjectPage();
        String token = StepsApp.getToken();
        StepsApp.setVariant(mainPage, token);
        StepsApp.goToPageNexage(mainPage, NEXAGE, projectPage);
        StepsApp.createNewProject(mainPage);
        TestModel testModel = DataGenerator.generateTestExample();
        StepsApp.addTestToProject(mainPage, testModel, projectPage);
        StepsApp.checkLastTest(testModel, projectPage);
    }
}
