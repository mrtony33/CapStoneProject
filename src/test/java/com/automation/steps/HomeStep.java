package com.automation.steps;

import com.automation.pages.androidPages.HomePageAndroid;
import com.automation.pages.interfaces.HomePage;
import com.automation.pages.webpages.HomePageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeStep {
        HomePage homePage;
        public HomeStep() {
                if (ConfigReader.getProperty("automation.type").equals("web")) {
                        homePage = new HomePageWeb();
                } else {
                        homePage = new HomePageAndroid();
                }
        }

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
