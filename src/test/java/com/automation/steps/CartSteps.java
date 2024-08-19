package com.automation.steps;

import com.automation.pages.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {
    CartPage cartPage=new CartPage();

    @Then("verify that item is added to cart")
    public void verify_that_item_is_added_to_cart() {
        Assert.assertTrue(cartPage.verifyAddToCart());
    }

    @When("user removes the item from the cart")
    public void userRemovesTheItemFromTheCart() {
        cartPage.clickRemove();
    }

    @Then("verify that item is removed from the cart")
    public void verifyThatItemIsRemovedFromTheCart() {
        Assert.assertTrue(cartPage.isItemInCartDisplayed());
    }
}
