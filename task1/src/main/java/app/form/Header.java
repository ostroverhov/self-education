package app.form;

import framework.baseentity.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class Header extends BasePage {

    private Button buttonSignIn = new Button(By.xpath("//div[@class='signin-invite']//button"), getFullElementName("button Sign In"));

    public Header(By locator) {
        super("Header", locator);
    }

    public void clickOnButtonSignIn() {
        buttonSignIn.clickElement();
    }
}
