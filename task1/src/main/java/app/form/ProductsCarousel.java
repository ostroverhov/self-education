package app.form;

import framework.baseentity.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class ProductsCarousel extends BasePage {

    private static String carouselLocator = "//div[@class='u-productLogotype__name']";

    public ProductsCarousel() {
        super("ProductCarousel", By.xpath(carouselLocator));
    }

    private Button getCarouselButtonDownload(String namePanel) {

        return new Button(By.xpath(String.format("%s[contains(text(),'%s')]/ancestor::download-application//button[contains(@class, 'jsDownloadApplications')]", carouselLocator, namePanel)), getFullElementName(namePanel + " panel"));
    }

    public void clickButtonDownloadCarousel(String namePanel) {
        getCarouselButtonDownload(namePanel).clickElement();
    }
}
