package com.automation.pages.webpages;

import com.automation.pages.interfaces.CartPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPageWeb extends BasePageWeb implements CartPage {
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

//    @FindBy(xpath = "//span[text()='GO TO BAG']")
//    WebElement goToBag;
//
//    @FindBy(xpath = "//span[contains(@class,'desktop-badge') and text()='1']")
//    WebElement cartIcon;

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

     static int price;
    public void getPriceOnProductPage() {
        String p=pdpPrice.getText().replaceAll("\\D","").trim();
        CartPageWeb.price+=Integer.parseInt(p);
        System.out.println(CartPageWeb.price);
        doScroll(300);
        selectSize.click();
        addToCartButton.click();
    }

    public boolean verifyCartPrice() {
        String mrp=cartMrp.getText().replaceAll("\\D","").trim();
        String discount=cartDiscount.getText().replaceAll("\\D","").trim();
        int mrpInt=Integer.parseInt(mrp);
        int discountInt=Integer.parseInt(discount);
        System.out.println(mrpInt-discountInt +" "+ CartPageWeb.price);
        return CartPageWeb.price==mrpInt-discountInt;
    }
    ProductPageWeb productPage=new ProductPageWeb();


    public boolean checkSizesAdded(){
        List<String> sizes=new ArrayList<>();
        for (WebElement i:productPage.sizes){
            sizes.add("Size: "+i.getText());
        }
        productPage.cartIcon.click();
        for (int i=0;i<cartAddedSizes.size();i++){
            if (!sizes.get(i).equals(cartAddedSizes.get(i).getText())){
                return false;
            }
        }
        return true;
    }
}
