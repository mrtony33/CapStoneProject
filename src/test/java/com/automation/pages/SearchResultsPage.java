package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{
    @FindBy(xpath = "//li[@class='product-base']")
    List<WebElement> searchResults;

    public void clickFirstResult() {
            searchResults.get(0).click();

    }

    public boolean checkResultsPresent() {
        return !searchResults.isEmpty();
    }
}
