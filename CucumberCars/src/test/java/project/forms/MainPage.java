package project.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.MainResearchForm;
import project.forms.menus.TopMenu;

public class MainPage extends Form {

    private TopMenu topMenu = new TopMenu();
    private MainResearchForm mainResearchForm = new MainResearchForm();

    public MainPage() {
        super(By.xpath("//a[@class='_3WG8F _3xBVO']"), "Main Page");
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }

    public MainResearchForm getMainResearchForm() {
        return mainResearchForm;
    }
}
