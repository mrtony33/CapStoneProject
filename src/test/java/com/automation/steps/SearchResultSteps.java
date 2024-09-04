package com.automation.steps;

import com.automation.pages.androidPages.SearchResultsPageAndroid;
import com.automation.pages.interfaces.SearchResultPage;
import com.automation.pages.webpages.SearchResultsPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchResultSteps {
    SearchResultPage searchResultsPage;

    public SearchResultSteps() {
        if (ConfigReader.getProperty("automation.type").equals("web")){
            searchResultsPage=new SearchResultsPageWeb();
        }else {
            searchResultsPage=new SearchResultsPageAndroid();
        }
    }


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



    @When("user removes filter")
    public void userRemovesFilter() {
        searchResultsPage.removeFilter();
    }

    @Then("verify gender filter is applied")
    public void verifyGenderFilterIsApplied() {
        Assert.assertTrue(searchResultsPage.checkFilterGender());
    }

    @Then("verify discount filter is applied")
    public void verifyDiscountFilterIsApplied() {
        Assert.assertTrue(searchResultsPage.checkFilterDiscount());
    }

    @Then("verify filter is removed")
    public void verifyFilterIsRemoved() {
        Assert.assertTrue(searchResultsPage.removeFilterSuccess());
    }

}
