package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ToolsForm extends Form {

    public ToolsForm() {
        super(By.xpath("//h4"), "Tools form");
    }

    private IButton getButtonToolsForm(String nameButton) {
        return getElementFactory().getButton(By.xpath(String.format("//h4[contains(text(),'%s')]", nameButton)), nameButton + " button");
    }

    public void clickOnButtonToolsForm(String nameButton) {
        getButtonToolsForm(nameButton).click();
    }
}
