package project.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MainPage extends Form {

    public MainPage() {
        super(By.id("content"), "Main page");
    }

    private final String textBoxLocator = "//body[@id='tinymce']//p";
    private final ITextBox textBox = getElementFactory().getTextBox(By.xpath(textBoxLocator), "text box");
    private final IButton buttonBoldText = getElementFactory().getButton(By.xpath("//div[@id='mceu_3']//button"), "button bold text");
    private final ITextBox textBoxWithBoldText = getElementFactory().getTextBox(By.xpath(textBoxLocator + "//strong"), "bold text box");

    public void deleteAndInputText(String text) {
        textBox.clearAndType(text);
    }

    public String getTextFromTextBox() {
        return textBox.getText();
    }

    public void selectText() {
        textBox.getElement().sendKeys(Keys.chord(Keys.CONTROL, "a"));
    }

    public void clickButtonBoldText() {
        buttonBoldText.click();
    }

    public boolean isStrongTextInBox() {
        return textBoxWithBoldText.state().isDisplayed();
    }
}
