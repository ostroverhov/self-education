package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.models.Car;

import java.util.concurrent.ThreadLocalRandom;

public class ResearchForm extends Form {

    private IComboBox dropDownMake = getElementFactory().getComboBox(By.xpath("//select[@class='_2jV43 _1vzbb']"), "dropDownMenu of Maker");
    private IComboBox dropDownModel = getElementFactory().getComboBox(By.xpath("//select[@class='_2jV43 _1AnAd']"), "dropDownMenu of model");
    private IComboBox dropDownYear = getElementFactory().getComboBox(By.xpath("//select[@class='_2jV43 ZM4eE']"), "dropDownMenu of year");
    private IButton buttonResearch = getElementFactory().getButton(By.xpath("//input[@class='_3iP3L']"), "button research");

    public ResearchForm() {
        super(By.xpath("//input[@class='_3iP3L']"), "Research form");
    }

    public void clickButtonResearch() {
        buttonResearch.click();
    }

    public void selectCar(Car car) {
        setValueComboBox(dropDownMake, car.getMake());
        setValueComboBox(dropDownModel, car.getModel());
        setValueComboBox(dropDownYear, car.getYear());
    }

    public Car selectRandomCar() {
        Car car = new Car();
        getRandomValue(dropDownMake);
        getRandomValue(dropDownModel);
        getRandomValue(dropDownYear);
        car.setMake(dropDownMake.getSelectedText());
        car.setModel(dropDownModel.getSelectedText());
        car.setYear(dropDownYear.getSelectedText());
        return car;
    }

    private void setValueComboBox(IComboBox comboBox, String parameter) {
        comboBox.selectByText(parameter);
    }

    public void getRandomValue(IComboBox comboBox) {
        comboBox.selectByIndex(ThreadLocalRandom.current().nextInt(1, comboBox.getTexts().size()));
    }
}
