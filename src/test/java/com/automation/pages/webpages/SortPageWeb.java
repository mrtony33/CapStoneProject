package com.automation.pages.webpages;

import com.automation.pages.interfaces.SortPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SortPageWeb extends BasePageWeb implements SortPage {

    @FindBy(xpath = "//div[@class='sort-sortBy']")
     WebElement dropdown;

    @FindBy(xpath = "//ul[@class='sort-list']/li[5]")
    WebElement option1;

    @FindBy(xpath = "//ul[@class='sort-list']/li[6]")
    WebElement option2;

    public void sortThePriceHighToLow() {
        dropdown.click();
        option1.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
}
