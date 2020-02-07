package project.steps;

import cucumber.api.java.en.When;
import framework.configurations.Configuration;
import project.enums.MenuHeaderItem;
import project.forms.MainPage;

import static aquality.selenium.browser.BrowserManager.getBrowser;

public class MainPageSteps {

    private static MainPage mainPage = new MainPage();

    @When("^I click button '(.*)' from main page$")
    public void clickButton(MenuHeaderItem button) {
        mainPage.getTopMenu().clickOnButtonTopMenuMain(button);
    }

    @When("^I open main page$")
    public void openMainPage() {
        getBrowser().goTo(Configuration.getCurrentEnvironment().getStartUrl());
    }
}
