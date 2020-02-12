package test;

import base.BaseTest;
import models.Product;
import models.Seller;
import org.testng.annotations.Test;
import steps.MainMenuScreenSteps;
import steps.ProductScreenSteps;
import steps.SelectCityScreenSteps;
import steps.SellerScreenSteps;

import static enums.CityItem.ABUDHABI;

public class TestSecretCloset extends BaseTest {

    @Test()
    public void testSecretCloset() {
        MainMenuScreenSteps.clickBtnSelectCity();
        SelectCityScreenSteps.clickBtnOkOnAlertLabel();
        String firstAvailableCity = SelectCityScreenSteps.getNameFirstAvailableCity();
        SelectCityScreenSteps.selectCityByName(ABUDHABI);
        MainMenuScreenSteps.checkSelectCity(firstAvailableCity);
        Product firstProductWithDiscount = MainMenuScreenSteps.getFirstProductWithDiscount();
        MainMenuScreenSteps.clickFirstProductWithDiscount();
        ProductScreenSteps.checkProductPricesAndDiscount(firstProductWithDiscount);
        Seller sellerFromProductScreen = ProductScreenSteps.getSellerFromProductScreen();
        ProductScreenSteps.clickNameSeller();
        SellerScreenSteps.checkSeller(sellerFromProductScreen);
    }
}