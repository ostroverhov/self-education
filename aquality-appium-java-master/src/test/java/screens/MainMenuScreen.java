package screens;

import aquality.appium.elements.interfaces.IButton;
import aquality.appium.elements.interfaces.ILabel;
import aquality.appium.screens.AndroidScreen;
import aquality.appium.waitings.ConditionalWait;
import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainMenuScreen extends AndroidScreen {

    private final IButton btnSelectCity = getElementFactory().getButton(By.id("tvToolbarCity"), "Select city");
    private final ILabel lblFirstProductWithDiscount = (ILabel) getElementFactory().findElements(By.xpath("//*[@resource-id='com.zdv.secretcloset:id/rlBanner']"), ILabel.class).get(0);
    private final ILabel lblPriceFirstProductWithDiscount = lblFirstProductWithDiscount.findChildElement(By.id("tvPrice"), ILabel.class);
    private final ILabel lblDiscountFirstProductWithDiscount = lblFirstProductWithDiscount.findChildElement(By.id("tvDiscount"), ILabel.class);
    private final ILabel lblOldPriceFirstProductWithDiscount = lblFirstProductWithDiscount.findChildElement(By.id("tvSumm"), ILabel.class);
    private final ILabel lblBrandFirstProductWithDiscount = lblFirstProductWithDiscount.findChildElement(By.id("tvBrand"), ILabel.class);

    public MainMenuScreen() {
        super(By.id("rlTop"), "Main menu");
    }

    public void clickSelectCity() {
        btnSelectCity.click();
    }

    public String getNameSelectCity(String availableCity) {
        ConditionalWait.waitFor(ExpectedConditions.attributeContains(btnSelectCity.getElement(), "text", availableCity), "Wait change name city");
        return btnSelectCity.getText();
    }

    public Product getLblFirstProductWithDiscount() {
        Product product = new Product();
        product.setPrice(lblPriceFirstProductWithDiscount.getText());
        product.setDiscount(lblDiscountFirstProductWithDiscount.getText());
        product.setOldPrice(lblOldPriceFirstProductWithDiscount.getText());
        product.setBrand(lblBrandFirstProductWithDiscount.getText());
        return product;
    }

    public void clickFirstProductWithDiscount() {
        lblFirstProductWithDiscount.click();
    }
}
