package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(xpath = "//span[text()='1/1 ITEMS SELECTED']")
    WebElement cartItem;

    @FindBy(xpath = "//button[text()='REMOVE']")
    WebElement removeButton;

    @FindBy(xpath = "//button[@class='inlinebuttonV2-base-actionButton ']")
    WebElement confirmRemoveButton;

    @FindBy(xpath = "//div[@class='emptyCart-base-emptyText']")
    WebElement emptyCart;

    public boolean verifyAddToCart() {

        return isDisplayed(cartItem);
    }

    public void clickRemove() {
        removeButton.click();
        confirmRemoveButton.click();;
    }

    public boolean isItemInCartDisplayed() {
        return isDisplayed(emptyCart);
    }
}
