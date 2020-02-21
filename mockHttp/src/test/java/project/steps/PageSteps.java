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

import java.util.ArrayList;
import java.util.Date;

public class PageSteps {

    private static final String variant = "1";
    private static final String cookieKey = "token";
    private static final String patternGetVariant = "Version: (\\d)";
    private static final String nameFrame = "addProjectFrame";
    private static final int lengthRandomName = 10;
    private static final String pathToLogFile = "src/test/resources/logResult.txt";
    private static final String pathToScreenshot = "src/test/resources/screenshot.png";

    public static void setVariant(String token) {
        MainPage mainPage = new MainPage();
        CookieUtils.addCookie(cookieKey, token);
        Assert.assertTrue(mainPage.isFormDisplayed(), "Main page not found");
        BrowserUtils.refreshPage();
        Assert.assertEquals(RegExpUtils.getPartFromString(patternGetVariant, mainPage.getTextFromFooter()), variant, "Variant not equals");
    }

    public static void goToPageOfProject(ArrayList<TestModel> testsFromRequest, NameProject nameProject) {
        MainPage mainPage = new MainPage();
        ProjectPage projectPage = new ProjectPage();
        getMenuProjects(mainPage).clickBtnProject(nameProject.getNameProject());
        ArrayList<TestModel> testsFromPage = getTableTests(projectPage).getListTests();
        assertListDate(testsFromPage);
        Assert.assertTrue(testsFromRequest.containsAll(testsFromPage), "Collections not equals");
    }

    public static String createNewProject() {
        MainPage mainPage = new MainPage();
        BrowserUtils.goBack();
        getMenuProjects(mainPage).clickBtnAddProject();
        IframeUtils.switchToFrame(nameFrame);
        String nameNewProject = RandomUtils.generateRandomString(lengthRandomName);
        getAddProjectForm(mainPage).inputNameProject(nameNewProject);
        getAddProjectForm(mainPage).clickBtnSaveProject();
        Assert.assertTrue(getAddProjectForm(mainPage).isPresentLabelSuccessfulAddProject(), "message successful addition not appeared");
        IframeUtils.switchToMainPage();
        JsUtils.closePopUp();
        Assert.assertTrue(getAddProjectForm(mainPage).isClosePopUp(), "Form add project not closed");
        BrowserUtils.refreshPage();
        Assert.assertTrue(getMenuProjects(mainPage).getListNameTests().contains(nameNewProject), "Project not add to list");
        return nameNewProject;
    }

    public static void checkLastTest(TestModel testModel) {
        ProjectPage projectPage = new ProjectPage();
        getTableTests(projectPage).clickLastTest();
        TestPage testPage = new TestPage();
        assertTests(testModel, testPage);
    }

    private static void assertListDate(ArrayList<TestModel> tests) {
        for (int i = 0; i < tests.size() - 1; i++) {
            Assert.assertTrue(getStartTimeOfTests(tests, i).after(getStartTimeOfTests(tests, i + 1)), "List not sorted at position" + i);
        }
    }

    private static Date getStartTimeOfTests(ArrayList<TestModel> tests, int numberTest) {
        return tests.get(numberTest).getStartDateTime();
    }

    private static void assertTests(TestModel testModel, TestPage testPage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getNameTest(), testModel.getName(), "name not equals");
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getMethodTest(), testModel.getMethod(), "method not equals");
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getStatusTest(), testModel.getStatusWord(), "status not equals");
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getStartTimeTest(), testModel.getStartTime(), "start time not equals");
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getEndTimeTest(), testModel.getEndTime(), "end time not equals");
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getEnvironmentTest(), testModel.getEnvironment(), "environment not equals");
        softAssert.assertEquals(getPanelInfoOfTest(testPage).getBrowser(), testModel.getBrowser(), "browser not equals");
        softAssert.assertEquals(testPage.getLog(), ReaderUtils.readFile(pathToLogFile), "log not equals");
        softAssert.assertEquals(testPage.getAttachment(), ScreenShotUtils.screenShotToString(pathToScreenshot), "Base64 code of image not equals");
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
