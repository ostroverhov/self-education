package framework.elements

import aquality.selenium.logger.Logger
import framework.application.App
import io.appium.java_client.MobileElement
import org.openqa.selenium.By

abstract class BaseElement(var loc: By, var nameOf: String?) {

    val logger: Logger = Logger.getInstance()

    fun getElement(): MobileElement? {
        logger.info("Get element $nameOf")
        return App.getDriver()?.findElement(loc)
    }

    fun getElements(): MutableList<MobileElement>? {
        logger.info("Get elements $nameOf")
        return App.getDriver()?.findElements(loc)
    }

    fun getChildElement(locChildElement: By, nameChildElement: String?): MobileElement? {
        logger.info("Get child element $nameChildElement from $nameOf")
        return getElement()?.findElement(locChildElement)
    }

    fun click() {
        logger.info("Click element $nameOf")
        getElement()?.click()
    }

    fun isDisplayed(): Boolean {
        logger.info("Is displayed element $nameOf")
        return getElement()!!.isDisplayed
    }

    fun getText(): String {
        logger.info("Get text from element $nameOf")
        return getElement()!!.text
    }
}