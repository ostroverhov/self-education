package test

import base.BaseTest
import enums.CityItem
import org.testng.annotations.Test
import steps.*

class TestSecretCloset : BaseTest() {

    @Test
    fun testSecretCloset() {
        clickBtnSelectCity()
        clickBtnOkOnAlertLabel()
        selectCityByName(CityItem.ABUDHABI)
        checkSelectCity(CityItem.ABUDHABI.city!!)
        getFirstProductWithDiscount().let {
            clickFirstProductWithDiscount()
            checkProductPricesAndDiscount(it)
        }
        getSellerFromProductScreen().let {
            clickNameSeller()
            checkSeller(it)
        }
    }
}