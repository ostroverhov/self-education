package app.pages;

import app.form.DownloadPanel;
import app.form.ProductsCarousel;
import app.form.TabPanel;
import framework.baseentity.BasePage;
import org.openqa.selenium.By;

public class MyDownloadsPage extends BasePage {

    private static By tabPanelLocator = By.xpath("//div[@class='u-osTile__title']");
    private TabPanel tabPanel = new TabPanel(tabPanelLocator);
    private ProductsCarousel productsCarousel = new ProductsCarousel();
    private DownloadPanel downloadPanel = new DownloadPanel();

    public MyDownloadsPage() {
        super("MyDownloads", tabPanelLocator);
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
