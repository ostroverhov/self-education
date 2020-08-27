package project.form

import framework.elements.Button
import framework.elements.DropDownMenu
import framework.form.Form
import org.openqa.selenium.By
import project.models.Car

class ResearchForm extends Form {
    private DropDownMenu dropDownMake = new DropDownMenu(By.xpath("//select[@class='_2jV43 _1vzbb']"), getFullElementName("dropDownMenu of Maker"))
    private DropDownMenu dropDownModel = new DropDownMenu(By.xpath("//select[@class='_2jV43 _1AnAd']"), getFullElementName("dropDownMenu of model"))
    private DropDownMenu dropDownYear = new DropDownMenu(By.xpath("//select[@class='_2jV43 ZM4eE']"), getFullElementName("dropDownMenu of year"))
    private Button buttonResearch = new Button(By.xpath("//input[@class='_3iP3L']"), getFullElementName("button research"))

    ResearchForm() {
        super("Research form", By.xpath("//input[@class='_3iP3L']"))
    }

    void clickButtonResearch() {
        buttonResearch.clickElement()
    }

    def selectRandomCar() {
        Car car = new Car()
        car.setMake(dropDownMake.getRandomElement())
        car.setModel(dropDownModel.getRandomElement())
        car.setYear(dropDownYear.getRandomElement())
        car
    }
}