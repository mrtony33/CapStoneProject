package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(xpath = "//span[text()='1/1 ITEMS SELECTED']")
    WebElement cartItem;

    public boolean verifyAddToCart() {
        return isDisplayed(cartItem);
    }
}
