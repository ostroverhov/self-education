package app.form;

import app.pages.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class TabPanel extends BasePage {

    public TabPanel() {
        super("TabPanel", By.xpath("//div[@class='u-osTile__title']"));
    }

    private Button getButtonTabPanel(String nameButton) {
        return new Button(By.xpath(String.format("//div[@class='u-osTile__title'][contains(text(),'%s')]", nameButton)), getFullElementName(nameButton + " button"));
    }

    public void clickButtonTabPanel(String nameButton) {
        getButtonTabPanel(nameButton).clickElement();
    }
}
