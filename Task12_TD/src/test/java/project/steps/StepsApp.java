package project.steps;

import framework.utils.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import project.enums.NameProject;
import project.forms.MainPage;
import project.forms.ProjectPage;
import project.forms.TestPage;
import project.forms.menus.AddProjectForm;
import project.forms.menus.MenuProjects;
import project.forms.menus.PanelInfoOfTest;
import project.forms.menus.TableTests;
import project.models.TestModel;
import project.projectutils.Requests;
import project.projectutils.SqlQueries;
import project.projectutils.WebsiteUtils;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static project.enums.NameProject.NEWPROJECT;

public class StepsApp {

    private static final String variant = "1";
    private static final String cookieKey = "token";
    private static final String patternGetVariant = "Version: (\\d)";
    private static final String nameFrame = "addProjectFrame";
    private static final int lengthRandomName = 10;
    private static final String pathToLogFile = "src/test/resources/logResult.txt";
    private static final String pathToScreenshot = "src/test/resources/screenshot.png";

    public static String getToken() throws Throwable {
        String token = Requests.getToken(variant);
        Assert.assertFalse(token.isEmpty(), "token don't get");
        return token;
    }

    public static void setVariant(MainPage mainPage, String token) {
        CookieUtils.addCookie(cookieKey, token);
        Assert.assertTrue(mainPage.isFormDisplayed(), "Main page not found");
        WebsiteUtils.refreshPage();
        Assert.assertEquals(RegExpUtils.getPartFromString(patternGetVariant, mainPage.getTextFromFooter()), variant, "Variant not equals");
    }

    public static void goToPageNexage(MainPage mainPage, NameProject nameProject, ProjectPage projectPage) throws Throwable {
        ArrayList<TestModel> testsFromRequest = Requests.getTests(getMenuProjects(mainPage).getIdProject(nameProject));
        getMenuProjects(mainPage).clickBtnProject(nameProject);
        ArrayList<TestModel> testsFromPage = getTableTests(projectPage).getListTests();
        assertListDate(testsFromPage);
        Assert.assertTrue(testsFromRequest.containsAll(testsFromPage), "Collections not equals");
    }

    public static void createNewProject(MainPage mainPage) {
        WebsiteUtils.goToMainPage();
        getMenuProjects(mainPage).clickBtnAddProject();
        IframeUtils.switchToFrame(nameFrame);
        String nameNewProject = RandomUtils.generateRandomString(lengthRandomName);
        getAddProjectForm(mainPage).inputNameProject(nameNewProject);
        getAddProjectForm(mainPage).clickBtnSaveProject();
        Assert.assertTrue(getAddProjectForm(mainPage).isPresentLabelSuccessfulAddProject(), "message successful addition not appeared");
        IframeUtils.switchToMainPage();
        JsUtils.closePopUp();
        Assert.assertTrue(getAddProjectForm(mainPage).isClosePopUp(), "Form add project not closed");
        WebsiteUtils.refreshPage();
        Assert.assertTrue(getMenuProjects(mainPage).getListNameTests().contains(nameNewProject), "Project not add");
        NEWPROJECT.setNameProject(nameNewProject);
    }

    public static void addTestToProject(MainPage mainPage, TestModel testModel, ProjectPage projectPage) throws SQLException {
        SqlUtils.executeQuery(SqlQueries.getQueryAddTest(getMenuProjects(mainPage).getIdProject(NEWPROJECT), testModel));
        getMenuProjects(mainPage).clickBtnProject(NEWPROJECT);
        Assert.assertEquals(getTableTests(projectPage).getNameLastTest(), testModel.getName(), "test not add");
    }

    public static void checkLastTest(TestModel testModel, ProjectPage projectPage) throws Exception {
        String idTest = getTableTests(projectPage).getTestId();
        SqlUtils.executeQuery(SqlQueries.getQueryAddLog(pathToLogFile, idTest));
        SqlUtils.executeQuery(SqlQueries.getQueryAddScreenshot(pathToScreenshot, idTest));
        getTableTests(projectPage).clickLastTest();
        TestPage testPage = new TestPage();
        assertTests(testModel, testPage);
    }

    private static void assertListDate(ArrayList<TestModel> tests) throws ParseException {
        for (int i = 0; i < tests.size() - 1; i++) {
            Assert.assertTrue(getStartTimeOfTests(tests, i).after(getStartTimeOfTests(tests, i + 1)), "List not sorted at position" + i);
        }
    }

    private static Date getStartTimeOfTests(ArrayList<TestModel> tests, int numberTest) throws ParseException {
        return tests.get(numberTest).getStartDateTime();
    }

    private static void assertTests(TestModel testModel, TestPage testPage) throws Exception {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getNameTest(), testModel.getName(), "name not equals");
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getMethodTest(), testModel.getMethod(), "method not equals");
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getStatusTest(), testModel.getStatusWord(), "status not equals");
        softAssert.assertTrue(getPanelInfoOfTest(testPage).getStartTimeTest().contains(testModel.getStartTime()), "start time not equals");
        softAssert.assertTrue(getPanelInfoOfTest(testPage).getEndTimeTest().contains(testModel.getEndTime()), "end time not equals");
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getEnvironmentTest(), testModel.getEnvironment(), "environment not equals");
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getBrowser(), testModel.getBrowser(), "browser not equals");
        softAssert.assertEquals(testPage.getLog(), ReaderUtils.readFile(pathToLogFile), "log not equals");
        softAssert.assertTrue(testPage.getAttachment().contains(ScreenShotUtils.screenShotToString(pathToScreenshot)), "Base64 code of image not equals");
        softAssert.assertAll();
    }

    private static PanelInfoOfTest getPanelInfoOfTest(TestPage testPage) {
        return testPage.getPanelInfoOfTest();
    }

    private static AddProjectForm getAddProjectForm(MainPage mainPage) {
        return mainPage.getAddProjectForm();
    }

    private static MenuProjects getMenuProjects(MainPage mainPage) {
        return mainPage.getMenuProjects();
    }

    private static TableTests getTableTests(ProjectPage projectPage) {
        return projectPage.getTableTests();
    }
}
