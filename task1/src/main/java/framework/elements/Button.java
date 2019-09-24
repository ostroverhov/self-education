package framework.elements;

import framework.baseentity.BaseElement;
import org.openqa.selenium.By;

public class Button extends BaseElement {

    public Button(By locator, String nameElement) {
        super(locator, nameElement);
    }
}
