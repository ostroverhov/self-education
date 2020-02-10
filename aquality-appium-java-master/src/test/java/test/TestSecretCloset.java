package test;

import base.BaseTest;
import models.ModelProduct;
import models.ModelSeller;
import org.testng.annotations.Test;
import screens.MainMenuScreen;
import screens.ProductScreen;
import screens.SelectCityScreen;
import screens.SellerScreen;
import steps.Steps;

public class TestSecretCloset extends BaseTest {

    @Test()
    public void testSecretCloset() {
        MainMenuScreen mainMenuScreen = new MainMenuScreen();
        Steps.clickBtnSelectCity(mainMenuScreen);
        SelectCityScreen selectCityScreen = new SelectCityScreen();
        Steps.clickBtnOkOnAlertLabel(selectCityScreen);
        String firstAvailableCity = Steps.getNameFirstAvailableCity(selectCityScreen);
        Steps.selectFirstAvailableCity(selectCityScreen);
        Steps.checkSelectCity(mainMenuScreen, firstAvailableCity);
        ModelProduct firstProductWithDiscount = Steps.getFirstProductWithDiscount(mainMenuScreen);
        Steps.clickFirstProductWithDiscount(mainMenuScreen);
        ProductScreen productScreen = new ProductScreen();
        Steps.checkProductPricesAndDiscount(productScreen, firstProductWithDiscount);
        ModelSeller sellerFromProductScreen = Steps.getSellerFromProductScreen(productScreen);
        Steps.clickNameSeller(productScreen);
        SellerScreen sellerScreen = new SellerScreen();
        Steps.checkSeller(sellerScreen, sellerFromProductScreen);
    }
}