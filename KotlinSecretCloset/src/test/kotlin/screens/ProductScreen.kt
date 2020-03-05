package screens

import framework.elements.Label
import framework.screens.BaseScreen
import models.Product
import models.Seller
import org.openqa.selenium.By

class ProductScreen : BaseScreen(By.id("rlBasicInfo"), "Product screen") {

    private val lblNameSeller: Label =
        Label(By.id("tvItemSellerName"), "Label name seller")
    private val lblCitySeller: Label =
        Label(By.id("tvItemSellerCity"), "Label city of seller")
    private val lblPriceProduct: Label =
        Label(By.id("tvItemPrice"), "Label price product")
    private val lblDiscountProduct: Label =
        Label(By.id("tvItemDiscount"), "Label discount product")
    private val lblOldPriceProduct: Label =
        Label(By.id("tvItemOriginalPrice"), "Label old price product")
    private val lblBrandProduct: Label =
        Label(By.id("tvItemBrand"), "Label brand product")

    fun clickBtnNameSeller() = lblNameSeller.click()

    fun getProduct(): Product = with(Product()) {
        price = lblPriceProduct.getText()
        discount = lblDiscountProduct.getText()
        oldPrice = lblOldPriceProduct.getText()
        brand = lblBrandProduct.getText()
        return this
    }

    fun getSeller(): Seller = with(Seller()) {
        name = lblNameSeller.getText()
        city = lblCitySeller.getText()
        return this
    }
}