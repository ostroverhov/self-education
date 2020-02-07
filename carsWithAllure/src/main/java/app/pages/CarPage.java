package app.pages;

import app.form.InfoSection;
import app.form.TopMenu;
import org.openqa.selenium.By;

public class CarPage extends BasePage {
    private InfoSection infoSection = new InfoSection();
    private TopMenu topMenu = new TopMenu();

    public CarPage() {
        super("Car Page", By.xpath("//td[@class='mmy-spec__compare']//a"));
    }

    public InfoSection getInfoSection() {
        return infoSection;
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
