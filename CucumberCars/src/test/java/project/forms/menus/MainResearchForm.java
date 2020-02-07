package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.models.Car;

public class MainResearchForm extends Form {

    private IComboBox dropDownStockType = getElementFactory().getComboBox(By.xpath("//select[@name='stockType']"), "dropDownMenu of stock type");
    private IComboBox dropDownMake = getElementFactory().getComboBox(By.xpath("//select[@name='makeId']"), "dropDownMenu of Maker");
    private IComboBox dropDownModel = getElementFactory().getComboBox(By.xpath("//select[@name='modelId']"), "dropDownMenu of model");
    private IComboBox dropDownPriceMax = getElementFactory().getComboBox(By.xpath("//select[@name='priceMax']"), "dropDownMenu of max price");
    private IComboBox dropDownRadius = getElementFactory().getComboBox(By.xpath("//select[@name='radius']"), "dropDownMenu of radius");
    private ITextBox textBoxZip = getElementFactory().getTextBox(By.xpath("//input[@name='zip']"), "text box ZIP");
    private IButton buttonSearch = getElementFactory().getButton(By.xpath("//input[@value='Search']"), "button search");

    public MainResearchForm() {
        super(By.xpath("//input[@class='NZE2g']"), "Search form on main page");
    }

    public void clickButtonSearch() {
        buttonSearch.click();
    }

    public void selectCar(String stockType, Car car, String maxPrice, String radius, String zip) {
        setValueComboBox(dropDownStockType, stockType);
        setValueComboBox(dropDownMake, car.getMake());
        setValueComboBox(dropDownModel, car.getModel());
        setValueComboBox(dropDownPriceMax, maxPrice);
        setValueComboBox(dropDownRadius, radius);
        textBoxZip.type(zip);
    }

    private void setValueComboBox(IComboBox comboBox, String parameter) {
        comboBox.selectByContainingText(parameter);
    }
}
