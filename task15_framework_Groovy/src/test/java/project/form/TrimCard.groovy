package project.form

import framework.elements.Panel
import framework.form.Form
import org.openqa.selenium.By

class TrimCard extends Form {
    private Panel panelEngine = new Panel(By.xpath("//div[contains(@class,'cell cell-bg grow-2')]"), getFullElementName("panelEngine"))
    private Panel panelTrans = new Panel(By.xpath("//div[contains(@class,'cell grow-2')]"), getFullElementName("panelTrans"))

    TrimCard() {
        super("Trim card", By.xpath("//div[contains(@class,'cell cell-bg grow-2')]"))
    }

    def getTextPanelEngine() {
        panelEngine.getTextFromElement()
    }

    def getTextPanelTrans() {
        panelTrans.getTextFromElement()
    }
}
