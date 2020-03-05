package screens

import framework.elements.Label
import framework.screens.BaseScreen
import models.Seller
import org.openqa.selenium.By

class SellerScreen : BaseScreen(By.id("lvSellerItems"), "Product screen") {

    private val lblCitySeller: Label =
        Label(By.id("tvItemSellerCity"), "Label price product")

    private fun getLblNameSeller(nameSeller: String) =
        Label(By.xpath("//android.widget.TextView[contains(@text, '$nameSeller')]"), "Label seller")

    fun getSeller(nameSeller: String): Seller = with(Seller()) {
        name = getLblNameSeller(nameSeller).getText()
        city = lblCitySeller.getText()
        return this
    }
}