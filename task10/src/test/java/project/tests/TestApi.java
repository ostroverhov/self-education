package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.steps.StepsApi;

public class TestApi extends BaseTest {

    @Override
    @Test()
    public void runTest() throws Throwable {
        int suiteId = StepsApi.createSuite();
        int sectionId = StepsApi.createSection(suiteId);
        int caseId = StepsApi.createCase(sectionId);
        int runId = StepsApi.createRun(suiteId);
        StepsApi.addResult(runId, caseId);
        StepsApi.deleteRun(runId);
        StepsApi.deleteCase(caseId);
        StepsApi.deleteSection(sectionId);
        StepsApi.deleteSuite(suiteId);
    }
}
