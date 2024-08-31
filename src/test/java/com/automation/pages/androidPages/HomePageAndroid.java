package com.automation.pages.androidPages;

import com.automation.pages.interfaces.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAndroid extends BasePageAndroid implements HomePage {
    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    WebElement searchInput;
    @FindBy(xpath = "//a[contains(@class,'submit')]")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='desktop-logoContainer']")
    WebElement logo;

    @FindBy(xpath = "//div[@class='desktop-actions']")
    WebElement actions;

    public void openWebsite() {

        //driver.get(ConfigReader.getProperty("base.url"));
    }

    public void searchForItem(String item) {
        if (searchInput.isDisplayed()) {
            searchInput.sendKeys(item);
            searchButton.click();
        }
    }

    public boolean isHomePageDisplayed() {
        return  logo.isDisplayed() && actions.isDisplayed();
    }

}
