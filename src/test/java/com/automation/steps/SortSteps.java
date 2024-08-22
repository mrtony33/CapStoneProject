package com.automation.steps;

import com.automation.pages.SortPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortSteps {

    SortPage sortPage=new SortPage();

    @And("user sort the price from high to low")
    public void userSortThePriceFromHighToLow() {
        sortPage.sortThePriceHighToLow();
    }

    @And("user sort the price from low to high")
    public void userSortThePriceFromLowToHigh() {
        sortPage.sortThePriceLowToHigh();
    }

    @Then("verify the product is sorted from high to low")
    public void verifyTheProductIsSortedFromHighToLow() {
        List<Integer> sortedPriceList=sortPage.verifySort();
        List<Integer> checkSortedList=new ArrayList<>(sortedPriceList);
        Collections.sort(checkSortedList);
        Collections.reverse(checkSortedList);
        Assert.assertEquals(sortedPriceList,checkSortedList);
    }

    @Then("verify the product is sorted from low to high")
    public void verifyTheProductIsSortedFromLowToHigh() {
        List<Integer> sortedPriceList=sortPage.verifySort();
        List<Integer> checkSortedList=new ArrayList<>(sortedPriceList);
        Collections.sort(checkSortedList);
        Assert.assertEquals(sortedPriceList,checkSortedList);
    }
}
