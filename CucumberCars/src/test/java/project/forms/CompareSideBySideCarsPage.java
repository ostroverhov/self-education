package project.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.CompareForm;

public class CompareSideBySideCarsPage extends Form {

    private CompareForm compareForm = new CompareForm();

    public CompareSideBySideCarsPage() {
        super(By.xpath("//button[@class='done-button']"), "CompareSideBySideCars Page");
    }

    public CompareForm getCompareForm() {
        return compareForm;
    }
}
