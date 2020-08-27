package app.form;

import app.pages.BasePage;
import framework.elements.Panel;
import org.openqa.selenium.By;

public class TrimCard extends BasePage {
    private Panel panelEngine = new Panel(By.xpath("//div[contains(@class,'cell cell-bg grow-2')]"), getFullElementName("panelEngine"));
    private Panel panelTrans = new Panel(By.xpath("//div[contains(@class,'cell grow-2')]"), getFullElementName("panelTrans"));

    public TrimCard() {
        super("Trim card", By.xpath("//div[contains(@class,'cell cell-bg grow-2')]"));
    }

    public String getTextPanelEngine() {
        return panelEngine.getTextFromElement();
    }

    public String getTextPanelTrans() {
        return panelTrans.getTextFromElement();
    }
}
