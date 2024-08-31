package com.automation.pages.interfaces;

public interface HomePage {
     default void openWebsite(){

    }
    default void  searchForItem(String item){

    }
    default boolean isHomePageDisplayed(){
        return false;
    }
}
