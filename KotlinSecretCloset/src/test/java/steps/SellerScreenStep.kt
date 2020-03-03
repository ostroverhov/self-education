package steps

import aquality.selenium.logger.Logger
import models.Seller
import org.testng.Assert
import screens.SellerScreen

private val sellerScreen: SellerScreen = SellerScreen()
private val logger = Logger.getInstance()

fun checkSeller(sellerFromProductScreen: Seller) {
    logger.info("Check seller")
    Assert.assertEquals(sellerFromProductScreen.name?.let { sellerScreen.getSeller(it) }, sellerFromProductScreen)
}
