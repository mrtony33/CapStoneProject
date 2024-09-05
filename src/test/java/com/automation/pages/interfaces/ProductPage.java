package com.automation.pages.interfaces;

public interface ProductPage {
    default boolean isPageDisplayed(){
        return false;
    }
    default void doAddToCart(){

    }
    default boolean isProductDisplayed(){
        return false;
    }
    default boolean isNextPageDisplayed(){
        return false;
    }
    default void selectAllAvailableSizes(){

    }
    default void clickOnNextButton(){

    }
    default void clickOnPreviousButton(){

    }
    default boolean isPreviousPageDisplayed(){
        return false;
    }
    default void getRating(){

    }

    default boolean verifyRating(){
        return false;
    }
    default void calculateAverageRating(){

    }
    default boolean verifyAverageRating(){
        return false;
    }
    default void clickOnAllReviews(){

    }
    default void reviewBasedOnRating(String rate){

    }
    default boolean isRatingFilterApplied(){
        return false;
    }

    default void goBackToResults(){

    }

   default void getPricing(){

   }

    default  boolean verifyPricing(){
        return  false;
    }
}
