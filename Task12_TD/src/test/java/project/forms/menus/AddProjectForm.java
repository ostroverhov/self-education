package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AddProjectForm extends Form {

    public AddProjectForm() {
        super(By.id("title"), "Add project form");
    }

    public void inputNameProject(String nameProject) {
        textBox.typeSecret(nameProject);
    }

    public void clickBtnSaveProject() {
        btnSaveProject.click();
    }

    public boolean isPresentLabelSuccessfulAddProject() {
        return labelSuccessfulAddProject.getElement().isDisplayed();
    }

    public boolean isClosePopUp() {
        return !btnSaveProject.state().isDisplayed();
    }

    private final IButton btnSaveProject = getElementFactory().getButton(By.xpath("//button[contains(@class,'btn btn-primary')]"), "Button save project");

    private final ITextBox textBox = getElementFactory().getTextBox(By.xpath("//input[@id='projectName']"), "text books");

    private final ILabel labelSuccessfulAddProject = getElementFactory().getLabel(By.xpath("//div[contains(@class,'alert-success')]"), "Label successful add project");
}
