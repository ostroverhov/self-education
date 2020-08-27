package project.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.ResearchForm;
import project.forms.menus.ToolsForm;

public class ResearchPage extends Form {

    private ResearchForm researchForm = new ResearchForm();
    private ToolsForm toolsForm = new ToolsForm();

    public ResearchPage() {
        super(By.xpath("//div[@class='_1jPxd']"), "ResearchPage");
    }

    public ResearchForm getResearchForm() {
        return researchForm;
    }

    public ToolsForm getToolsForm() {
        return toolsForm;
    }
}
