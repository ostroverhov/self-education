package project.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import project.enums.MenuHeaderItem;
import project.forms.CarPage;
import project.forms.CompareTrimPage;
import project.forms.ResearchPage;
import project.forms.menus.TrimCard;
import project.models.Car;
import project.models.Trim;
import project.utils.AssertsCar;
import project.utils.CarStore;

public class SearchCarSteps {

    private static ResearchPage researchPage = new ResearchPage();
    private static CarPage carPage = new CarPage();
    private static CompareTrimPage compareTrimPage = new CompareTrimPage();
    private static TrimCard trimCard = compareTrimPage.getTrimCard();
    private static Car car;

    @When("^Search '(.*)'$")
    public void searchCar(String nameCar) {
        Car car = CarStore.getCarFromStorage(nameCar);
        researchPage.getResearchForm().selectCar(car);
        researchPage.getResearchForm().clickButtonResearch();
    }

    @Then("^'(.*)' is found$")
    public void checkFoundCar(String nameCar) {
        AssertsCar.assertMakeModelYear(carPage.getInfoSection().getTextPanelInfoCar(), CarStore.getCarFromStorage(nameCar));
    }

    @When("^Click “Compare trims” link$")
    public void clickCompareTrimLink() {
        carPage.getInfoSection().clickOnButtonCompareTrim();
    }

    @And("^Trim for selected '(.*)'$")
    public void isTrimForSelectedCar(String nameCar) {
        AssertsCar.assertMakeModelYear(trimCard.getTextTitleLabel(), CarStore.getCarFromStorage(nameCar));
    }

    @And("^Save other parameters for '(.*)' into json$")
    public void saveOtherParametersSelectedCar(String nameCar) {
        Car car = CarStore.getCarFromStorage(nameCar);
        Trim trim = new Trim();
        trim.setNameTrim(trimCard.getNameTrim());
        trim.setEngine(trimCard.getTextPanelEngine());
        trim.setTransmission(trimCard.getTextPanelTrans());
        car.setTrim(trim);
        CarStore.putCarInStorage(nameCar, car);
    }

    @And("^Write parameters for '(.*)' into json$")
    public void writeParametersSelectedCar(String nameCar) {
        CarStore.putCarInStorage(nameCar, car);
    }

    @When("^I click button '(.*)'$")
    public void clickButton(MenuHeaderItem button) {
        compareTrimPage.getTopMenu().clickOnButtonTopMenu(button);
    }
}
