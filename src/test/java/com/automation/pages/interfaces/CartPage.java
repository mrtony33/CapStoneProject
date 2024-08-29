package com.automation.pages.interfaces;

public interface CartPage {
    default  boolean verifyAddToCart(){
        return false;
    }
    default void clickRemove(){

    }
    default boolean isItemInCartDisplayed(){
        return false;
    }
    default void getPriceOnProductPage(){

    }
    default boolean verifyCartPrice(){
        return false;
    }
    default boolean  checkSizesAdded(){
        return false;
    }
}
