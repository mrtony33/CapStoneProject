package com.automation.pages.interfaces;

public interface SearchResultPage {

    default void selectMany(int totalItemsToBeAdded){

    }
    default void clickFirstResult(){

    }
    default boolean checkResultsPresent(){
        return false;
    }
    default void goToCart(){

    }
    default void doFilter(String filterKey){

    }
    default boolean checkFilterGender(){
        return false;
    }
    default boolean checkFilterDiscount(){
        return false;
    }
    default void  removeFilter(){

    }
    default boolean removeFilterSuccess(){
        return  false;
    }

    default boolean isProductDisplayed(){
        return false;
    }
}
