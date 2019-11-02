package project.forms.menus;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PanelInfoOfTest extends Form {

    public PanelInfoOfTest() {
        super(By.xpath("//div[contains(@class,'panel-default')]//div[@class='list-group']"), "Add project form");
    }

    private static final String labelsTestLocator = "//h4[contains(text(),'%s')]/following-sibling::p";
    private static final String labelTimeLocator = "//p[contains(text(),'%s')]";
    private final ILabel testName = getElementFactory().getLabel(By.xpath(String.format(labelsTestLocator, "Test name")), "Test name");
    private final ILabel methodName = getElementFactory().getLabel(By.xpath(String.format(labelsTestLocator, "Test method name")), "Method name");
    private final ILabel status = getElementFactory().getLabel(By.xpath(String.format(labelsTestLocator, "Status")), "Status");
    private final ILabel startTime = getElementFactory().getLabel(By.xpath(String.format(labelTimeLocator, "Start time")), "Start time");
    private final ILabel endTime = getElementFactory().getLabel(By.xpath(String.format(labelTimeLocator, "End time")), "End time");
    private final ILabel environment = getElementFactory().getLabel(By.xpath(String.format(labelsTestLocator, "Environment")), "Environment");
    private final ILabel browser = getElementFactory().getLabel(By.xpath(String.format(labelsTestLocator, "Browser")), "Browser");

    public String getNameTest() {
        return testName.getText();
    }

    public String getMethodTest() {
        return methodName.getText();
    }

    public String getStatusTest() {
        return status.getText();
    }

    public String getStartTimeTest() {
        return startTime.getText();
    }

    public String getEndTimeTest() {
        return endTime.getText();
    }

    public String getEnvironmentTest() {
        return environment.getText();
    }

    public String getBrowser() {
        return browser.getText();
    }
}
