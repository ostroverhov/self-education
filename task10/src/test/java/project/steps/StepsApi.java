package project.steps;

import framework.utils.TestRailRequests;
import org.testng.Assert;
import project.models.Case;
import project.models.Run;
import project.models.Section;
import project.models.Suite;

public class StepsApi {

    public static int createSuite() throws Throwable {
        Suite createdSuite = TestRailRequests.createSuite();
        int suiteId = createdSuite.getId();
        Assert.assertEquals(createdSuite, TestRailRequests.getSuite(suiteId), "Suites not equals");
        return suiteId;
    }

    public static int createSection(int suiteId) throws Throwable {
        Section testSection = TestRailRequests.createSection(suiteId);
        int sectionId = testSection.getId();
        Assert.assertEquals(testSection, TestRailRequests.getSection(sectionId), "Section not equals");
        return sectionId;
    }

    public static int createCase(int idSection) throws Throwable {
        Case testCase = TestRailRequests.createCase(idSection);
        int caseId = testCase.getId();
        Assert.assertEquals(testCase, TestRailRequests.getCase(caseId), "cases not equals");
        return caseId;
    }

    public static int createRun(int idSection) throws Throwable {
        Run testRun = TestRailRequests.createRun(idSection);
        int runId = testRun.getId();
        Assert.assertEquals(testRun, TestRailRequests.getRun(runId), "Run not equals");
        return runId;
    }
}
