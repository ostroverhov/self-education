package app.pages;

import app.form.NavigationPanel;
import framework.baseentity.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private NavigationPanel navigationPanel = new NavigationPanel();

    public DashboardPage() {
        super("DashBoard", By.xpath("//ul[@class='menu-utility']"));
    }

    public NavigationPanel getNavigationPanel() {
        return navigationPanel;
    }
}
