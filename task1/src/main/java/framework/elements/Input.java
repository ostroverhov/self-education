package framework.elements;

import org.openqa.selenium.By;

public class Input extends BaseElement {
    public Input(By locator, String nameElement) {
        super(locator, nameElement);
    }

    public void entryField(String text) {
        getElement().sendKeys(text);
    }
}
