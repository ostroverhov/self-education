package app.form;

import app.pages.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class ToolsForm extends BasePage {
    public ToolsForm() {
        super("Tools form", By.xpath("//h4"));
    }

    private Button getButtonToolsForm(String nameButton) {
        return new Button(By.xpath(String.format("//h4[contains(text(),'%s')]", nameButton)), nameButton + " button");
    }

    public void clickOnButtonToolsForm(String nameButton) {
        getButtonToolsForm(nameButton).clickElement();
    }
}
