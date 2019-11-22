package project.form

import framework.elements.Button
import framework.form.Form
import org.openqa.selenium.By

class ToolsForm extends Form {
    ToolsForm() {
        super("Tools form", By.xpath("//h4"))
    }

    private getButtonToolsForm(String nameButton) {
        new Button(By.xpath(String.format("//h4[contains(text(),'%s')]", nameButton)), nameButton + " button")
    }

    void clickOnButtonToolsForm(String nameButton) {
        getButtonToolsForm(nameButton).clickElement()
    }
}
