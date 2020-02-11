package test;

import base.BaseTest;
import models.Product;
import models.Seller;
import org.testng.annotations.Test;
import steps.*;

public class TestSecretCloset extends BaseTest {

    @Test()
    public void testSecretCloset() {
        MainMenuScreenSteps.clickBtnSelectCity();
        SelectCityScreenSteps.clickBtnOkOnAlertLabel();
        String firstAvailableCity = SelectCityScreenSteps.getNameFirstAvailableCity();
        SelectCityScreenSteps.selectFirstAvailableCity();
        MainMenuScreenSteps.checkSelectCity(firstAvailableCity);
        Product firstProductWithDiscount = MainMenuScreenSteps.getFirstProductWithDiscount();
        MainMenuScreenSteps.clickFirstProductWithDiscount();
        ProductScreenSteps.checkProductPricesAndDiscount(firstProductWithDiscount);
        Seller sellerFromProductScreen = ProductScreenSteps.getSellerFromProductScreen();
        ProductScreenSteps.clickNameSeller();
        SellerScreenSteps.checkSeller(sellerFromProductScreen);
    }
}