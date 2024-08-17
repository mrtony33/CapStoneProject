package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStep {
        HomePage homePage=new HomePage();
        @Given("user opens website")
        public void user_opens_website() {
            homePage.openWebsite();
        }

        @When("user search for {string}")
        public void user_search_for(String string) {
            
            
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


}
