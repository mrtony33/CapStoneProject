package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{
    @FindBy(xpath = "//li[@class='product-base']")
    List<WebElement> searchResults;
    @FindBy(xpath = "//span[text()='Bag']")
    WebElement cartIcon;
    @FindBy(xpath = "//span[contains(@class,'filter-summary-removeIcon sprites-remove')]")
    WebElement removeFilterElement;




    String filter;


    CartPage cartPage=new CartPage();


    public  void selectMany(int totalItemsToBeAdded) {
        for (int i=0;i<totalItemsToBeAdded;i++){
            searchResults.get(i).click();
            switchHandles();
            cartPage.getPriceOnProductPage();
            driver.close();
            switchHandles();
        }
    }

    public void clickFirstResult() {
            searchResults.get(0).click();
    }

    public boolean checkResultsPresent() {
        return !searchResults.isEmpty();
    }

    public void goToCart() {
        cartIcon.click();
    }
    WebElement radio;
    public void doFilter(String filterKey) {
        radio=driver.findElement(By.xpath(String.format("//input[contains(@value,'%s')]",filterKey)));
        javascriptClicker(radio);
        filter=filterKey;
    }





    public boolean checkFilterGender() {
        try {
            Thread.sleep(3000);
        }catch (Exception ignored){}
        return radio.isSelected();
    }

    public boolean checkFilterDiscount() {
        int key=Integer.parseInt(filter);
        boolean flag=true;
        if (isDisplayed(removeFilterElement)){
            for (WebElement i:driver.findElements(By.xpath("//span[@class='product-discountPercentage']"))){
                int currentDiscount=Integer.parseInt(i.getText().replaceAll("\\D+",""));
                if (currentDiscount<key){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }

    public void removeFilter() {
        removeFilterElement.click();
    }

    public boolean removeFilterSuccess() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return !isDisplayed(removeFilterElement);
    }
}
