 package com.automation.steps;

 import com.automation.pages.interfaces.CartPage;
 import com.automation.pages.webpages.CartPageWeb;
 import com.automation.utils.ConfigReader;
 import io.cucumber.java.en.And;
 import io.cucumber.java.en.Then;
 import io.cucumber.java.en.When;
 import org.junit.Assert;

public class CartSteps {
    CartPage cartPage;

    public CartSteps() {
        if (ConfigReader.getProperty("automation.type").equals("web")){
            cartPage=new CartPageWeb();
        }
    }

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

    @And("verify the price in the cart page")
    public void verifyThePriceInTheCartPage() {
        Assert.assertTrue(cartPage.verifyCartPrice());
    }

    @And("take the price on pdp page")
    public void takeThePriceOnPdpPage() {
        cartPage.getPriceOnProductPage();
    }

    @Then("verify all sizes are added to cart")
    public void verifyAllSizesAreAddedToCart() {
        Assert.assertTrue(cartPage.checkSizesAdded());
    }
}
