package steps;

import aquality.selenium.logger.Logger;
import screens.SelectCityScreen;

public class SelectCityScreenSteps {

    private static final SelectCityScreen selectCityScreen = new SelectCityScreen();
    private static final Logger logger = Logger.getInstance();

    public static void clickBtnOkOnAlertLabel() {
        logger.info("Click button 'Ok' on alert label");
        selectCityScreen.clickOkOnAlertLabel();
    }

    public static String getNameFirstAvailableCity() {
        logger.info("Get name first available city");
        return selectCityScreen.getNameFirstAvailableCity();
    }

    public static void selectFirstAvailableCity() {
        logger.info("Select first available city");
        selectCityScreen.selectFirstAvailableCity();
    }
}