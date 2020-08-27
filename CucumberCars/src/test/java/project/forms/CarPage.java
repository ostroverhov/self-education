package project.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.InfoSection;
import project.forms.menus.TopMenu;

public class CarPage extends Form {

    private InfoSection infoSection = new InfoSection();
    private TopMenu topMenu = new TopMenu();

    public CarPage() {
        super(By.xpath("//td[@class='mmy-spec__compare']//a"), "Car Page");
    }

    public InfoSection getInfoSection() {
        return infoSection;
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
