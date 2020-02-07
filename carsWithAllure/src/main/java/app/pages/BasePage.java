package app.pages;

import framework.browser.BrowserFactory;
import framework.utils.Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private String namePage;
    private By locator;

    public BasePage(String namePage, By locator) {
        this.namePage = namePage;
        this.locator = locator;
    }

    public boolean isPage() {
        return waitElementToBeClickable(BrowserFactory.getInstance().findElement(locator)).isDisplayed();
    }

    public String getNamePage() {
        return namePage;
    }

    public String getFullElementName(String nameElement) {
        return nameElement + " " + namePage;
    }

    public static WebElement waitElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getInstance(), Integer.parseInt(Reader.getParametr("timeout")));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
