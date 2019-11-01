package project.forms;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.AddProjectForm;
import project.forms.menus.MenuProjects;

public class MainPage extends Form {

    public MainPage() {
        super(By.xpath("//div[contains(@class,'panel-default')]"), "Main page");
    }

    public String getTextFromFooter() {
        return footer.getText();
    }

    public MenuProjects getMenuProjects() {
        return menuProjects;
    }

    public AddProjectForm getAddProjectForm() {
        return addProjectForm;
    }

    private final ILabel footer = getElementFactory().getLabel(By.xpath("//div[@class='container']//p//span"), "Footer");

    private MenuProjects menuProjects = new MenuProjects();

    private AddProjectForm addProjectForm = new AddProjectForm();
}
