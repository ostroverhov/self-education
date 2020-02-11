package screens;

import aquality.appium.elements.interfaces.ILabel;
import aquality.appium.screens.AndroidScreen;
import models.Product;
import models.Seller;
import org.openqa.selenium.By;

public class ProductScreen extends AndroidScreen {

    private final ILabel lblNameSeller = getElementFactory().getLabel(By.id("tvItemSellerName"), "Label name seller");
    private final ILabel lblCitySeller = getElementFactory().getLabel(By.id("tvItemSellerCity"), "Label city of seller");
    private final ILabel lblPriceProduct = getElementFactory().getLabel(By.id("tvItemPrice"), "Label price product");
    private final ILabel lblDiscountProduct = getElementFactory().getLabel(By.id("tvItemDiscount"), "Label discount product");
    private final ILabel lblOldPriceProduct = getElementFactory().getLabel(By.id("tvItemOriginalPrice"), "Label old price product");
    private final ILabel lblBrandProduct = getElementFactory().getLabel(By.id("tvItemBrand"), "Label brand product");

    public ProductScreen() {
        super(By.id("rlBasicInfo"), "Product screen");
    }

    public void clickBtnNameSeller() {
        lblNameSeller.click();
    }

    public Product getProduct() {
        Product product = new Product();
        product.setPrice(lblPriceProduct.getText());
        product.setDiscount(lblDiscountProduct.getText());
        product.setOldPrice(lblOldPriceProduct.getText());
        product.setBrand(lblBrandProduct.getText());
        return product;
    }

    public Seller getSeller(){
        Seller seller = new Seller();
        seller.setName(lblNameSeller.getText());
        seller.setCity(lblCitySeller.getText());
        return seller;
    }
}
