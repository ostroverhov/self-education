package project.form

import framework.elements.Button
import framework.elements.DropDownMenu
import framework.form.Form
import org.openqa.selenium.By

class CompareForm extends Form {
    private static By buttonStartCompareLocator = By.xpath("//button[@class='done-button']")

    private Button buttonStartCompare = new Button(buttonStartCompareLocator, getFullElementName("button start compare"))
    private Button buttonDone = new Button(By.xpath("//button[@class='modal-button']"), getFullElementName("button done"))

    private DropDownMenu dropDownMake = new DropDownMenu(By.id("make-dropdown"), getFullElementName("dropDownMenu of Maker"))
    private DropDownMenu dropDownModel = new DropDownMenu(By.id("model-dropdown"), getFullElementName("dropDownMenu of model"))
    private DropDownMenu dropDownYear = new DropDownMenu(By.id("year-dropdown"), getFullElementName("dropDownMenu of year"))

    CompareForm() {
        super("Compare form", buttonStartCompareLocator)
    }

    void selectCar(def make, def model, def year) {
        dropDownMake.clickSelectElement(make)
        dropDownModel.clickSelectElement(model)
        dropDownYear.clickSelectElement(year)
    }

    void clickButtonStartCompare() {
        buttonStartCompare.clickElement()
    }

    void clickButtonDone() {
        buttonDone.clickElement()
    }
}
