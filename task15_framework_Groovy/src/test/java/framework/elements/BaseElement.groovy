package framework.elements

import framework.browser.Browser
import framework.logger.Logger
import framework.utils.Reader
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

abstract class BaseElement {
    def locator
    def nameElement

    BaseElement(def locator, def nameElement) {
        this.locator = locator
        this.nameElement = nameElement
    }

    WebElement getElement() {
        Logger.info("get element " + nameElement)
        Browser.getInstance().findElement(locator)
    }

    List<WebElement> getElements() {
        Logger.info("get elements " + nameElement)
        return Browser.getInstance().findElements(locator)
    }

    boolean isDisplayedElement() {
        Logger.info("element is displayed " + nameElement)
        getElement().isDisplayed()
    }

    static WebElement waitElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Browser.getInstance(), Integer.parseInt(Reader.getParameter("timeout")))
        return wait.until(ExpectedConditions.elementToBeClickable(element))
    }

    boolean isPresent() {
        Logger.info("element is present " + nameElement)
        return getElements().size() > 0
    }

    String getTextFromElement() {
        Logger.info("get text from element " + nameElement)
        return getElement().getText()
    }

    void clickElement() {
        Logger.info("click on element " + nameElement)
        getElement().click()
        Browser.getInstance().manage().any()
    }
}
