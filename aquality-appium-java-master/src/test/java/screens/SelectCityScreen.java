package screens;

import aquality.appium.elements.interfaces.IButton;
import aquality.appium.elements.interfaces.ILabel;
import aquality.appium.elements.interfaces.ITextBox;
import aquality.appium.screens.AndroidScreen;
import enums.CityItem;
import org.openqa.selenium.By;

public class SelectCityScreen extends AndroidScreen {

    private final IButton btnOkOnAlert = getElementFactory().getButton(By.id("android:id/button1"), "Button Ok on alert label");
    private final ILabel lblFirstAvailableCity = getElementFactory().getLabel(By.id("tvCityItemName"), "Label first available city");
    private final ITextBox textBoxSearchCity = getElementFactory().getTextBox(By.id("etSearchTest"), "Text box for search city");

    public SelectCityScreen() {
        super(By.id("action_bar_root"), "Select city screen");
    }

    public void clickOkOnAlertLabel() {
        btnOkOnAlert.click();
    }

    public void inputNameCity(CityItem cityItem) {
        textBoxSearchCity.clearAndType(cityItem.getCityItem());
        selectFirstAvailableCity();
    }

    public void selectFirstAvailableCity() {
        lblFirstAvailableCity.click();
    }

    public String getNameFirstAvailableCity() {
        return lblFirstAvailableCity.getText();
    }
}
