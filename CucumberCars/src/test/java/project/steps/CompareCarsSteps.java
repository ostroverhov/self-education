package project.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.testng.Assert;
import project.forms.CompareSideBySideCarsPage;
import project.forms.ModelComparePage;
import project.forms.ResearchPage;
import project.forms.menus.CompareForm;
import project.forms.menus.ComparePanel;
import project.models.Car;
import project.models.Trim;
import project.utils.AssertsCar;
import project.utils.CarStore;

public class CompareCarsSteps {

    private static ResearchPage researchPage = new ResearchPage();
    private static CompareSideBySideCarsPage compareSideBySideCarsPage = new CompareSideBySideCarsPage();
    private static ModelComparePage modelComparePage = new ModelComparePage();
    private static ComparePanel comparePanel = modelComparePage.getComparePanel();
    private static CompareForm compareForm = compareSideBySideCarsPage.getCompareForm();

    @When("^Click button 'Side-by-side Comparisons'$")
    public void clickSideBySideComparison() {
        researchPage.getToolsForm().clickOnButtonToolsForm("Side-by-side Comparisons");
    }

    @When("^I select '(.*)' and click button 'Start compare'")
    public void startCompareCars(String nameCar) {
        Car car = CarStore.getCarFromStorage(nameCar);
        compareForm.selectCar(car.getMake(), car.getModel(), car.getYear());
        compareForm.clickButtonStartCompare();
    }

    @And("^Page with selected '(.*)'$")
    public void isPageWithFirstCar(String nameCar) {
        AssertsCar.assertMakeModelYear(comparePanel.getTextFromPanelFirstCar(), CarStore.getCarFromStorage(nameCar));
    }

    @When("^Click button 'Add another car' and select '(.*)'$")
    public void clickAddAnotherCar(String nameCar) {
        comparePanel.clickOnButtonAddAnotherCar();
        Car car = CarStore.getCarFromStorage(nameCar);
        compareForm.selectCar(car.getMake(), car.getModel(), car.getYear());
        compareForm.clickButtonDone();
    }

    @And("^Page with added '(.*)'$")
    public void isPageWithSecondCar(String nameCar) {
        AssertsCar.assertMakeModelYear(comparePanel.getTextFromPanelSecondCar(), CarStore.getCarFromStorage(nameCar));
    }

    @And("^Check car parameters for '(.*)' and '(.*)'$")
    public void checkCarParameters(String nameFirstCar, String nameSecondCar) {
        Assert.assertEquals(CarStore.getCarFromStorage(nameFirstCar).getTrim(),
                new Trim()
                        .setEngine(comparePanel.getTextFromPanelFirstCarEngine())
                        .setTransmission(comparePanel.getTextFromPanelFirstCarTransmission()),
                "check first car trim");
        Assert.assertEquals(CarStore.getCarFromStorage(nameSecondCar).getTrim(),
                new Trim()
                        .setEngine(comparePanel.getTextFromPanelSecondCarEngine())
                        .setTransmission(comparePanel.getTextFromPanelSecondCarTransmission()),
                "check second car trim");
    }

    @When("^Click first car panel$")
    public void clickFirstCarPanel() {
        comparePanel.clickPanelFirstCar();
    }
}
