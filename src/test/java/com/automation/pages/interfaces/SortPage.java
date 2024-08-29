package com.automation.pages.interfaces;

import java.util.List;

public interface SortPage {
    default void sortThePriceHighToLow(){

    }
    default void sortThePriceLowToHigh(){

    }
     List<Integer> verifySort();
}
