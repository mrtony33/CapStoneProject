package com.automation.steps;

import com.automation.pages.androidPages.ProductPageAndroid;
import com.automation.pages.androidPages.SearchResultsPageAndroid;
import com.automation.pages.interfaces.ProductPage;
import com.automation.pages.interfaces.SearchResultPage;
import com.automation.pages.webpages.ProductPageWeb;
import com.automation.pages.webpages.SearchResultsPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class ProductPageSteps {
    SearchResultPage searchResultPage;
    ProductPage productPage;
    ProductPageSteps(){
        if (ConfigReader.getProperty("automation.type").equals("web")){
            searchResultPage=new SearchResultsPageWeb();
            productPage=new ProductPageWeb();
        }else {
            productPage=new ProductPageAndroid();
            searchResultPage=new SearchResultsPageAndroid();
        }
    }
    @Then("verify product page is displayed")
    public void verify_product_page_is_displayed() {
        Assert.assertTrue(productPage.isPageDisplayed());
    }

    @When("user clicks add to cart button")
    public void user_clicks_add_to_cart_button() {
        productPage.doAddToCart();
    }

    @Then("verify the searched product is displayed")
    public void verifyTheSearchedProductIsDisplayed() {
        Assert.assertTrue(searchResultPage.isProductDisplayed());
    }

    @When("user clicks on next button")
    public void userClicksOnNextButton() {
        productPage.clickOnNextButton();
    }

    @Then("verify next page is displayed")
    public void verifyNextPageIsDisplayed() {
        Assert.assertTrue(productPage.isNextPageDisplayed());
    }

    @When("user clicks previous button")
    public void userClicksPreviousButton() {
        productPage.clickOnPreviousButton();
    }

    @Then("verify previous page is displayed")
    public void verifyPreviousPageIsDisplayed() {
        Assert.assertTrue(productPage.isPreviousPageDisplayed());
    }

    @When("user select available sizes")
    public void userSelectAvailableSizes() {
        productPage.selectAllAvailableSizes();
    }

    @When("user clicks on the first product")
    public void userClicksOnTheFirstProduct() {
        productPage.clickOnFirstProduct();
    }

    @Then("verify the product rating on product description page")
    public void verifyTheProductRatingOnProductDescriptionPage() {
        Assert.assertTrue(productPage.verifyRating());
    }


    @And("get the average rating based on the user review")
    public void getTheAverageRatingBasedOnTheUserReview() {
        productPage.calculateAverageRating();
    }

    @Then("verify the average product rating is displayed correctly")
    public void verifyTheAverageProductRatingIsDisplayedCorrectly() {
        Assert.assertTrue(productPage.verifyAverageRating());
    }

    @And("clicks on view all reviews")
    public void clicksOnViewAllReviews() {
        productPage.clickOnAllReviews();
    }

    @And("filter the reviews based on {string} rating")
    public void filterTheReviewsBasedOnRating(String rate) {
        productPage.reviewBasedOnRating(rate);
    }

    @Then("verify that rating review is applied")
    public void verifyThatRatingReviewIsApplied() {
        Assert.assertTrue(productPage.isRatingFilterApplied());
    }

    @When("user get the product rating")
    public void userGetTheProductRating() {
        productPage.getRating();
    }

}
