package project.forms;

import aquality.selenium.forms.Form;
import framework.elements.SikuliElement;
import org.openqa.selenium.By;
import project.forms.menus.SideBar;
import project.forms.menus.WelcomeWindow;
import project.models.Furniture;

public class MainPage extends Form {

    private static final String pathToImgCloseElement = "img/closeElement.png";
    private static final String pathToWorkPlace = "img/workPlace.png";
    private static final String pathToEmptyWorkPlace = "img/emptyWorkPlace.png";

    public MainPage() {
        super(By.id("view-menu"), "Main page");
    }

    public SideBar getSideBar() {
        return sideBar;
    }

    public WelcomeWindow getWelcomeWindow() {
        return welcomeWindow;
    }

    public void dragToWorkPlace(Furniture furniture) {
        SikuliElement.dragAndDrop(furniture.getPathToImageFromSideBar(), pathToWorkPlace);
    }

    public boolean isPresentOnWorkPlace(Furniture furniture) {
        return SikuliElement.isPresent(furniture.getPathToImageOnWorkSpace());
    }

    public void clickFurniture(Furniture furniture) {
        SikuliElement.clickImage(furniture.getPathToImageOnWorkSpace());
    }

    public void clickDeleteFurniture() {
        SikuliElement.clickImage(pathToImgCloseElement);
    }

    public boolean isEmptyWorkPlace() {
        return SikuliElement.isPresent(pathToEmptyWorkPlace);
    }

    private WelcomeWindow welcomeWindow = new WelcomeWindow();

    private SideBar sideBar = new SideBar();
}