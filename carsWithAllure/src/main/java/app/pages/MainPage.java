package app.pages;

import app.form.TopMenu;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private TopMenu topMenu = new TopMenu();

    public MainPage() {
        super("Main Page", By.xpath("//a[@class='_3WG8F _3xBVO']"));
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
