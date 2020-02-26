package project.steps;

import cucumber.api.java.en.Then;
import org.testng.Assert;
import project.enums.PagesName;

public class CheckPagesSteps {

    @Then("^Check the page '(.*)' opening$")
    public void isPageOpened(PagesName page) {
        Assert.assertTrue(page.getPage().isFormDisplayed(), page.name() + " is open");
    }
}
