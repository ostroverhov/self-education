package project.pages

import framework.form.Form
import org.openqa.selenium.By
import project.form.CompareForm

class CompareSideBySideCarsPage extends Form {
    CompareForm compareForm = new CompareForm()

    CompareSideBySideCarsPage() {
        super("CompareSideBySideCars Page", By.xpath("//button[@class='done-button']"))
    }
}
