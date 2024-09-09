package com.automation.pages.interfaces;

import java.util.List;

public interface SortPage {
    default void sortThePriceHighToLow(){

    }
    default void sortThePriceLowToHigh(){

    }
     List<Integer> verifySort();

    default void sortBasedOnRating(){

    }

   default boolean verifyRatingSort(){
        return false;
   }

    void sortByDiscount();

    boolean verifyDiscountSort();
}
