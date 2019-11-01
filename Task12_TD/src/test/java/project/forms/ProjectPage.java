package project.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.TableTests;

public class ProjectPage extends Form {

    public ProjectPage() {
        super(By.xpath("//table[@class='table']"), "Project page");
    }

    public TableTests getTableTests() {
        return tableTests;
    }


    private TableTests tableTests = new TableTests();
}