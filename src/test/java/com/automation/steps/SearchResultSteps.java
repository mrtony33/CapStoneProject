package com.automation.steps;

import com.automation.pages.SearchResultsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchResultSteps {
    SearchResultsPage searchResultsPage=new SearchResultsPage();

    @When("click on the first result")
    public void click_on_the_first_result() {
        searchResultsPage.clickFirstResult();
    }

    @Then("verify search results is not empty")
    public void verifySearchResultsIsNotEmpty() {
        Assert.assertTrue(searchResultsPage.checkResultsPresent());
    }

    @And("user adds first {string} elements to cart")
    public void userAddsFirstElementsToCart(String numberOfItems) {
        searchResultsPage.selectMany(Integer.parseInt(numberOfItems));
    }

    @And("go to cart page")
    public void goToCartPage() {
        searchResultsPage.goToCart();
    }

    @When("user wants to filter by {string}")
    public void userWantsToFilterBy(String name) {
        searchResultsPage.doFilter(name);
    }

    @Then("verify filter is applied")
    public void verifyFilterIsApplied() {
        Assert.assertTrue(searchResultsPage.checkFilterDiscountAndGender());
    }

    @When("user removes filter")
    public void userRemovesFilter() {
    }

}
