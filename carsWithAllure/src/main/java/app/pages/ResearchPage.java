package app.pages;

import app.form.ResearchForm;
import app.form.ToolsForm;
import org.openqa.selenium.By;

public class ResearchPage extends BasePage {
    private ResearchForm researchForm = new ResearchForm();
    private ToolsForm toolsForm = new ToolsForm();

    public ResearchPage() {
        super("ResearchPage", By.xpath("//div[@class='_1jPxd']"));
    }

    public ResearchForm getResearchForm() {
        return researchForm;
    }

    public ToolsForm getToolsForm() {
        return toolsForm;
    }
}
