package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartPage extends BasePage{
    @FindBy(xpath = "//span[text()='1/1 ITEMS SELECTED']")
    WebElement cartItem;

    @FindBy(xpath = "//span[contains(text(),'Size: ')]")
    List<WebElement> cartAddedSizes;

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
        confirmRemoveButton.click();
    }

    public boolean isItemInCartDisplayed() {
        return isDisplayed(emptyCart);
    }
ProductPage productPage=new ProductPage();
    public boolean verifyAllSizesAddedToCart() {
        List<String>productPageSizes = new ArrayList<>();
        for (WebElement i:productPage.sizes){
            productPageSizes.add("Size: "+i.getText());
        }
        productPage.cartIcon.click();
        for (int i=0;i<cartAddedSizes.size();i++) {
            if (!Objects.equals(productPageSizes.get(i), cartAddedSizes.get(i).getText())){
                return false;
            }
        }
        return true;
    }
}
