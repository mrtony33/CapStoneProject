package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeStep {
        HomePage homePage=new HomePage();
        @Given("user opens website")
        public void user_opens_website() {
            homePage.openWebsite();
        }

        @When("user search for {string}")
        public void user_search_for(String item) {
            homePage.searchForItem(item);
        }










        @Then("verify home page is displayed")
        public void verifyHomePageIsDisplayed() {
                Assert.assertTrue(homePage.isHomePageDisplayed());
        }
}
