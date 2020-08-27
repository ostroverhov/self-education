package app.pages;

import app.form.CompareForm;
import org.openqa.selenium.By;

public class CompareSideBySideCarsPage extends BasePage {
    private CompareForm compareForm = new CompareForm();

    public CompareSideBySideCarsPage() {
        super("CompareSideBySideCars Page", By.xpath("//button[@class='done-button']"));
    }

    public CompareForm getCompareForm() {
        return compareForm;
    }
}
