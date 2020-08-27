package screens

import framework.elements.Button
import framework.elements.Label
import framework.screens.BaseScreen
import framework.waitings.waitFor
import models.Product
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

class MainScreen : BaseScreen(By.id("com.zdv.secretcloset:id/rlTop"), "Main menu") {

    private val btnSelectCity = Button(By.id("tvToolbarCity"), "Select city")
    private val lblFirstProductWithDiscount = Label(
        By.xpath("//*[@resource-id='com.zdv.secretcloset:id/rlBanner']"),
        "First product with discount"
    )
    private val lblPriceFirstProductWithDiscount = lblFirstProductWithDiscount.getChildElement(
        By.id("tvPrice"),
        "Price first product with discount"
    )
    private val lblDiscountFirstProductWithDiscount = lblFirstProductWithDiscount.getChildElement(
        By.id("tvDiscount"),
        "Discount first Product with discount"
    )
    private val lblOldPriceFirstProductWithDiscount =
        lblFirstProductWithDiscount.getChildElement(
            By.id("tvSumm"),
            "First product with discount"
        )
    private val lblBrandFirstProductWithDiscount =
        lblFirstProductWithDiscount.getChildElement(
            By.id("tvBrand"),
            "First product with discount"
        )

    fun clickSelectCity() = btnSelectCity.click()

    fun getNameSelectCity(availableCity: String?): String? {
        waitFor(
            ExpectedConditions.attributeContains(btnSelectCity.getElement(), "text", availableCity),
            "Wait change name city"
        )
        return btnSelectCity.getText()
    }

    fun getLblFirstProductWithDiscount(): Product = with(Product()) {
        price = lblPriceFirstProductWithDiscount!!.text
        discount = lblDiscountFirstProductWithDiscount!!.text
        oldPrice = lblOldPriceFirstProductWithDiscount!!.text
        brand = lblBrandFirstProductWithDiscount!!.text
        return this
    }

    fun clickFirstProductWithDiscount() = lblFirstProductWithDiscount.click()
}

