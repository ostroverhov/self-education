package project.steps;

import framework.utils.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import project.enums.NameProject;
import project.forms.MainPage;
import project.forms.ProjectPage;
import project.forms.TestPage;
import project.forms.menus.PanelInfoOfTest;
import project.models.TestModel;
import project.projectutils.Requests;
import project.projectutils.SqlQueries;
import project.projectutils.WebsiteUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static project.enums.NameProject.NEWPROJECT;

public class StepsTD {

    private static final String variant = "1";
    private static final String сookieKey = "token";
    private static final String patternGetVariant = "Version: (\\d)";
    private static final String nameFrame = "addProjectFrame";
    private static final int lengthRandomName = 10;
    private static final String pathToLogFile = "src/test/resources/logResult.txt";
    private static final String pathToScreenshot = "src/test/resources/screenshot.jpg";

    public static String getToken() throws Throwable {
        String token = Requests.getToken(variant);
        Assert.assertFalse(token.isEmpty(), "token don't get");
        return token;
    }

    public static void setVariant(MainPage mainPage, String token) {
        CookieUtils.addCookie(сookieKey, token);
        Assert.assertTrue(mainPage.isFormDisplayed(), "Main page not found");
        WebsiteUtils.refreshPage();
        Assert.assertEquals(RegExpUtils.getPartFromString(patternGetVariant, mainPage.getTextFromFooter()), variant, "Variant not equals");
    }

    public static void goToPageNexage(MainPage mainPage, NameProject nameProject) throws Throwable {
        ArrayList<TestModel> testsFromRequest = Requests.getTests(mainPage.getMenuProjects().getIdProject(nameProject)); //todo dublicate but all ok
        mainPage.getMenuProjects().clickBtnProject(nameProject);

        ProjectPage projectPage = new ProjectPage();
        ArrayList<TestModel> testsFromPage = projectPage.getTableTests().getListTests();
        assertListDate(testsFromPage);
        Assert.assertTrue(testsFromRequest.containsAll(testsFromPage), "Collections not equals");
    }

    public static void createNewProject(MainPage mainPage) {
        WebsiteUtils.goToMainPage();
        mainPage.getMenuProjects().clickBtnAddProject();
        IframeUtils.switchToFrame(nameFrame);
//        String nameNewProject = RandomUtils.generateRandomString(lengthRandomName);
        String nameNewProject = "asda";
        mainPage.getAddProjectForm().inputNameProject(nameNewProject);
//        mainPage.getAddProjectForm().clickBtnSaveProject();
//        Assert.assertTrue(mainPage.getAddProjectForm().isPresentLabelSuccessfulAddProject(), "message successful addition not appeared");
        IframeUtils.switchToMainPage();
        JsUtils.closePopUp();
        Assert.assertTrue(mainPage.getAddProjectForm().isClosePopUp(), "Form add project not closed");
        WebsiteUtils.refreshPage();
        Assert.assertTrue(mainPage.getMenuProjects().getListNameTests().contains(nameNewProject), "Project not add");
        NEWPROJECT.setNameProject(nameNewProject);
    }

    public static void addTestToProject(MainPage mainPage, TestModel testModel) throws IOException, SQLException {
        String idProject = mainPage.getMenuProjects().getIdProject(NEWPROJECT); //todo dublicaate
        mainPage.getMenuProjects().clickBtnProject(NEWPROJECT);
        SqlUtils.executeQuery(SqlQueries.getQueryAddTest(idProject, testModel));
        ProjectPage projectPage = new ProjectPage();
        Assert.assertEquals(projectPage.getTableTests().getNameLastTest(), testModel.getName(), "test not add");
    }

    public static void checkLastTest(TestModel testModel) throws Exception {
        ProjectPage projectPage = new ProjectPage();
        String idTest = projectPage.getTableTests().getTestId();
        SqlUtils.executeQuery(SqlQueries.getQueryAddLog(pathToLogFile, idTest));
        SqlUtils.executeQuery(SqlQueries.getQueryAddScreenshot(pathToScreenshot, idTest)); //todo screenshot
        projectPage.getTableTests().clickLastTest();
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
        softAssert.assertEquals(testPage.getPanelInfoOfTest().getNameTest(), testModel.getName(), "name not equals");
        softAssert.assertEquals(testPage.getPanelInfoOfTest().getMethodTest(), testModel.getMethod(), "method not equals");
        softAssert.assertEquals(testPage.getPanelInfoOfTest().getStatusTest(), testModel.getStatusWord(), "status not equals");
        softAssert.assertTrue(testPage.getPanelInfoOfTest().getStartTimeTest().endsWith(testModel.getStartTime()), "start time not equals");
        softAssert.assertTrue(testPage.getPanelInfoOfTest().getEndTimeTest().endsWith(testModel.getEndTime()), "end time not equals");
        softAssert.assertEquals(testPage.getPanelInfoOfTest().getEnvironmentTest(), testModel.getEnvironment(), "environment not equals");
        softAssert.assertEquals(testPage.getPanelInfoOfTest().getBrowser(), testModel.getBrowser(), "browser not equals");
//        softAssert.assertEquals(testPage.getLog(), ReaderUtils.readFile(pathToLogFile), "log not equals");
//        softAssert.assertAll(testPage.getAttachment(), ScreenShotUtils.);
        softAssert.assertAll();
    }

    private static PanelInfoOfTest getPanelInfoOfTest(TestPage testPage) {
        return testPage.getPanelInfoOfTest();
    }


}
