package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomeWindow extends Form {

    private static By btnCloseLocator = By.xpath("//a[@class='popin-close-title']");

    public WelcomeWindow() {
        super(btnCloseLocator, "Welcome window");
    }

    private final IButton btnClose = getElementFactory().getButton(btnCloseLocator, "Close welcome window");

    public void clickCloseWindow() {
        btnClose.click();
    }
}