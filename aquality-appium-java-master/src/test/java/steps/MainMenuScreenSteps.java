package steps;

import aquality.selenium.logger.Logger;
import models.Product;
import org.testng.Assert;
import screens.MainMenuScreen;

public class MainMenuScreenSteps {

    private static final MainMenuScreen mainMenuScreen = new MainMenuScreen();
    private static final Logger logger = Logger.getInstance();

    public static void clickBtnSelectCity() {
        logger.info("Click button select city");
        mainMenuScreen.clickSelectCity();
    }

    public static void checkSelectCity(String nameSelectCity) {
        logger.info("Check selected city");
        Assert.assertEquals(mainMenuScreen.getNameSelectCity(nameSelectCity), nameSelectCity, "Check select city");
    }

    public static Product getFirstProductWithDiscount() {
        logger.info("Get first product with discount");
        return mainMenuScreen.getLblFirstProductWithDiscount();
    }

    public static void clickFirstProductWithDiscount(){
        logger.info("Click first product with discount");
        mainMenuScreen.clickFirstProductWithDiscount();
    }
}