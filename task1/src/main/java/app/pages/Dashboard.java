package app.pages;

import app.form.NavigationPanel;
import org.openqa.selenium.By;

public class Dashboard extends BasePage {
    private NavigationPanel navigationPanel = new NavigationPanel();

    public Dashboard() {
        super("DashBoard", By.xpath("//ul[@class='menu-utility']"));
    }

    public NavigationPanel getNavigationPanel() {
        return navigationPanel;
    }
}
