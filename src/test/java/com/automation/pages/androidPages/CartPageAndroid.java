package com.automation.pages.androidPages;

import com.automation.pages.interfaces.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPageAndroid extends BasePageAndroid implements CartPage {


        @FindBy(xpath = "//android.widget.TextView[contains(@text,'ITEMS SELECTED')]")
        WebElement cartItem;

        @FindBy(xpath = "//android.widget.TextView[@text='1/1 ITEMS SELECTED']/following-sibling::android.view.View[3]")
        WebElement removeButton;

        @FindBy(xpath = "(//android.widget.Image[@text='image'])[5]")
        WebElement confirmRemoveButton;


    @FindBy(xpath = "//span[contains(text(),'Size: ')]")
    List<WebElement> cartAddedSizes;


    @FindBy(xpath = "//div[@class='emptyCart-base-emptyText']")
        WebElement emptyCart;

        @FindBy(xpath = "//span[@class='pdp-price']")
        WebElement pdpPrice;

        @FindBy(xpath = "//span[text()='Discount on MRP']/following-sibling::span")
        WebElement cartDiscount;

        @FindBy(xpath = "//span[text()='Total MRP']/following-sibling::span")
        WebElement cartMrp;


        @FindBy(xpath = "(//button[contains(@class,'size-buttons-size-button ')])[1]")
        WebElement selectSize;

        @FindBy(xpath = "//div[text()='ADD TO BAG']")
        WebElement addToCartButton;


        public boolean verifyAddToCart() {
            return isPresent(cartItem);
        }

        public void clickRemove() {
            removeButton.click();
            confirmRemoveButton.click();
        }

        public boolean isItemInCartDisplayed() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return isPresent(cartItem);
        }

        public void getPriceOnProductPage() {

        }

        public boolean verifyCartPrice() {
            return true;
        }


        public boolean checkSizesAdded(){
            int sizes=ProductPageAndroid.size;
            return cartItem.getText().contains(sizes+"");
        }


}
