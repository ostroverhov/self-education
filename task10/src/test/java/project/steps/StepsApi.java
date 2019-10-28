package project.steps;

import framework.utils.JsonPlaceholderApi;
import org.testng.Assert;
import project.models.*;

public class StepsApi {

    public static int createSuite() throws Throwable {
        Suite createdSuite = JsonPlaceholderApi.createSuite();
        Assert.assertEquals(createdSuite, JsonPlaceholderApi.getSuite(createdSuite.getId()), "Suites not equals");
        System.out.println(JsonPlaceholderApi.getSuite(createdSuite.getId()));
        return createdSuite.getId();
    }

    public static int createSection(int suiteId) throws Throwable {
        Section testSection = JsonPlaceholderApi.createSection(suiteId);
        Assert.assertEquals(testSection, JsonPlaceholderApi.getSection(testSection.getId()), "Section not equals");
        System.out.println(JsonPlaceholderApi.getSection(testSection.getId()));
        return testSection.getId();
    }

    public static int createCase(int idSection) throws Throwable {
        Case testCase = JsonPlaceholderApi.createCase(idSection);
        Assert.assertEquals(testCase, JsonPlaceholderApi.getCase(testCase.getId()), "cases not equals");
        System.out.println(JsonPlaceholderApi.getCase(testCase.getId()));
        return testCase.getId();
    }

    public static int createRun(int idSection) throws Throwable {
        Run testRun = JsonPlaceholderApi.createRun(idSection);
        Assert.assertEquals(testRun, JsonPlaceholderApi.getRun(testRun.getId()), "Run not equals");
        System.out.println(JsonPlaceholderApi.getRun(testRun.getId()));
        return testRun.getId();
    }

    public static Result addResult(int idRun, int idCase) throws Throwable {
        return JsonPlaceholderApi.addResult(idRun, idCase);
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
