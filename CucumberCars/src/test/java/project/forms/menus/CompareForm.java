package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CompareForm extends Form {

    private static By buttonStartCompareLocator = By.xpath("//button[@class='done-button']");
    private IButton buttonStartCompare = getElementFactory().getButton(buttonStartCompareLocator, "button start compare");
    private IButton buttonDone = getElementFactory().getButton(By.xpath("//button[@class='modal-button']"), "button done");

    private IComboBox dropDownMake = getElementFactory().getComboBox(By.id("make-dropdown"), "dropDownMenu of Maker");
    private IComboBox dropDownModel = getElementFactory().getComboBox(By.id("model-dropdown"), "dropDownMenu of model");
    private IComboBox dropDownYear = getElementFactory().getComboBox(By.id("year-dropdown"), "dropDownMenu of year");

    public CompareForm() {
        super(buttonStartCompareLocator, "Compare form");
    }

    public void selectCar(String make, String model, String year) {
        dropDownMake.selectByText(make);
        dropDownModel.selectByText(model);
        dropDownYear.selectByText(year);
    }

    public void clickButtonStartCompare() {
        buttonStartCompare.click();
    }

    public void clickButtonDone() {
        buttonDone.click();
    }
}
