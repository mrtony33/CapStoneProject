package com.automation.pages.webpages;

import com.automation.pages.interfaces.SortPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPageWeb extends BasePageWeb implements SortPage {

    @FindBy(xpath = "//div[@class='sort-sortBy']")
     WebElement dropdown;

    @FindBy(xpath = "//ul[@class='sort-list']/li[5]")
    WebElement option1;

    @FindBy(xpath = "//ul[@class='sort-list']/li[6]")
    WebElement option2;

    @FindBy(xpath = "//ul[@class='sort-list']/li[7]")
    WebElement option3;

    @FindBy(xpath = "//ul[@class='sort-list']/li[4]")
    WebElement sortByDiscount;

    @FindBy(xpath = "//span[@class='product-discountPercentage' and contains(text(),'%')]")
    List<WebElement> items;



    public void sortThePriceHighToLow() {
        dropdown.click();
        option1.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void sortByDiscount(){
        dropdown.click();
        sortByDiscount.click();
    }

    public boolean verifyDiscountSort(){
        List<String > values=new ArrayList<>();
        List<String> sorted=new ArrayList<>();
        for (WebElement i:items){
            values.add(i.getText());
            sorted.add(i.getText());
        }
        return values.equals(sorted);
    }

    public void sortThePriceLowToHigh() {
        dropdown.click();
        option2.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Integer> verifySort(){
        List<WebElement> sortedList=driver.findElements(By.xpath("//div[@class='product-price']"));
        List<Integer> sortedPriceList=new ArrayList<>();
        for (WebElement l:sortedList){
            String s=l.getText();
            int startIndex = s.indexOf("R") + 4;
            if(s.contains("OFF")) {
                int endIndex = s.indexOf("R", startIndex);
                s = s.substring(startIndex, endIndex).trim();
                sortedPriceList.add(Integer.parseInt(s));
            }
            else{
                s=s.substring(startIndex).trim();
                sortedPriceList.add(Integer.parseInt(s));
            }
        }
        return sortedPriceList;
    }
    public void sortBasedOnRating(){
        dropdown.click();
        option3.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean verifyRatingSort(){
        List<WebElement> ratings=driver.findElements(By.xpath("//div[@class='product-ratingsContainer']/span[1]"));
        List<Float> ratingList1=new ArrayList<>();
        for (WebElement w:ratings){
            ratingList1.add(Float.parseFloat(w.getText()));
        }
        List<Float> ratingList2=new ArrayList<>(ratingList1);
        Collections.sort(ratingList2);
        return ratingList1.equals(ratingList2);
    }
}
