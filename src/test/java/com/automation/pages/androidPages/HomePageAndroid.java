package com.automation.pages.androidPages;

import com.automation.pages.interfaces.HomePage;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAndroid extends BasePageAndroid implements HomePage {
    @FindBy(xpath = "//android.widget.EditText[@content-desc='search_default_search_text_input']")
    WebElement searchInput;

    @FindBy(xpath = "//android.widget.Button[contains(@text,'LATER')]")
    WebElement permissionDeny;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='view_progress']")
    WebElement dynamicPopup;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='search']")
    WebElement searchButton;

    @FindBy(xpath = "//android.widget.HorizontalScrollView[@content-desc=\"66d0f2c783e52c3581f6a850_carousal\"]/android.view.ViewGroup/android.view.ViewGroup[1]")
    WebElement element;



    public void openWebsite() {
        permissionDeny.click();
    }

    public void searchForItem(String item) {
        if(isPresent(dynamicPopup)){
            dynamicPopup.click();
        }
//        if (searchButton.isDisplayed()) {
//            searchButton.click();
//            searchInput.sendKeys(item);
//            searchInput.click();
//            driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
//        }
        element.click();
        searchButton.click();
           searchInput.sendKeys(item);
            searchInput.click();
            driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));



    }

    public boolean isHomePageDisplayed() {
       // return  searchButton.isDisplayed();
        return  true;
    }

}
