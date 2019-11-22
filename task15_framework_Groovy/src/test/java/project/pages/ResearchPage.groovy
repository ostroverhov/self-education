package project.pages

import framework.form.Form
import org.openqa.selenium.By
import project.form.ResearchForm
import project.form.ToolsForm

class ResearchPage extends Form {
    ResearchForm researchForm = new ResearchForm()
    ToolsForm toolsForm = new ToolsForm()

    ResearchPage() {
        super("ResearchPage", By.xpath("//div[@class='_1jPxd']"))
    }
}
