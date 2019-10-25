package project.tests;

import framework.base.BaseTest;
import framework.utils.JsonPlaceholderApi;
import org.testng.annotations.Test;
import project.steps.StepsApi;

public class TestApi extends BaseTest {

    @Override
    @Test()
    public void runTest() throws Throwable {
        int suiteId = StepsApi.createSuite().getId();

        System.out.println("=========" + StepsApi.getSuite(suiteId).toString());

        int sectionId = StepsApi.createSection(11515).getId(); //todo here suite Id

        System.out.println("=========" + StepsApi.getSection(sectionId).toString());

        int caseId = StepsApi.createCase(1329068).getId(); //todo here suite Id

        System.out.println("=========" + StepsApi.getCase(caseId).toString());

        int runId = StepsApi.createRun(suiteId).getId();

        System.out.println("=========" + StepsApi.getRun(runId));

        System.out.println("=========" + StepsApi.addResult(runId, caseId));

        System.out.println("=========" + StepsApi.getResult(runId, caseId));


        JsonPlaceholderApi.deleteRun(runId);
        JsonPlaceholderApi.deleteCase(caseId);
        JsonPlaceholderApi.deleteSection(sectionId);
        JsonPlaceholderApi.deleteSuite(suiteId);
    }
}
