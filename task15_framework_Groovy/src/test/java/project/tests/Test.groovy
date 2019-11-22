package project.tests

import framework.base.BaseTest
import framework.browser.Browser
import framework.form.Form
import framework.logger.Logger
import framework.utils.Reader
import org.testng.Assert
import project.form.CompareForm
import project.form.ComparePanel
import project.form.TrimCard
import project.models.Car
import project.pages.*

import static project.enums.MenuHeaderItem.RESEARCH

class Test extends BaseTest {
    private static final def iterationForSelectionCar = 3

    @org.testng.annotations.Test
    protected void runTest() {

        Logger.step("Open and check main page")
        MainPage mainPage = new MainPage()
        assertPage(mainPage)

        Logger.step("Create first car")
        Car firstCar = addCar()

        Logger.step("Go to main page")
        Browser.setUrl(Reader.getParameter("URL"))
        assertPage(mainPage)

        Logger.step("Create second car")
        Car secondCar = addCar()

        Logger.step("Go to research page")
        CompareTrimPage compareTrimPage = new CompareTrimPage()
        compareTrimPage.getTopMenu().clickOnButtonTopMenu(RESEARCH)
        ResearchPage researchPage = new ResearchPage()
        assertPage(researchPage)

        Logger.step("Click side-by-side comparisons")
        researchPage.getToolsForm().clickOnButtonToolsForm("Side-by-side Comparisons")
        CompareSideBySideCarsPage compareSideBySideCarsPage = new CompareSideBySideCarsPage()
        CompareForm compareForm = compareSideBySideCarsPage.getCompareForm()
        assertPage(compareSideBySideCarsPage)

        Logger.step("Select first car and go to model compare page")
        compareForm.selectCar(firstCar.getMake(), firstCar.getModel(), firstCar.getYear())
        compareForm.clickButtonStartCompare()
        ModelComparePage modelComparePage = new ModelComparePage()
        ComparePanel comparePanel = modelComparePage.getComparePanel()
        assertPage(modelComparePage)

        assertMakeModelYear(comparePanel.getTextFromPanelFirstCar(), firstCar)

        Logger.step("Add second car to model compare page")
        comparePanel.clickOnButtonAddAnotherCar()
        CompareForm compareFormFromModelComparePage = modelComparePage.getCompareForm()
        compareFormFromModelComparePage.selectCar(secondCar.getMake(), secondCar.getModel(), secondCar.getYear())
        compareFormFromModelComparePage.clickButtonDone()
        assertMakeModelYear(comparePanel.getTextFromPanelSecondCar(), secondCar)

        Logger.step("Compare engine and transmission of cars")
        assertCarParameters(comparePanel.getTextFromPanelFirstCarEngine(), firstCar.getEngine(), "engine first car")
        assertCarParameters(comparePanel.getTextFromPanelSecondCarEngine(), secondCar.getEngine(), "engine second car")
        assertCarParameters(comparePanel.getTextFromPanelFirstCarTransmission(), firstCar.getTransmission(), "trans first car")
        assertCarParameters(comparePanel.getTextFromPanelSecondCarTransmission(), secondCar.getTransmission(), "trans second car")
    }

    private def addCar() {
        MainPage mainPage = new MainPage()
        Logger.step("Go to research page")
        mainPage.getTopMenu().clickOnButtonTopMenuMain(RESEARCH)
        ResearchPage researchPage = new ResearchPage()
        assertPage(researchPage)

        Logger.step("Select random parameter and create car. Go to car's page")
        Car car = researchPage.getResearchForm().selectRandomCar()
        researchPage.getResearchForm().clickButtonResearch()
        CarPage carPage = new CarPage()
        for (i in iterationForSelectionCar) {
            if (!carPage.getInfoSection().buttonIsPresent()) {
                carPage.getTopMenu().clickOnButtonTopMenu(RESEARCH)
                car = researchPage.getResearchForm().selectRandomCar()
                researchPage.getResearchForm().clickButtonResearch()
            }
            if (carPage.getInfoSection().buttonIsPresent()) {
                break
            }
        }
        assertMakeModelYear(carPage.getInfoSection().getTextPanelInfoCar(), car)

        Logger.step("Go to page compare trim")
        carPage.getInfoSection().clickOnButtonCompareTrim()
        CompareTrimPage compareTrimPage = new CompareTrimPage()
        TrimCard trimCard = compareTrimPage.getTrimCard()
        assertPage(compareTrimPage)
        car.setEngine(trimCard.getTextPanelEngine())
        car.setTransmission(trimCard.getTextPanelTrans())
        car
    }

    private void assertCarParameters(String carParameterFromPage, String carParameter, String nameCarParameter) {
        Assert.assertTrue(carParameterFromPage.contains(carParameter), nameCarParameter + " not match")
    }

    private void assertPage(Form form) {
        Assert.assertTrue(form.isPresent(), form.getNamePage() + " not found")
    }

    private void assertMakeModelYear(String textPanel, Car car) {
        assertCarParameters(textPanel, car.getMake(), "make")
        assertCarParameters(textPanel, car.getModel(), "model")
        assertCarParameters(textPanel, car.getYear(), "year")
    }
}
