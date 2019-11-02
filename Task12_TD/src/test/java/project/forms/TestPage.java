package project.forms;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.PanelInfoOfTest;

public class TestPage extends Form {

    public TestPage() {
        super(By.xpath("//div[contains(@class,'panel-default')]"), "Test page");
    }

    private PanelInfoOfTest panelInfoOfTest = new PanelInfoOfTest();
    private final ILabel logLabel = getElementFactory().getLabel(By.xpath("//div[contains(text(),'Logs')]/following-sibling::table//tbody//tr//td"), "Log panel");
    private final ILabel attachmentLabel = getElementFactory().getLabel(By.xpath("//div[contains(text(),'Attachments')]/following-sibling::table//tbody//tr[2]//td//a"), "Attachment panel");

    public PanelInfoOfTest getPanelInfoOfTest() {
        return panelInfoOfTest;
    }

    public String getLog() {
        return logLabel.getText();
    }

    public String getAttachment() {
        return attachmentLabel.getAttribute("href");
    }
}
