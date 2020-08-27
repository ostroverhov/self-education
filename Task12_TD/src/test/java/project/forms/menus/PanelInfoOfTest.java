package project.forms.menus;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import framework.utils.RegExpUtils;
import org.openqa.selenium.By;

public class PanelInfoOfTest extends Form {

    public PanelInfoOfTest() {
        super(By.xpath("//div[contains(@class,'panel-default')]//div[@class='list-group']"), "Add project form");
    }

    private static final String labelsTestLocatorPattern = "//h4[contains(text(),'%s')]/following-sibling::p";
    private static final String labelTimeLocatorPattern = "//p[contains(text(),'%s')]";
    private static final String patternStartTime = "Start time: (.+)\\.";
    private static final String patternEndTime = "End time: (.+)\\.";
    private final ILabel testName = getElementFactory().getLabel(By.xpath(String.format(labelsTestLocatorPattern, "Test name")), "Test name");
    private final ILabel methodName = getElementFactory().getLabel(By.xpath(String.format(labelsTestLocatorPattern, "Test method name")), "Method name");
    private final ILabel status = getElementFactory().getLabel(By.xpath(String.format(labelsTestLocatorPattern, "Status")), "Status");
    private final ILabel startTime = getElementFactory().getLabel(By.xpath(String.format(labelTimeLocatorPattern, "Start time")), "Start time");
    private final ILabel endTime = getElementFactory().getLabel(By.xpath(String.format(labelTimeLocatorPattern, "End time")), "End time");
    private final ILabel environment = getElementFactory().getLabel(By.xpath(String.format(labelsTestLocatorPattern, "Environment")), "Environment");
    private final ILabel browser = getElementFactory().getLabel(By.xpath(String.format(labelsTestLocatorPattern, "Browser")), "Browser");

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
        return RegExpUtils.getPartFromString(patternStartTime, startTime.getText());
    }

    public String getEndTimeTest() {
        return RegExpUtils.getPartFromString(patternEndTime, endTime.getText());
    }

    public String getEnvironmentTest() {
        return environment.getText();
    }

    public String getBrowser() {
        return browser.getText();
    }
}
