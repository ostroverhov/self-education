package project.tests;

import framework.base.BaseTest;
import framework.utils.TestRailRequests;
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
        TestRailRequests.addResult(runId, caseId);
        TestRailRequests.deleteRun(runId);
        TestRailRequests.deleteCase(caseId);
        TestRailRequests.deleteSection(sectionId);
        TestRailRequests.deleteSuite(suiteId);
    }
}
