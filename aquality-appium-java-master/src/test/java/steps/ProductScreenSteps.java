package steps;

import aquality.selenium.logger.Logger;
import models.Product;
import models.Seller;
import org.testng.Assert;
import screens.ProductScreen;

public class ProductScreenSteps {

    private static final ProductScreen productScreen = new ProductScreen();
    private static final Logger logger = Logger.getInstance();

    public static void checkProductPricesAndDiscount(Product firstProductWithDiscount){
        logger.info("Check product prices and discount");
        Assert.assertEquals(productScreen.getProduct(), firstProductWithDiscount);
    }

    public static Seller getSellerFromProductScreen(){
        logger.info("Get seller from product screen");
        return productScreen.getSeller();
    }

    public static void clickNameSeller(){
        logger.info("Click name seller");
        productScreen.clickBtnNameSeller();
    }
}