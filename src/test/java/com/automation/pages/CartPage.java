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

    @FindBy(xpath = "//span[@class='pdp-price']")
    WebElement pdpPrice;

    @FindBy(xpath = "//div[@class='priceDetail-base-total ']/span[@class='priceDetail-base-value ']")
    WebElement cartPrice;


    @FindBy(xpath = "(//button[contains(@class,'size-buttons-size-button ')])[1]")
    WebElement selectSize;

    @FindBy(xpath = "//div[text()='ADD TO BAG']")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='GO TO BAG']")
    WebElement goToBag;

    @FindBy(xpath = "//span[contains(@class,'desktop-badge') and text()='1']")
    WebElement cartIcon;

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

    int price;
    public void getPriceOnPdp() {
        String currentHandle=driver.getWindowHandle();
        for (String handle:driver.getWindowHandles()){
            if (!handle.equals(currentHandle)){
                driver.switchTo().window(handle);
            }
        }
        String p=pdpPrice.getText().replaceAll("\\D","").trim();
        price=Integer.parseInt(p);
        System.out.println(price);
        doScroll(300);
        selectSize.click();
        addToCartButton.click();
        if (isDisplayed(goToBag) && isDisplayed(cartIcon)) {
            cartIcon.click();
        }
    }
    public boolean verifyCartPrice() {
        String p=cartPrice.getText().replaceAll("\\D","").trim();
        int price2=Integer.parseInt(p);
        System.out.println(price2);
        return price==price2;
    }
}
