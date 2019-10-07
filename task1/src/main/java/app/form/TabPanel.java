package app.form;

import framework.baseentity.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class TabPanel extends BasePage {

    public TabPanel(By locator) {
        super("TabPanel", locator);
    }

    private Button getButtonTabPanel(String nameButton) {
        return new Button(By.xpath(String.format("//div[@class='u-osTile__title'][contains(text(),'%s')]", nameButton)), getFullElementName(nameButton + " button"));
    }

    public void clickButtonTabPanel(String nameButton) {
        getButtonTabPanel(nameButton).clickElement();
    }
}
