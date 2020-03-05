package steps

import aquality.selenium.logger.Logger
import models.Product
import models.Seller
import org.testng.Assert
import screens.ProductScreen

private val logger: Logger = Logger.getInstance()
private val productScreen: ProductScreen = ProductScreen()

fun checkProductPricesAndDiscount(firstProductWithDiscount: Product) {
    logger.info("Check product prices and discount")
    Assert.assertEquals(productScreen.getProduct(), firstProductWithDiscount)
}

fun getSellerFromProductScreen(): Seller {
    logger.info("Get seller from product screen")
    return productScreen.getSeller()
}

fun clickNameSeller() {
    logger.info("Click name seller")
    productScreen.clickBtnNameSeller()
}