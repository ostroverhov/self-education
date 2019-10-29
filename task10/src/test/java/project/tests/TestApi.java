package project.tests;

import framework.base.BaseTest;
import framework.utils.TestRailPlaceholderApi;
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
        TestRailPlaceholderApi.addResult(runId, caseId);
        TestRailPlaceholderApi.deleteRun(runId);
        TestRailPlaceholderApi.deleteCase(caseId);
        TestRailPlaceholderApi.deleteSection(sectionId);
        TestRailPlaceholderApi.deleteSuite(suiteId);
    }
}
