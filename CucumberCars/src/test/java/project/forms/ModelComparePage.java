package project.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.CompareForm;
import project.forms.menus.ComparePanel;

public class ModelComparePage extends Form {

    private ComparePanel comparePanel = new ComparePanel();
    private CompareForm compareForm = new CompareForm();

    public ModelComparePage() {
        super(By.xpath("//div[@id='icon-div']"), "ModelCompare page");
    }

    public ComparePanel getComparePanel() {
        return comparePanel;
    }

    public CompareForm getCompareForm() {
        return compareForm;
    }
}
