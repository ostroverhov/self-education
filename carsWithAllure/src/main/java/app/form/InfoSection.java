package app.form;

import app.pages.BasePage;
import framework.elements.Button;
import framework.elements.Panel;
import org.openqa.selenium.By;

public class InfoSection extends BasePage {
    private Button buttonCompareTrim = new Button(By.xpath("//td[@class='mmy-spec__compare']//a"), getFullElementName("compare trim button"));
    private Panel panelInfoCar = new Panel(By.xpath("//h1[@class='cui-page-section__title']"), getFullElementName("panel info about car"));

    public InfoSection() {
        super("InfoSection", By.xpath("//td[@class='mmy-spec__compare']//a"));
    }

    public void clickOnButtonCompareTrim() {
        buttonCompareTrim.clickElement();
    }

    public String getTextPanelInfoCar() {
        return panelInfoCar.getTextFromElement();
    }

    public boolean buttonIsPresent() {
        return buttonCompareTrim.isPresent();
    }
}
