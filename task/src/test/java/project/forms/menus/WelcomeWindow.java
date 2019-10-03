package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomeWindow extends Form {

    public WelcomeWindow() {
        super(By.xpath("//a[@class='popin-close-title']"), "Welcome window");
    }

    private final IButton btnClose = getElementFactory().getButton(By.xpath("//a[@class='popin-close-title']"), "Close welcome window");

    public void clickCloseWindow() {
        btnClose.click();
    }

    public boolean isInvisibleBtnClose() {
        return !btnClose.state().isDisplayed();
    }
}