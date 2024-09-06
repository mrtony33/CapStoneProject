package com.automation.pages.interfaces;

public interface NavigationPage {

    default void clickOnNavigationLink(String nav){
    }

    default boolean isNavigatedPageDisplayed(String nav){
        return false;
    }
}
