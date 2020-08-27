package project.steps;

import framework.utils.SqlUtils;
import org.testng.Assert;
import project.forms.MainPage;
import project.forms.ProjectPage;
import project.forms.menus.MenuProjects;
import project.forms.menus.TableTests;
import project.models.TestModel;
import project.projectutils.SqlQueries;

public class DataBaseSteps {

    private static final String pathToLogFile = "src/test/resources/logResult.txt";
    private static final String pathToScreenshot = "src/test/resources/screenshot.png";

    public static void addTestToProject(TestModel testModel, String nameProject) {
        MainPage mainPage = new MainPage();
        ProjectPage projectPage = new ProjectPage();
        SqlUtils.executeQuery(SqlQueries.getQueryAddTest(getMenuProjects(mainPage).getIdProject(nameProject), testModel));
        getMenuProjects(mainPage).clickBtnProject(nameProject);
        String idTest = getTableTests(projectPage).getTestId();
        SqlUtils.executeQuery(SqlQueries.getQueryAddLog(pathToLogFile, idTest));
        SqlUtils.executeQuery(SqlQueries.getQueryAddScreenshot(pathToScreenshot, idTest));
        Assert.assertEquals(getTableTests(projectPage).getNameLastTest(), testModel.getName(), "test not add");
    }

    private static MenuProjects getMenuProjects(MainPage mainPage) {
        return mainPage.getMenuProjects();
    }

    private static TableTests getTableTests(ProjectPage projectPage) {
        return projectPage.getTableTests();
    }
}
