package com.automation.steps;

import com.automation.pages.interfaces.NavigationPage;
import com.automation.pages.webpages.NavigationPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationSteps {
    NavigationPage navigationPage;

    public NavigationSteps() {
        if (ConfigReader.getProperty("automation.type").equals("web")) {
            navigationPage = new NavigationPageWeb();
        }
    }
    @When("user clicks on a {string} link")
    public void userClicksOnALink(String nav) {
        navigationPage.clickOnNavigationLink(nav);
    }

    @Then("verify page is navigated to respective {string} link")
    public void verifyPageIsNavigatedToRespectiveLink(String nav) {
        Assert.assertTrue(navigationPage.isNavigatedPageDisplayed(nav));
    }
}
