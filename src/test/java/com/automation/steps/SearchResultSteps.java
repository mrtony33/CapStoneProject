package com.automation.steps;

import com.automation.pages.SearchResultsPage;
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
}
