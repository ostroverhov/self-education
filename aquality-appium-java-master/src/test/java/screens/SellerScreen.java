package screens;

import aquality.appium.elements.interfaces.ILabel;
import aquality.appium.screens.AndroidScreen;
import models.Seller;
import org.openqa.selenium.By;

public class SellerScreen extends AndroidScreen {

    private final ILabel lblNameSeller = getElementFactory().getLabel(By.className("android.widget.TextView"), "Label seller");
    private final ILabel lblCitySeller = getElementFactory().getLabel(By.id("tvItemSellerCity"), "Label price product");

    private ILabel getLblNameSeller(String nameSeller) {
//        return getElementFactory().getLabel(By.id("com.zdv.secretcloset:id/toolbar"), "Label seller");
//        return getElementFactory().getLabel(By.xpath(String.format("//*[contains(text(), '%s')]", nameSeller)), "Label seller");
        return getElementFactory().getLabel(By.className(nameSeller), "Label seller");
    }

    public SellerScreen() {
        super(By.id("lvSellerItems"), "Product screen");
    }

    public Seller getSeller(String nameSeller) {
        Seller seller = new Seller();
        seller.setName(lblNameSeller.getText());
        System.out.println(lblNameSeller.getText());
        seller.setCity(lblCitySeller.getText());
        return seller;
    }
}
