package project.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.SideBar;
import project.forms.menus.WelcomeWindow;

public class MainPage extends Form {

    public MainPage() {
        super(By.id("view-menu"), "Main page");
    }

    public SideBar getSideBar() {
        return sideBar;
    }

    public WelcomeWindow getWelcomeWindow() {
        return welcomeWindow;
    }

    private WelcomeWindow welcomeWindow = new WelcomeWindow();

    private SideBar sideBar = new SideBar();
}