package app.form;

import framework.baseentity.BasePage;
import framework.elements.Button;
import framework.elements.Input;
import org.openqa.selenium.By;

public class SignInForm extends BasePage {

    private static By buttonSignInLocator = By.xpath("//div[@class='modal-wrap']//button[contains(@class, 'u-button u-button_type_primary ')]");
    private Input inputEmail = new Input(By.name("EMail"), getFullElementName("input field email"));
    private Input inputPassword = new Input(By.name("Password"), getFullElementName("input field password"));
    private Button buttonSignIn = new Button(buttonSignInLocator, getFullElementName("button SignIn"));

    public SignInForm() {
        super("SignInForm", buttonSignInLocator);
    }

    public void login(String email, String password) {
        inputEmail.entryField(email);
        inputPassword.entryField(password);
        buttonSignIn.clickElement();
    }
}
