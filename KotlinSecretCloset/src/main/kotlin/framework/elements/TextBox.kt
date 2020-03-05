package framework.elements

import org.openqa.selenium.By

class TextBox(loc: By, nameOf: String?) : BaseElement(loc, nameOf) {

    fun clearAndType(value: String?) {
        logger.info("Clear and type into textbox")
        getElement()!!.clear()
        getElement()!!.sendKeys(value)
    }
}