package project.forms.menus;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PanelInfoOfTest extends Form {

    public PanelInfoOfTest() {
        super(By.xpath("//div[contains(@class,'panel-default')]//div[@class='list-group']"), "Add project form");
    }

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

    private final ILabel testName = getElementFactory().getLabel(By.xpath("//h4[contains(text(),'Test name')]/following-sibling::p"), "Test name");
    private final ILabel methodName = getElementFactory().getLabel(By.xpath("//h4[contains(text(),'Test method name')]/following-sibling::p"), "Method name");
    private final ILabel status = getElementFactory().getLabel(By.xpath("//h4[contains(text(),'Status')]/following-sibling::p"), "Status");
    private final ILabel startTime = getElementFactory().getLabel(By.xpath("//p[contains(text(),'Start time')]"), "Start time");
    private final ILabel endTime = getElementFactory().getLabel(By.xpath("//p[contains(text(),'End time')]"), "End time");
    private final ILabel environment = getElementFactory().getLabel(By.xpath("//h4[contains(text(),'Environment')]/following-sibling::p"), "Environment");
    private final ILabel browser = getElementFactory().getLabel(By.xpath("//h4[contains(text(),'Browser')]/following-sibling::p"), "Browser");
}
