package app.pages;

import app.form.Header;
import app.form.SignInForm;
import framework.baseentity.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private static By signInButtonLocator = By.xpath("//div[@class='signin-invite']//button");
    private Header header = new Header(signInButtonLocator);
    private SignInForm signInForm = new SignInForm();

    public MainPage() {
        super("MainPage", signInButtonLocator);
    }

    public Header getHeader() {
        return header;
    }

    public SignInForm getSignInForm() {
        return signInForm;
    }
}
