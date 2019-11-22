package project.pages

import framework.form.Form
import org.openqa.selenium.By
import project.form.CompareForm
import project.form.ComparePanel

class ModelComparePage extends Form {
    ComparePanel comparePanel = new ComparePanel()
    CompareForm compareForm = new CompareForm()

    ModelComparePage() {
        super("ModelCompare page", By.xpath("//div[@id='icon-div']"))
    }
}
