package project.steps;

import framework.elements.SikuliElement;
import org.testng.Assert;
import project.enums.SideBarItem;
import project.enums.SideBarSearchItem;
import project.forms.MainPage;
import project.forms.menus.SideBar;
import project.forms.menus.WelcomeWindow;
import project.models.Furniture;
import project.models.ParametersFurniture;
import project.utils.RegexpHandler;

public class RoomStylerSteps {

    private static final String pathToImgCloseElement = "img/closeElement.png"; //todo где оставить
    private static final String pathToWorkPlace = "img/workPlace.png";
    private static final String pathToEmptyWorkPlace = "img/emptyWorkPlace.png";

    public void mainPageIsOpened() {
        Assert.assertTrue(new MainPage().isFormDisplayed(), "Sites main page is opened");
    }

    public void closeWelcomeWindow() {
        getWelcomeWindow().clickCloseWindow();
    }

    public void welcomeWindowIsClose() {
        Assert.assertTrue(getWelcomeWindow().isInvisibleBtnClose(), "Welcome window is closed");
    }

    public void selectSideBarItem(SideBarItem sideBarItem) {
        getSideBar().clickBtnSideBar(sideBarItem);
    }

    public void sideBarIsOpened() {
        Assert.assertTrue(getSideBar().isFormDisplayed(), "Side bar search is opened");
    }

    public void selectSideSearchItem(SideBarSearchItem sideBarSearchItem) {
        getSideBar().getSideBarSearch().clickBtnSideSearch(sideBarSearchItem);
    }

    public void sideSearchIsOpened() {
        Assert.assertTrue(getSideBar().getSideBarSearch().isFormDisplayed(), "Side search is opened");
    }

    public void dragAndDrop(Furniture furniture) {
        SikuliElement.dragAndDrop(furniture.getPathToImageFromSideBar(), pathToWorkPlace);
    }

    public void isPresentOnWorkPlace(Furniture furniture) {
        Assert.assertTrue(SikuliElement.isPresent(furniture.getPathToImageOnWorkSpace()), "Furniture item is present");
    }

    public void clickFurniture(Furniture furniture) {
        SikuliElement.clickImage(furniture.getPathToImageOnWorkSpace());
    }

    public void checkParametersFurniture(Furniture furniture) {
        ParametersFurniture parametersFurniture = RegexpHandler.getParametersFurniture(getSideBar().getSideBarProperties().getSizeFurniture());
        assertPrametrs(parametersFurniture.getHeight(), "height");
        assertPrametrs(parametersFurniture.getLength(), "length");
        assertPrametrs(parametersFurniture.getWidth(), "width");
        Assert.assertEquals(getSideBar().getSideBarProperties().getNameFurniture(), furniture.getNameFurniture(), "Name furniture not equals");
    }

    public void deleteFurniture() {
        SikuliElement.clickImage(pathToImgCloseElement);
    }

    public void checkDeleteFurniture() {
        for (String sceneInfo : getSideBar().getSideBarProperties().getSceneInformation()) {
            Assert.assertEquals("0", sceneInfo, "Parameter not equals 0");
        }
        Assert.assertTrue(SikuliElement.isPresent(pathToEmptyWorkPlace), "WorkPlace is empty");
    }

    private SideBar getSideBar() {
        return new MainPage().getSideBar();
    }

    private WelcomeWindow getWelcomeWindow() {
        return new MainPage().getWelcomeWindow();
    }

    private void assertPrametrs(String parametr, String nameParameter) {
        Assert.assertNotEquals(0, Integer.valueOf(parametr), nameParameter + " not equals 0");
    }
}