package screens;

import aquality.appium.elements.interfaces.ILabel;
import aquality.appium.screens.AndroidScreen;
import models.ModelProduct;
import models.ModelSeller;
import org.openqa.selenium.By;

public class ProductScreen extends AndroidScreen {

    private final ILabel nameSeller = getElementFactory().getLabel(By.id("tvItemSellerName"), "Button name seller");
    private final ILabel citySeller = getElementFactory().getLabel(By.id("tvItemSellerCity"), "City of seller");
    private final ILabel priceProduct = getElementFactory().getLabel(By.id("tvItemPrice"), "Price product");
    private final ILabel discountProduct = getElementFactory().getLabel(By.id("tvItemDiscount"), "discount product");
    private final ILabel oldPriceProduct = getElementFactory().getLabel(By.id("tvItemOriginalPrice"), "Old price product");
    private final ILabel brandProduct = getElementFactory().getLabel(By.id("tvItemBrand"), "Brand product");

    public ProductScreen() {
        super(By.id("drawer_layout"), "Product screen");
    }

    public void clickBtnNameSeller() {
        nameSeller.click();
    }

    public ModelProduct getProduct() {
        ModelProduct modelProduct = new ModelProduct();
        modelProduct.setPrice(priceProduct.getText());
        modelProduct.setDiscount(discountProduct.getText());
        modelProduct.setOldPrice(oldPriceProduct.getText());
        modelProduct.setBrand(brandProduct.getText());
        return modelProduct;
    }

    public ModelSeller getSeller(){
        ModelSeller modelSeller = new ModelSeller();
        modelSeller.setName(nameSeller.getText());
        modelSeller.setCity(citySeller.getText());
        return modelSeller;
    }
}
