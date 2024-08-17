package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

        @When("click on the first result")
        public void click_on_the_first_result() {

        }

        @Then("verify product page is displayed")
        public void verify_product_page_is_displayed() {
            
            
        }

        @When("user clicks add to cart button")
        public void user_clicks_add_to_cart_button() {
            
            
        }

        @Then("verify that item is added to cart")
        public void verify_that_item_is_added_to_cart() {
            
            
        }


        @Then("verify home page is displayed")
        public void verifyHomePageIsDisplayed() {
                Assert.assertTrue(homePage.isHomePageDisplayed());
        }

        @Then("verify the searched product is displayed")
        public void verifyTheSearchedProductIsDisplayed() {
                Assert.assertTrue(homePage.isProductDisplayed());
        }
}
