package framework.screens

import aquality.selenium.logger.Logger
import framework.elements.Label
import org.openqa.selenium.By

abstract class BaseScreen(var loc: By, var nameOf: String?) {

    val logger: Logger = Logger.getInstance()

    fun isPresent(): Boolean {
        logger.info("Is displayed screen $nameOf")
        return getFormLabel().isDisplayed()
    }

    private fun getFormLabel(): Label {
        return Label(loc, nameOf)
    }
}