package project.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.utils.RegExpUtils;
import org.testng.Assert;
import project.forms.CarPage;
import project.forms.MainPage;
import project.forms.SearchResultPage;
import project.forms.menus.FilterForm;
import project.forms.menus.MainResearchForm;
import project.models.Car;
import project.utils.CarStore;

public class FindUsedCarsSteps {

    private static CarPage carPage = new CarPage();
    private static MainPage mainPage = new MainPage();
    private static SearchResultPage searchResultPage = new SearchResultPage();
    private static FilterForm filterForm = searchResultPage.getFilterForm();
    private static MainResearchForm mainResearchForm = mainPage.getMainResearchForm();
    private static int priceNewCar;
    private static String patternPriceNewCar = " (\\$)(\\d+).(\\d+)";
    private static String patternPriceUsedCar = "(\\$)(\\d+).(\\d+)";

    @And("^Price are save$")
    public void savePriceCar() {
        priceNewCar = RegExpUtils.getPriceFromString(patternPriceNewCar, carPage.getInfoSection().getTextPanelPrice());
    }

    @When("^I search '(.*)' in '(.*)' with '(.*)' radius '(.*)' zip code '(.*)'$")
    public void searchUsedCar(String nameCar, String stockType, String maxPrice, String radius, String zip) {
        mainResearchForm.selectCar(stockType, CarStore.getCarFromStorage(nameCar), maxPrice, radius, zip);
        mainResearchForm.clickButtonSearch();
    }

    @Then("^Found at least one result$")
    public void isFoundResult() {
        Assert.assertTrue(searchResultPage.isDisplayedLabelSearchCar(), "Result not found");
    }

    @When("^Add trim and year from '(.*)'$")
    public void searchUsedCar(String nameCar) {
        Car car = CarStore.getCarFromStorage(nameCar);
        filterForm.selectYear(car.getYear());
        filterForm.clickCheckBoxTrim(car.getTrim().getNameTrim());
    }

    @And("^Price used car lower then price new car$")
    public void comparePriceNewAndUsedCar() {
        Assert.assertTrue(priceNewCar > RegExpUtils.getPriceFromString(patternPriceUsedCar, searchResultPage.getPriceCar()), "used car cheaper");
    }
}
