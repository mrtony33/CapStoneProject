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

    public void doFilter(String filterKey) {
        WebElement radio=driver.findElement(By.xpath(String.format("//input[contains(@value,'%s')]",filterKey)));
        javascriptClicker(radio);
        System.out.println(radio.isSelected());
        filter=filterKey;
    }

    public boolean checkFilterIsDone(int key) {
        boolean flag=true;
        System.out.println("hello");
        WebElement removeFilter=driver.findElement(By.xpath("//span[contains(@class,'filter-summary-removeIcon sprites-remove')]"));

        if (isDisplayed(removeFilter)){
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

    public boolean checkFilterIsDone(String key) {
        boolean flag=true;
        for (WebElement i:driver.findElements(By.xpath("//h4[@class='product-product']"))){
            if (!i.getText().contains(key)){
                flag=false;
                break;
            }
        }
        return flag;
    }


    public boolean checkFilterDiscountAndGender() {
        String key=filter;
        String newKey=filter.replaceAll("\\D+","");
        if (key.length()!=newKey.length()){
            return checkFilterIsDone(filter);
        }
        return checkFilterIsDone(Integer.parseInt(filter));
    }
}
