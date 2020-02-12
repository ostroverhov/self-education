package screens;

import aquality.appium.elements.interfaces.ILabel;
import aquality.appium.screens.AndroidScreen;
import models.Seller;
import org.openqa.selenium.By;

public class SellerScreen extends AndroidScreen {

    private final ILabel lblCitySeller = getElementFactory().getLabel(By.id("tvItemSellerCity"), "Label price product");

    public SellerScreen() {
        super(By.id("lvSellerItems"), "Product screen");
    }

    private ILabel getLblNameSeller(String nameSeller) {
        return getElementFactory().getLabel(By.xpath(String.format("//android.widget.TextView[contains(@text, '%s')]", nameSeller)), "Label seller");
    }

    public Seller getSeller(String nameSeller) {
        Seller seller = new Seller();
        seller.setName(getLblNameSeller(nameSeller).getText());
        seller.setCity(lblCitySeller.getText());
        return seller;
    }
}
