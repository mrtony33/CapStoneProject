package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage{
    @FindBy(xpath = "(//button[contains(@class,'size-buttons-size-button ')])[1]")
    WebElement selectSize;

    @FindBy(xpath = "//button[contains(@class,'size-buttons-size-button ')]")
    List<WebElement> sizes;
    @FindBy(xpath = "//div[text()='ADD TO BAG']")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[text()='GO TO BAG']")
    WebElement goToBag;
    @FindBy(xpath = "//span[contains(@class,'desktop-badge')]")
    WebElement cartIcon;
    @FindBy(xpath = "//h1[@class='title-title']")
    WebElement productTitle;


    public boolean isPageDisplayed() {
        return isDisplayed(selectSize);
    }



    public void doAddToCart() {
        switchHandles();
        doScroll(300);
        selectSize.click();
        addToCartButton.click();
        if (isDisplayed(goToBag) && isDisplayed(cartIcon)) {
            cartIcon.click();
        }
    }


    public boolean isProductDisplayed() {
        return productTitle.getText().contains("Shoe");
    }

    public void selectAllAvailableSizes() {
        switchHandles();
        doScroll(300);
        for (WebElement i:sizes){
            i.click();
            addToCartButton.click();
        }
    }
}
