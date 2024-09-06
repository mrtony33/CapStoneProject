package com.automation.steps;

import com.automation.pages.androidPages.SortPageAndroid;
import com.automation.pages.interfaces.SortPage;
import com.automation.pages.webpages.SortPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortSteps {

    SortPage sortPage;
    public SortSteps() {
        if (ConfigReader.getProperty("automation.type").equals("web")) {
            sortPage = new SortPageWeb();
        } else {
            sortPage = new SortPageAndroid();
        }
    }
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
        Assert.assertArrayEquals(sortedPriceList.toArray(),checkSortedList.toArray());
    }

    @Then("verify the product is sorted from low to high")
    public void verifyTheProductIsSortedFromLowToHigh() {
        List<Integer> sortedPriceList=sortPage.verifySort();
        List<Integer> checkSortedList=new ArrayList<>(sortedPriceList);
        Collections.sort(checkSortedList);
        Assert.assertEquals(sortedPriceList,checkSortedList);
    }

    @And("user sort the product based on customer rating")
    public void userSortTheProductBasedOnCustomerRating() {
        sortPage.sortBasedOnRating();
    }

    @Then("verify the product is sorted based on customer rating")
    public void verifyTheProductIsSortedBasedOnCustomerRating() {
        Assert.assertTrue(sortPage.verifyRatingSort());
    }
}
