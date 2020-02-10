import app.form.CompareForm;
import app.form.ComparePanel;
import app.form.TrimCard;
import app.models.Car;
import app.pages.*;
import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import static app.form.MenuHeaderItem.RESEARCH;


public class TestCars extends BaseTest {
    private static final int iterationForSelectionCar = 3;

    @Test(description = "Test cars.com")
    @Description("Test cars.com")
    @Link("https://www.cars.com/")
    public void testCars() {
        MyLogger.step("Open and check main page");
        MainPage mainPage = new MainPage();
        assertPage(mainPage);

        MyLogger.step("Create first car");
        Car firstCar = addCar();

        MyLogger.step("Go to main page");
        BrowserFactory.setUrl(URL);
        assertPage(mainPage);

        MyLogger.step("Create second car");
        Car secondCar = addCar();

        MyLogger.step("Go to research page");
        CompareTrimPage compareTrimPage = new CompareTrimPage();
        compareTrimPage.getTopMenu().clickOnButtonTopMenu(RESEARCH);
        ResearchPage researchPage = new ResearchPage();
        assertPage(researchPage);

        MyLogger.step("Click side-by-side comparisons");
        researchPage.getToolsForm().clickOnButtonToolsForm("Side-by-side Comparisons");
        CompareSideBySideCarsPage compareSideBySideCarsPage = new CompareSideBySideCarsPage();
        CompareForm compareForm = compareSideBySideCarsPage.getCompareForm();
        assertPage(compareSideBySideCarsPage);

        MyLogger.step("Select first car and go to model compare page");
        compareForm.selectCar(firstCar.getMake(), firstCar.getModel(), firstCar.getYear());
        compareForm.clickButtonStartCompare();
        ModelComparePage modelComparePage = new ModelComparePage();
        ComparePanel comparePanel = modelComparePage.getComparePanel();
        assertPage(modelComparePage);

        assertMakeModelYear(comparePanel.getTextFromPanelFirstCar(), firstCar);

        MyLogger.step("Add second car to model compare page");
        comparePanel.clickOnButtonAddAnotherCar();
        CompareForm compareFormFromModelComparePage = modelComparePage.getCompareForm();
        compareFormFromModelComparePage.selectCar(secondCar.getMake(), secondCar.getModel(), secondCar.getYear());
        compareFormFromModelComparePage.clickButtonDone();

        assertMakeModelYear(comparePanel.getTextFromPanelSecondCar(), secondCar);

        MyLogger.step("Compare engine and transmission of cars");
        assertCarParameters(comparePanel.getTextFromPanelFirstCarEngine(), firstCar.getEngine(), "engine first car");
        assertCarParameters(comparePanel.getTextFromPanelSecondCarEngine(), secondCar.getEngine(), "engine second car");
        assertCarParameters(comparePanel.getTextFromPanelFirstCarTransmission(), firstCar.getTransmission(), "trans first car");
        assertCarParameters(comparePanel.getTextFromPanelSecondCarTransmission(), secondCar.getTransmission(), "trans second car");
    }

    @Step("Add car for search")
    private Car addCar() {
        MainPage mainPage = new MainPage();
        MyLogger.step("Go to research page");
        mainPage.getTopMenu().clickOnButtonTopMenuMain(RESEARCH);
        ResearchPage researchPage = new ResearchPage();
        assertPage(researchPage);

        MyLogger.step("Select random parameter and create car. Go to car's page");
        Car car = researchPage.getResearchForm().selectRandomCar();
        researchPage.getResearchForm().clickButtonResearch();
        CarPage carPage = new CarPage();
        for (int i = 0; i < iterationForSelectionCar; i++) {
            if (!carPage.getInfoSection().buttonIsPresent()) {
                carPage.getTopMenu().clickOnButtonTopMenu(RESEARCH);
                car = researchPage.getResearchForm().selectRandomCar();
                researchPage.getResearchForm().clickButtonResearch();
            }
            if (carPage.getInfoSection().buttonIsPresent()) {
                break;
            }
        }
        assertMakeModelYear(carPage.getInfoSection().getTextPanelInfoCar(), car);

        MyLogger.step("Go to page compare trim");
        carPage.getInfoSection().clickOnButtonCompareTrim();
        CompareTrimPage compareTrimPage = new CompareTrimPage();
        TrimCard trimCard = compareTrimPage.getTrimCard();
        assertPage(compareTrimPage);
        car.setEngine(trimCard.getTextPanelEngine());
        car.setTransmission(trimCard.getTextPanelTrans());
        return car;
    }

    @Step("Check car parameters")
    private void assertCarParameters(String carParameterFromPage, String carParameter, String nameCarParameter) {
        Assert.assertTrue(carParameterFromPage.contains(carParameter), nameCarParameter + " not match");
    }

    @Step("Check page {page.namePage}")
    private void assertPage(BasePage page) {
        Assert.assertTrue(page.isPage(), page.getNamePage() + " not found");
    }

    @Step("Check make, model, year of car")
    private void assertMakeModelYear(String textPanel, Car car) {
        assertCarParameters(textPanel, car.getMake(), "make");
        assertCarParameters(textPanel, car.getModel(), "model");
        assertCarParameters(textPanel, car.getYear(), "year");
    }
}