package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class InfoSection extends Form {

    private IButton buttonCompareTrim = getElementFactory().getButton(By.xpath("//td[@class='mmy-spec__compare']//a"), "compare trim button");
    private ILabel panelInfoCar = getElementFactory().getLabel(By.xpath("//h1[@class='cui-page-section__title']"), "panel info about car");
    private ILabel panelPrice = getElementFactory().getLabel(By.xpath("//div[@class='header-info__row-price']"), "panel price car");

    public InfoSection() {
        super(By.xpath("//td[@class='mmy-spec__compare']//a"), "InfoSection");
    }

    public void clickOnButtonCompareTrim() {
        buttonCompareTrim.click();
    }

    public String getTextPanelInfoCar() {
        return panelInfoCar.getText();
    }

    public String getTextPanelPrice() {
        return panelPrice.getText();
    }
}
