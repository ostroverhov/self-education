package framework.baseentity;

import framework.browser.BrowserFactory;
import framework.utils.MyLogger;
import framework.utils.Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    public void waitElementToBeClickable() {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getInstance(), Integer.parseInt(Reader.getParametr("timeout")));
        wait.until(ExpectedConditions.elementToBeClickable(getElement()));
    }

    private void waitVisibilityElement() {
        Wait<WebDriver> wait = new FluentWait<>(BrowserFactory.getInstance()).withTimeout(Duration.ofSeconds(Integer.parseInt(Reader.getParametr("timeout")))).ignoring(org.openqa.selenium.NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(getElement()));
    }

    public boolean waitInvsibilityElement() {
        MyLogger.info("element is invisible " + nameElement);
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getInstance(), Integer.parseInt(Reader.getParametr("captchaTimeout")));
        return wait.until(ExpectedConditions.invisibilityOf(getElement()));
    }

    public boolean isDisplayedElement() {
        MyLogger.info("element is displayed " + nameElement);
        waitVisibilityElement();
        return getElement().isDisplayed();
    }

    public boolean isPresent() {
        MyLogger.info("element is present " + nameElement);
        return getElements().size() > 0;
    }

    public void clickElement() {
        MyLogger.info("click on element " + nameElement);
        waitElementToBeClickable();
        getElement().click();
    }

    public String getTextFromElement() {
        MyLogger.info("get text from element " + nameElement);
        return getElement().getText();
    }

    public String getAttributeElement(String attribute) {
        MyLogger.info("get attribute " + attribute + " from element");
        return getElement().getAttribute(attribute);
    }
}
