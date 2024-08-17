package com.automation.steps;

import com.automation.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ProductPageSteps {
    ProductPage productPage=new ProductPage();
    @Then("verify product page is displayed")
    public void verify_product_page_is_displayed() {
        Assert.assertTrue(productPage.isPageDisplayed());

    }

    @When("user clicks add to cart button")
    public void user_clicks_add_to_cart_button() {
productPage.doAddToCart();
    }


}
