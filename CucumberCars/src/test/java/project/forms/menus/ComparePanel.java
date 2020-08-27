package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ComparePanel extends Form {

    private String panelCarLocator = "//cars-compare-compare-info[@format='research-car-mmyt']//span[%s]//h4";
    private String panelCarEngineLocator = "//cars-compare-compare-info[@header='Engine']//span[%s]";
    private String panelCarTransmissionLocator = "//cars-compare-compare-info[@header='Transmission']//span[%s]";

    private IButton buttonAddAnotherCar = getElementFactory().getButton(By.xpath("//div[@id='icon-div']"), "button add another car");
    private ILabel panelFirstCar = getElementFactory().getLabel(By.xpath(String.format(panelCarLocator, "1")), "panel first car");
    private ILabel panelSecondCar = getElementFactory().getLabel(By.xpath(String.format(panelCarLocator, "2")), "panel second car");
    private ILabel panelFirstCarEngine = getElementFactory().getLabel(By.xpath(String.format(panelCarEngineLocator, "1")), "panel first car engine");
    private ILabel panelSecondCarEngine = getElementFactory().getLabel(By.xpath(String.format(panelCarEngineLocator, "2")), "panel second car engine");
    private ILabel panelFirstCarTransmission = getElementFactory().getLabel(By.xpath(String.format(panelCarTransmissionLocator, "1")), "panel first car trans");
    private ILabel panelSecondCarTransmission = getElementFactory().getLabel(By.xpath(String.format(panelCarTransmissionLocator, "2")), "panel second car trans");

    public ComparePanel() {
        super(By.xpath("//div[@id='icon-div']"), "Compare panel");
    }

    public void clickOnButtonAddAnotherCar() {
        buttonAddAnotherCar.click();
    }

    public String getTextFromPanelFirstCar() {
        return panelFirstCar.getText();
    }

    public void clickPanelFirstCar() {
        panelFirstCar.click();
    }

    public String getTextFromPanelSecondCar() {
        return panelSecondCar.getText();
    }

    public String getTextFromPanelFirstCarEngine() {
        return panelFirstCarEngine.getText();
    }

    public String getTextFromPanelSecondCarEngine() {
        return panelSecondCarEngine.getText();
    }

    public String getTextFromPanelFirstCarTransmission() {
        return panelFirstCarTransmission.getText();
    }

    public String getTextFromPanelSecondCarTransmission() {
        return panelSecondCarTransmission.getText();
    }
}
