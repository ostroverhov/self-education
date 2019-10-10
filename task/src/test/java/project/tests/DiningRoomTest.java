package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import project.forms.MainPage;
import project.models.Furniture;
import project.steps.RoomStylerSteps;

import static project.enums.SideBarItem.FURNISH;
import static project.enums.SideBarSearchItem.DININGROOM;

public class DiningRoomTest extends BaseTest {

    @Override
    @Test(description = "Test roomstyler")
    @Parameters(value = {"pathToImage", "pathToImageOnWorkplace", "name"})
    public void runTest(String pathToImage, String pathToImageOnWorkplace, String name) {
        MainPage mainPage = new MainPage();
        RoomStylerSteps.mainPageIsOpened(mainPage);
        RoomStylerSteps.closeWelcomeWindow(mainPage);
        RoomStylerSteps.welcomeWindowIsClose(mainPage);
        RoomStylerSteps.selectSideBarItem(FURNISH, mainPage);
        RoomStylerSteps.sideBarIsOpened(mainPage);
        RoomStylerSteps.selectSideSearchItem(DININGROOM, mainPage);
        RoomStylerSteps.sideSearchIsOpened(mainPage);
        Furniture furniture = new Furniture(pathToImage, pathToImageOnWorkplace, name);
        RoomStylerSteps.dragFurnitureToWorkPlace(furniture, mainPage);
        RoomStylerSteps.isPresentFurnitureOnWorkPlace(furniture, mainPage);
        RoomStylerSteps.clickFurnitureOnWorkPlace(furniture, mainPage);
        RoomStylerSteps.checkParametersFurniture(furniture, mainPage);
        RoomStylerSteps.deleteFurniture(mainPage);
        RoomStylerSteps.checkDeleteFurniture(mainPage);
    }
}
