package app.form;

import app.pages.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class NavigationPanel extends BasePage {
    public NavigationPanel() {
        super("NavigationPanel", By.xpath("//div[@class='w-menu__item-header-text']"));
    }

    private Button getButtonNavigationPanel(String nameButton) {
        return new Button(By.xpath(String.format("//div[@class='w-menu__item-header-text'][contains(text(),'%s')]", nameButton)), getFullElementName(nameButton + " button"));
    }

    public void clickButtonNavigationPanel(NavigationPanelItem nameButton) {
        getButtonNavigationPanel(nameButton.getPanelItem()).clickElement();
    }
}
