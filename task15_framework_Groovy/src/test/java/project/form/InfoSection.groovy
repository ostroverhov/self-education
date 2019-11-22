package project.form

import framework.elements.Button
import framework.elements.Panel
import framework.form.Form
import org.openqa.selenium.By

class InfoSection extends Form {
    private Button buttonCompareTrim = new Button(By.xpath("//td[@class='mmy-spec__compare']//a"), getFullElementName("compare trim button"))
    private Panel panelInfoCar = new Panel(By.xpath("//h1[@class='cui-page-section__title']"), getFullElementName("panel info about car"))

    InfoSection() {
        super("InfoSection", By.xpath("//td[@class='mmy-spec__compare']//a"))
    }

    void clickOnButtonCompareTrim() {
        buttonCompareTrim.clickElement()
    }

    def getTextPanelInfoCar() {
        panelInfoCar.getTextFromElement()
    }

    def buttonIsPresent() {
        buttonCompareTrim.isPresent()
    }
}
