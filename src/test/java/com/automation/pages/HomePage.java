package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    WebElement searchInput;


    public void openWebsite() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    public void searchForItem(String item) {
        searchInput.sendKeys();
    }
}
