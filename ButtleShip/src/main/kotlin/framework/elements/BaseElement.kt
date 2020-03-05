package framework.elements

import framework.browser.Browser
import framework.utils.Logger
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

abstract class BaseElement(val locator: By, val nameElement: String) {

    private var logger: Logger = Logger()

    init {
        logger.info("Create element $nameElement")
    }

    fun getElement(): WebElement? {
        logger.info("Get element $nameElement")
        return Browser.getDriver()!!.findElement(locator)
    }

    fun getElements(): List<WebElement?>? {
        logger.info("Get elements $nameElement")
        return Browser.getDriver()!!.findElements(locator)
    }

    fun isDisplayed(): Boolean {
        logger.info("Element is displayed $nameElement")
        return getElement()!!.isDisplayed
    }

    fun isEnabled(): Boolean {
        logger.info("Element is displayed $nameElement")
        return getElement()!!.isEnabled
    }

    fun click() {
        logger.info("Click on element $nameElement")
        getElement()!!.click()
    }

    fun getText(): String? {
        logger.info("Get text from element $nameElement")
        return getElement()!!.text
    }

    fun getAttribute(name: String?): String? {
        logger.info("Get attribute from element $nameElement")
        return getElement()!!.getAttribute(name)
    }
}