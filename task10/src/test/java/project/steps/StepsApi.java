package project.steps;

import framework.utils.TestRailPlaceholderApi;
import org.testng.Assert;
import project.models.Case;
import project.models.Run;
import project.models.Section;
import project.models.Suite;

public class StepsApi {

    public static int createSuite() throws Throwable {
        Suite createdSuite = TestRailPlaceholderApi.createSuite();
        int suiteId = createdSuite.getId();
        Assert.assertEquals(createdSuite, TestRailPlaceholderApi.getSuite(suiteId), "Suites not equals");
        return suiteId;
    }

    public static int createSection(int suiteId) throws Throwable {
        Section testSection = TestRailPlaceholderApi.createSection(suiteId);
        int sectionId = testSection.getId();
        Assert.assertEquals(testSection, TestRailPlaceholderApi.getSection(sectionId), "Section not equals");
        return sectionId;
    }

    public static int createCase(int idSection) throws Throwable {
        Case testCase = TestRailPlaceholderApi.createCase(idSection);
        int caseId = testCase.getId();
        Assert.assertEquals(testCase, TestRailPlaceholderApi.getCase(caseId), "cases not equals");
        return caseId;
    }

    public static int createRun(int idSection) throws Throwable {
        Run testRun = TestRailPlaceholderApi.createRun(idSection);
        int runId = testRun.getId();
        Assert.assertEquals(testRun, TestRailPlaceholderApi.getRun(runId), "Run not equals");
        return runId;
    }
}
