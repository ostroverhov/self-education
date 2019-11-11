package project.tests;

import aquality.selenium.logger.Logger;
import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.models.TestModel;
import project.projectutils.DataGenerator;
import project.steps.ApiSteps;
import project.steps.DataBaseSteps;
import project.steps.PageSteps;

import java.util.ArrayList;

import static project.enums.NameProject.NEXAGE;

public class TestApp extends BaseTest {

    private static final Logger logger = Logger.getInstance();

    @Override
    @Test(description = "Test of application")
    public void runTest() {
        logger.info("Get token");
        String token = ApiSteps.getToken();
        logger.info("Set variant");
        PageSteps.setVariant(token);
        logger.info("Get list of tests from request");
        ArrayList<TestModel> testsFromRequest = ApiSteps.getTestsFromRequest(NEXAGE);
        logger.info("Go to page " + NEXAGE);
        PageSteps.goToPageOfProject(testsFromRequest, NEXAGE);
        logger.info("Create new project");
        String nameNewProject = PageSteps.createNewProject();
        logger.info("Generate example of test");
        TestModel testModel = DataGenerator.generateTestExample();
        logger.info("Add test to project");
        DataBaseSteps.addTestToProject(testModel, nameNewProject);
        logger.info("Check last test");
        PageSteps.checkLastTest(testModel);
    }
}
