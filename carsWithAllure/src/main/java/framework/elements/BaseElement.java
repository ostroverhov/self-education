package framework.elements;

import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import framework.utils.Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BaseElement {
    private String nameElement;
    private By locator;

    public BaseElement(By locator, String nameElement) {
        MyLogger.info("create element " + nameElement);
        this.nameElement = nameElement;
        this.locator = locator;
    }

    public WebElement getElement() {
        MyLogger.info("get element " + nameElement);
        return BrowserFactory.getInstance().findElement(locator);
    }

    public List<WebElement> getElements() {
        MyLogger.info("get elements " + nameElement);
        return BrowserFactory.getInstance().findElements(locator);
    }

    public static WebElement waitElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getInstance(), Integer.parseInt(Reader.getParametr("timeout")));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isDisplayedElement() {
        MyLogger.info("element is displayed " + nameElement);
        return getElement().isDisplayed();
    }

    public boolean isPresent() {
        MyLogger.info("element is present " + nameElement);
        return getElements().size() > 0;
    }

    public void clickElement() {
        MyLogger.info("click on element " + nameElement);
        getElement().click();
    }

    public String getTextFromElement() {
        MyLogger.info("get text from element " + nameElement);
        return getElement().getText();
    }
}
