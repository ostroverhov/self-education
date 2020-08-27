package framework.form

import framework.browser.Browser
import framework.logger.Logger
import framework.utils.Reader
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

abstract class Form {
    def namePage
    def locator

    Form(def namePage, def locator) {
        this.namePage = namePage
        this.locator = locator
    }

    def isPresent() {
        Logger.info("Is present page " + namePage)
        waitElementToBeClickable(Browser.getInstance().findElement(locator)).isDisplayed()
    }

    def getFullElementName(def nameElement) {
        nameElement + " " + namePage
    }

    static def waitElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Browser.getInstance(), Reader.getParameter("timeout") as int)
        wait.until(ExpectedConditions.elementToBeClickable(element))
    }
}
