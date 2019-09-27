package app.form;

import framework.baseentity.BasePage;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Panel;
import org.openqa.selenium.By;

public class DownloadPanel extends BasePage {

    private static By inputEmailFieldLocator = By.id("Email");
    private Button buttonSendByEmail = new Button(By.xpath("//span[@class='u-button__text']/ancestor::button"), getFullElementName("buttonSendByEmail"));
    private Input inputEmailField = new Input(inputEmailFieldLocator, getFullElementName("inputEmailField"));
    private Button buttonSend = new Button(By.xpath("//span[@class='u-button__spinner']/ancestor::button"), getFullElementName("buttonSend"));
    private Panel captchaPanel = new Panel(By.cssSelector("div[style*='visible;'] iframe[title*='recaptcha']"), getFullElementName("panelCaptcha"));

    public DownloadPanel() {
        super("DownloadPanel", inputEmailFieldLocator);
    }

    public void clickButtonSendByEmail() {
        buttonSendByEmail.clickElement();
    }

    public String getEmailFromInputField() {
        return inputEmailField.getAttributeElement("value");
    }

    public void clickButtonSend() {
        buttonSend.clickElement();
    }

    public void inputCaptcha() {
        if (captchaPanel.isPresent()) {
            if (captchaPanel.isDisplayedElement()) {
                while (captchaPanel.waitInvsibilityElement()) {
                    break;
                }
            }
        }
    }
}