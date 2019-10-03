package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import project.models.Furniture;
import project.steps.RoomStylerSteps;

import static project.enums.SideBarItem.FURNISH;
import static project.enums.SideBarSearchItem.DININGROOM;

public class DiningRoomTest extends BaseTest {

    @Override
    @Test(description = "Test roomstyler")
    @Parameters(value = {"pathToImage", "pathToImageOnWorkplace", "name"})
    public void runTest(String pathToImage, String pathToImageOnWorkplace, String name) {
        RoomStylerSteps roomStylerSteps = new RoomStylerSteps();
        roomStylerSteps.mainPageIsOpened();
        roomStylerSteps.closeWelcomeWindow();
        roomStylerSteps.welcomeWindowIsClose();
        roomStylerSteps.selectSideBarItem(FURNISH);
        roomStylerSteps.sideBarIsOpened();
        roomStylerSteps.selectSideSearchItem(DININGROOM);
        roomStylerSteps.sideSearchIsOpened();
        Furniture furniture = new Furniture(pathToImage, pathToImageOnWorkplace, name);
        roomStylerSteps.dragAndDrop(furniture);
        roomStylerSteps.isPresentOnWorkPlace(furniture);
        roomStylerSteps.clickFurniture(furniture);
        roomStylerSteps.checkParametersFurniture(furniture);
        roomStylerSteps.deleteFurniture();
        roomStylerSteps.checkDeleteFurniture();
    }
}
