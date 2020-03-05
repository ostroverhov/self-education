package framework.pages

import framework.elements.Label
import framework.utils.Logger
import org.openqa.selenium.By

abstract class BasePage(val locator: By, val namePage: String) {

    private var logger: Logger = Logger()

    init {
        logger.info("Create page $namePage")
    }

    fun isPresent(): Boolean {
        logger.info("Is displayed page $namePage")
        return getPageLabel().isDisplayed()
    }

    private fun getPageLabel(): Label {
        return Label(locator, namePage)
    }
}

