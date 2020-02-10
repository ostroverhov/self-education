package screens;

import aquality.appium.elements.interfaces.ILabel;
import aquality.appium.screens.AndroidScreen;
import models.ModelSeller;
import org.openqa.selenium.By;

public class SellerScreen extends AndroidScreen {

    private final ILabel nameSeller = getElementFactory().getLabel(By.className("android.widget.TextView"), "Button seller");
    private final ILabel citySeller = getElementFactory().getLabel(By.id("tvItemSellerCity"), "Price product");

    public SellerScreen() {
        super(By.id("drawer_layout"), "Product screen");
    }

    public void clickBtnSeller() {
        nameSeller.click();
    }

    public ModelSeller getSeller() {
        ModelSeller modelSeller = new ModelSeller();
        modelSeller.setName(nameSeller.getText());
        modelSeller.setCity(citySeller.getText());
        return modelSeller;
    }
}
