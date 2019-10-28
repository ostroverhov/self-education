package project.steps;

import framework.utils.JsonPlaceholderApi;
import org.testng.Assert;
import project.models.Case;
import project.models.Run;
import project.models.Section;
import project.models.Suite;

public class StepsApi {

    public static int createSuite() throws Throwable {
        Suite createdSuite = JsonPlaceholderApi.createSuite();
        Assert.assertEquals(createdSuite, JsonPlaceholderApi.getSuite(createdSuite.getId()), "Suites not equals");
        return createdSuite.getId();
    }

    public static int createSection(int suiteId) throws Throwable {
        Section testSection = JsonPlaceholderApi.createSection(suiteId);
        Assert.assertEquals(testSection, JsonPlaceholderApi.getSection(testSection.getId()), "Section not equals");
        return testSection.getId();
    }

    public static int createCase(int idSection) throws Throwable {
        Case testCase = JsonPlaceholderApi.createCase(idSection);
        Assert.assertEquals(testCase, JsonPlaceholderApi.getCase(testCase.getId()), "cases not equals");
        return testCase.getId();
    }

    public static int createRun(int idSection) throws Throwable {
        Run testRun = JsonPlaceholderApi.createRun(idSection);
        Assert.assertEquals(testRun, JsonPlaceholderApi.getRun(testRun.getId()), "Run not equals");
        return testRun.getId();
    }

    public static void addResult(int idRun, int idCase) throws Throwable {
        JsonPlaceholderApi.addResult(idRun, idCase);
    }

    public static void deleteSuite(int idSuite) throws Throwable {
        JsonPlaceholderApi.deleteSuite(idSuite);
    }

    public static void deleteSection(int idSection) throws Throwable {
        JsonPlaceholderApi.deleteSection(idSection);
    }

    public static void deleteCase(int idCase) throws Throwable {
        JsonPlaceholderApi.deleteCase(idCase);
    }

    public static void deleteRun(int idRun) throws Throwable {
        JsonPlaceholderApi.deleteRun(idRun);
    }
}
