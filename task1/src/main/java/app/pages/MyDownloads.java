package app.pages;

import app.form.DownloadPanel;
import app.form.ProductsCarousel;
import app.form.TabPanel;
import org.openqa.selenium.By;

public class MyDownloads extends BasePage {
    private TabPanel tabPanel = new TabPanel();
    private ProductsCarousel productsCarousel = new ProductsCarousel();
    private DownloadPanel downloadPanel = new DownloadPanel();

    public MyDownloads() {
        super("MyDownloads", By.xpath("//div[@class='u-osTile__title']"));
    }

    public TabPanel getTabPanel() {
        return tabPanel;
    }

    public ProductsCarousel getProductsCarousel() {
        return productsCarousel;
    }

    public DownloadPanel getDownloadPanel() {
        return downloadPanel;
    }
}
