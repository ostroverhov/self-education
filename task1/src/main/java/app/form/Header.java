package app.form;

import app.pages.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class Header extends BasePage {
    private static By buttonSignInLocator = By.xpath("//button[contains(@class, 'btn btn-primary size-lg js-signin-button')]");

    private Button buttonSignIn = new Button(buttonSignInLocator, getFullElementName("button Sign In"));

    public Header() {
        super("Header", buttonSignInLocator);
    }

    public void clickOnButtonSignIn() {
        buttonSignIn.clickElement();
    }

    public boolean isDisplayedButtonSignIn() {
        return buttonSignIn.isDisplayedElement();
    }
}
