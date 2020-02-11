package steps;

import aquality.selenium.logger.Logger;
import models.Seller;
import org.testng.Assert;
import screens.SellerScreen;

public class SellerScreenSteps {

    private static final SellerScreen sellerScreen = new SellerScreen();
    private static final Logger logger = Logger.getInstance();

    public static void checkSeller(Seller sellerFromProductScreen) {
        logger.info("Check seller");
        Assert.assertEquals(sellerScreen.getSeller(sellerFromProductScreen.getName()), sellerFromProductScreen);
    }
}