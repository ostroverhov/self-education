package app.pages;

import app.form.Header;
import app.form.SignInForm;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private Header header = new Header();
    private SignInForm signInForm = new SignInForm();

    public MainPage() {
        super("MainPage", By.xpath("//button[contains(@class, 'btn btn-primary size-lg js-signin-button')]"));
    }

    public Header getHeader() {
        return header;
    }

    public SignInForm getSignInForm() {
        return signInForm;
    }
}
