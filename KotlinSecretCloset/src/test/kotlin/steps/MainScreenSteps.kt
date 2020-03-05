package steps

import aquality.selenium.logger.Logger
import models.Product
import org.testng.Assert
import screens.MainScreen

private val mainScreen = MainScreen()
private val logger: Logger = Logger.getInstance()

fun clickBtnSelectCity() {
    logger.info("Click button select city")
    mainScreen.clickSelectCity()
}

fun checkSelectCity(nameSelectCity: String) {
    logger.info("Check selected city")
    Assert.assertEquals(mainScreen.getNameSelectCity(nameSelectCity), nameSelectCity, "Check select city")
}

fun getFirstProductWithDiscount(): Product {
    logger.info("Get first product with discount")
    return mainScreen.getLblFirstProductWithDiscount()
}

fun clickFirstProductWithDiscount() {
    logger.info("Click first product with discount")
    mainScreen.clickFirstProductWithDiscount()
}