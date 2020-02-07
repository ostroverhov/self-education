package app.pages;

import app.form.CompareForm;
import app.form.ComparePanel;
import org.openqa.selenium.By;

public class ModelComparePage extends BasePage {
    private ComparePanel comparePanel = new ComparePanel();
    private CompareForm compareForm = new CompareForm();

    public ModelComparePage() {
        super("ModelCompare page", By.xpath("//div[@id='icon-div']"));
    }

    public ComparePanel getComparePanel() {
        return comparePanel;
    }

    public CompareForm getCompareForm() {
        return compareForm;
    }
}
