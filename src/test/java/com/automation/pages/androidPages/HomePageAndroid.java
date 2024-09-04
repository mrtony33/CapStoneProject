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

    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.FrameLayout")
    WebElement popup;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='search']")
    WebElement searchButton;



    public void openWebsite() {
        permissionDeny.click();
    }

    public void searchForItem(String item) {

        try {
            searchButton.click();
            searchInput.sendKeys(item);
            searchInput.click();
            driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
        } catch (Exception e) {
            popup.click();
            searchButton.click();
            searchInput.sendKeys(item);
            driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "search"));
        }

    }


    public boolean isHomePageDisplayed() {
        return  popup.isDisplayed();
    }

}
