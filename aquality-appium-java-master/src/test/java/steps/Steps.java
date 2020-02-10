package steps;

import models.ModelProduct;
import models.ModelSeller;
import org.testng.Assert;
import screens.MainMenuScreen;
import screens.ProductScreen;
import screens.SelectCityScreen;
import screens.SellerScreen;

public class Steps {

    public static void clickBtnSelectCity(MainMenuScreen mainMenuScreen) {
        mainMenuScreen.clickSelectCity();
    }

    public static void clickBtnOkOnAlertLabel(SelectCityScreen selectCityScreen) {
        selectCityScreen.clickOkOnAlertLabel();
    }

    public static String getNameFirstAvailableCity(SelectCityScreen selectCityScreen) {
        return selectCityScreen.getNameFirstAvailableCity();
    }

    public static void selectFirstAvailableCity(SelectCityScreen selectCityScreen) {
        selectCityScreen.selectFirstAvailableCity();
    }

    public static void checkSelectCity(MainMenuScreen mainMenuScreen, String nameSelectCity) {
        Assert.assertEquals(mainMenuScreen.getNameSelectCity(nameSelectCity), nameSelectCity, "Check select city");
    }

    public static ModelProduct getFirstProductWithDiscount(MainMenuScreen mainMenuScreen) {
        return mainMenuScreen.getFirstProductWithDiscount();
    }

    public static void clickFirstProductWithDiscount(MainMenuScreen mainMenuScreen){
        mainMenuScreen.clickFirstProductWithDiscount();
    }

    public static void checkProductPricesAndDiscount(ProductScreen productScreen, ModelProduct firstProductWithDiscount){
        Assert.assertEquals(productScreen.getProduct(), firstProductWithDiscount);
    }

    public static ModelSeller getSellerFromProductScreen(ProductScreen productScreen){
        return productScreen.getSeller();
    }

    public static void clickNameSeller(ProductScreen productScreen){
        productScreen.clickBtnNameSeller();
    }

    public static void checkSeller(SellerScreen sellerScreen, ModelSeller sellerFromProductScreen){
        Assert.assertEquals(sellerScreen.getSeller(), sellerFromProductScreen);
    }
}