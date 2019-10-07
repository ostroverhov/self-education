package app.form;

import framework.baseentity.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class NavigationPanel extends BasePage {

    private static String navigationPaneLocator = "//div[@class='w-menu__item-header-text']";

    public NavigationPanel() {
        super("NavigationPanel", By.xpath(navigationPaneLocator));
    }

    private Button getButtonNavigationPanel(String nameButton) {
        return new Button(By.xpath(String.format("%s[contains(text(),'%s')]", navigationPaneLocator, nameButton)), getFullElementName(nameButton + " button"));
    }

    public void clickButtonNavigationPanel(NavigationPanelItem nameButton) {
        getButtonNavigationPanel(nameButton.getPanelItem()).clickElement();
    }
}
