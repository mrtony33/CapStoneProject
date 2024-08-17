package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    @FindBy(xpath = "(//button[contains(@class,'size-buttons-size-button ')])[1]")
    WebElement selectSize;
    @FindBy(xpath = "//div[text()='ADD TO BAG']")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[text()='GO TO BAG']")
    WebElement goToBag;
    @FindBy(xpath = "//span[contains(@class,'desktop-badge') and text()='1']")
    WebElement cartIcon;




    public boolean isPageDisplayed() {
        return isDisplayed(selectSize);
    }

    public void doAddToCart() {
        String currentHandle=driver.getWindowHandle();
        for (String handle:driver.getWindowHandles()){
            System.out.println(handle);
            if (!handle.equals(currentHandle)){
                driver.switchTo().window(handle);
            }
        }
        doScroll(300);
        selectSize.click();
        addToCartButton.click();
        if (isDisplayed(goToBag) && isDisplayed(cartIcon)) {
            cartIcon.click();
        }
    }


}
