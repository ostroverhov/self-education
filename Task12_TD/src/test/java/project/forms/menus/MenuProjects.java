package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import framework.utils.RegExpUtils;
import org.openqa.selenium.By;
import project.projectutils.WebsiteUtils;

import java.util.ArrayList;

import static aquality.selenium.elements.ElementType.LABEL;

public class MenuProjects extends Form {

    public MenuProjects() {
        super(By.xpath("//div[@class='panel-heading']"), "Menu projects");
    }

    private static final String patternGetProjectId = "projectId=((\\d)+)";

    private final IButton btnAddProject = getElementFactory().getButton(By.xpath("//div[@class='panel-heading']//button"), "Button add project");

    private IButton getBtnFromMenu(String nameBtn) {
        return getElementFactory().getButton(By.xpath(String.format("//div[@class='list-group']//a[contains(text(), '%s')]", nameBtn)), nameBtn);
    }

    public void clickBtnProject(String nameProject) {
        getBtnFromMenu(nameProject).click();
    }

    public String getIdProject(String nameProject) {
        return RegExpUtils.getPartFromString(patternGetProjectId, getBtnFromMenu(nameProject).getAttribute("href"));
    }

    public void clickBtnAddProject() {
        btnAddProject.click();
    }

    public ArrayList<String> getListNameTests() {
        return WebsiteUtils.getNameTests(getElementFactory().findElements(By.xpath("//div[@class='list-group']//a"), LABEL));
    }
}
