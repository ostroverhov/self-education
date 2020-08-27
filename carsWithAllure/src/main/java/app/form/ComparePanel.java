package app.form;

import app.pages.BasePage;
import framework.elements.Button;
import framework.elements.Panel;
import org.openqa.selenium.By;

public class ComparePanel extends BasePage {
    private String panelCarLocator = "//cars-compare-compare-info[@format='research-car-mmyt']//span[%s]";
    private String panelCarEngineLocator = "//cars-compare-compare-info[@header='Engine']//span[%s]";
    private String panelCarTransmissionLocator = "//cars-compare-compare-info[@header='Transmission']//span[%s]";

    private Button buttonAddAnotherCar = new Button(By.xpath("//div[@id='icon-div']"), getFullElementName("button"));
    private Panel panelFirstCar = new Panel(By.xpath(String.format(panelCarLocator, "1")), getFullElementName("panel first car"));
    private Panel panelSecondCar = new Panel(By.xpath(String.format(panelCarLocator, "2")), getFullElementName("panel second car"));
    private Panel panelFirstCarEngine = new Panel(By.xpath(String.format(panelCarEngineLocator, "1")), getFullElementName("panel first car engine"));
    private Panel panelSecondCarEngine = new Panel(By.xpath(String.format(panelCarEngineLocator, "2")), getFullElementName("panel second car engine"));
    private Panel panelFirstCarTransmission = new Panel(By.xpath(String.format(panelCarTransmissionLocator, "1")), getFullElementName("panel first car trans"));
    private Panel panelSecondCarTransmission = new Panel(By.xpath(String.format(panelCarTransmissionLocator, "2")), getFullElementName("panel second car trans"));

    public ComparePanel() {
        super("Compare panel", By.xpath("//div[@id='icon-div']"));
    }

    public void clickOnButtonAddAnotherCar() {
        buttonAddAnotherCar.clickElement();
    }

    public String getTextFromPanelFirstCar() {
        return panelFirstCar.getTextFromElement();
    }

    public String getTextFromPanelSecondCar() {
        return panelSecondCar.getTextFromElement();
    }

    public String getTextFromPanelFirstCarEngine() {
        return panelFirstCarEngine.getTextFromElement();
    }

    public String getTextFromPanelSecondCarEngine() {
        return panelSecondCarEngine.getTextFromElement();
    }

    public String getTextFromPanelFirstCarTransmission() {
        return panelFirstCarTransmission.getTextFromElement();
    }

    public String getTextFromPanelSecondCarTransmission() {
        return panelSecondCarTransmission.getTextFromElement();
    }
}
