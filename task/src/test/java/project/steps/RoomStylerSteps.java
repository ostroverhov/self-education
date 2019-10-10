package project.steps;

import aquality.selenium.forms.Form;
import org.testng.Assert;
import project.enums.SideBarItem;
import project.enums.SideBarSearchItem;
import project.forms.MainPage;
import project.forms.menus.SideBar;
import project.forms.menus.WelcomeWindow;
import project.models.Furniture;

public class RoomStylerSteps {

    public static void mainPageIsOpened(MainPage mainPage) {
        assertIsOpen(mainPage, "Main page");
    }

    public static void closeWelcomeWindow(MainPage mainPage) {
        getWelcomeWindow(mainPage).clickCloseWindow();
    }

    public static void welcomeWindowIsClose(MainPage mainPage) {
        Assert.assertFalse(getWelcomeWindow(mainPage).isFormDisplayed(0L), "Welcome window is closed");
    }

    public static void selectSideBarItem(SideBarItem sideBarItem, MainPage mainPage) {
        getSideBar(mainPage).clickBtnSideBar(sideBarItem);
    }

    public static void sideBarIsOpened(MainPage mainPage) {
        assertIsOpen(getSideBar(mainPage), "Side bar");
    }

    public static void selectSideSearchItem(SideBarSearchItem sideBarSearchItem, MainPage mainPage) {
        getSideBar(mainPage).getSideBarSearch().clickBtnSideSearch(sideBarSearchItem);
    }

    public static void sideSearchIsOpened(MainPage mainPage) {
        assertIsOpen(getSideBar(mainPage).getSideBarSearch(), "Side search");
    }

    public static void dragFurnitureToWorkPlace(Furniture furniture, MainPage mainPage) {
        mainPage.dragToWorkPlace(furniture);
    }

    public static void isPresentFurnitureOnWorkPlace(Furniture furniture, MainPage mainPage) {
        Assert.assertTrue(mainPage.isPresentOnWorkPlace(furniture), "Furniture item is present");
    }

    public static void clickFurnitureOnWorkPlace(Furniture furniture, MainPage mainPage) {
        mainPage.clickFurniture(furniture);
    }

    public static void checkParametersFurniture(Furniture furniture, MainPage mainPage) {
        furniture.setParametersFurniture(getSideBar(mainPage).getSideBarProperties().getParametersFurniture());
        assertParameters(furniture.getParametersFurniture().getHeight(), "height");
        assertParameters(furniture.getParametersFurniture().getLength(), "length");
        assertParameters(furniture.getParametersFurniture().getWidth(), "width");
        Assert.assertEquals(getSideBar(mainPage).getSideBarProperties().getNameFurniture(), furniture.getNameFurniture(), "Name furniture not equals");
    }

    public static void deleteFurniture(MainPage mainPage) {
        mainPage.clickDeleteFurniture();
    }

    public static void checkDeleteFurniture(MainPage mainPage) {
        for (String sceneInfo : getSideBar(mainPage).getSideBarProperties().getSceneInformation()) {
            Assert.assertEquals("0", sceneInfo, "Parameter not equals 0");
        }
        Assert.assertTrue(mainPage.isEmptyWorkPlace(), "WorkPlace is empty");
    }

    private static SideBar getSideBar(MainPage mainPage) {
        return mainPage.getSideBar();
    }

    private static WelcomeWindow getWelcomeWindow(MainPage mainPage) {
        return mainPage.getWelcomeWindow();
    }

    private static void assertParameters(String parameter, String nameParameter) {
        Assert.assertNotEquals(0, Integer.valueOf(parameter), nameParameter + " not equals 0");
    }

    private static void assertIsOpen(Form form, String nameForm) {
        Assert.assertTrue(form.isFormDisplayed(), nameForm + " is opened");
    }
}