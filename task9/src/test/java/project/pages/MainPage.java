package project.pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {

    public MainPage() {
        super(By.xpath("//h1[contains(text(),'Example Domain')]"), "Main page");
    }
}
