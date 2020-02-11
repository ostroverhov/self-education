package screens;

import aquality.appium.elements.interfaces.IButton;
import aquality.appium.elements.interfaces.ILabel;
import aquality.appium.screens.AndroidScreen;
import org.openqa.selenium.By;

public class SelectCityScreen extends AndroidScreen {

    private final IButton btnOkOnAlert = getElementFactory().getButton(By.id("android:id/button1"), "Button Ok on alert label");
    private final ILabel lblFirstAvailableCity = getElementFactory().getLabel(By.id("tvCityItemName"), "Label first available city");

    public SelectCityScreen() {
        super(By.id("action_bar_root"), "Select city screen");
    }

    public void clickOkOnAlertLabel() {
        btnOkOnAlert.click();
    }

    public void selectFirstAvailableCity(){
        lblFirstAvailableCity.click();
    }

    public String getNameFirstAvailableCity(){
        return lblFirstAvailableCity.getText();
    }
}
