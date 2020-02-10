package screens;

import aquality.appium.elements.interfaces.IButton;
import aquality.appium.elements.interfaces.ILabel;
import aquality.appium.screens.AndroidScreen;
import aquality.appium.waitings.ConditionalWait;
import models.ModelProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainMenuScreen extends AndroidScreen {

    private final IButton btnSelectCity = getElementFactory().getButton(By.id("tvToolbarCity"), "Select city");
    private final ILabel firstProductWithDiscount = getElementFactory().getLabel(By.id("rlBanner"), "First item with discount");
    private final ILabel priceFirstProductWithDiscount = firstProductWithDiscount.findChildElement(By.id("tvPrice"), ILabel.class);
    private final ILabel discountFirstProductWithDiscount = firstProductWithDiscount.findChildElement(By.id("tvDiscount"), ILabel.class);
    private final ILabel oldPriceFirstProductWithDiscount = firstProductWithDiscount.findChildElement(By.id("tvSumm"), ILabel.class);
    private final ILabel brandFirstProductWithDiscount = firstProductWithDiscount.findChildElement(By.id("tvBrand"), ILabel.class);

    public MainMenuScreen() {
        super(By.xpath("/hierarchy/android.widget.FrameLayout"), "Main menu");
    }

    public void clickSelectCity() {
        btnSelectCity.click();
    }

    public String getNameSelectCity(String availableCity) {
        ConditionalWait.waitFor(ExpectedConditions.attributeContains(btnSelectCity.getElement(), "text", availableCity), "Wait change name city");
        return btnSelectCity.getText();
    }

    public ModelProduct getFirstProductWithDiscount() {
        ModelProduct modelProduct = new ModelProduct();
        modelProduct.setPrice(priceFirstProductWithDiscount.getText());
        modelProduct.setDiscount(discountFirstProductWithDiscount.getText());
        modelProduct.setOldPrice(oldPriceFirstProductWithDiscount.getText());
        modelProduct.setBrand(brandFirstProductWithDiscount.getText());
        return modelProduct;
    }

    public void clickFirstProductWithDiscount() {
        firstProductWithDiscount.click();
    }
}
