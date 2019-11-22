package project.form

import framework.elements.Button
import framework.elements.Panel
import framework.form.Form
import org.openqa.selenium.By

class ComparePanel extends Form {
    private def panelCarLocator = "//cars-compare-compare-info[@format='research-car-mmyt']//span[%s]"
    private def panelCarEngineLocator = "//cars-compare-compare-info[@header='Engine']//span[%s]"
    private def panelCarTransmissionLocator = "//cars-compare-compare-info[@header='Transmission']//span[%s]"

    private Button buttonAddAnotherCar = new Button(By.xpath("//div[@id='icon-div']"), getFullElementName("button"))
    private Panel panelFirstCar = new Panel(By.xpath(String.format(panelCarLocator, "1")), getFullElementName("panel first car"))
    private Panel panelSecondCar = new Panel(By.xpath(String.format(panelCarLocator, "2")), getFullElementName("panel second car"))
    private Panel panelFirstCarEngine = new Panel(By.xpath(String.format(panelCarEngineLocator, "1")), getFullElementName("panel first car engine"))
    private Panel panelSecondCarEngine = new Panel(By.xpath(String.format(panelCarEngineLocator, "2")), getFullElementName("panel second car engine"))
    private Panel panelFirstCarTransmission = new Panel(By.xpath(String.format(panelCarTransmissionLocator, "1")), getFullElementName("panel first car trans"))
    private Panel panelSecondCarTransmission = new Panel(By.xpath(String.format(panelCarTransmissionLocator, "2")), getFullElementName("panel second car trans"))

    ComparePanel() {
        super("Compare panel", By.xpath("//div[@id='icon-div']"))
    }

    void clickOnButtonAddAnotherCar() {
        buttonAddAnotherCar.clickElement()
    }

    def getTextFromPanelFirstCar() {
        panelFirstCar.getTextFromElement()
    }

    def getTextFromPanelSecondCar() {
        panelSecondCar.getTextFromElement()
    }

    def getTextFromPanelFirstCarEngine() {
        panelFirstCarEngine.getTextFromElement()
    }

    def getTextFromPanelSecondCarEngine() {
        panelSecondCarEngine.getTextFromElement()
    }

    def getTextFromPanelFirstCarTransmission() {
        panelFirstCarTransmission.getTextFromElement()
    }

    def getTextFromPanelSecondCarTransmission() {
        panelSecondCarTransmission.getTextFromElement()
    }
}
