package app.form;

import app.pages.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class ProductsCarousel extends BasePage {

    public ProductsCarousel() {
        super("ProductCarousel", By.xpath("//div[@class='u-productLogotype__name']"));
    }

    private Button getCarouselButtonDownload(String namePanel) {
        return new Button(By.xpath(String.format("//div[@class='u-productLogotype__name'][contains(text(),'%s')]/ancestor::div[@class='w-downloadProgramCard a-padding-x-sm']//button[1]", namePanel)), getFullElementName(namePanel + " panel"));
    }

    public void clickButtonDownloadCarousel(String namePanel) {
        getCarouselButtonDownload(namePanel).clickElement();
    }
}
