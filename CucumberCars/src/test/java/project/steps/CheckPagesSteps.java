package project.steps;

import cucumber.api.java.en.Then;
import org.testng.Assert;
import project.enums.PagesName;

public class CheckPagesSteps {

    @Then("^Open page '(.*)'$")
    public void isPageOpened(PagesName page) {
        Assert.assertTrue(page.getPage().isFormDisplayed(), page.name() + " is open");
    }
}
