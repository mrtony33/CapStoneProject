package com.automation.pages.androidPages;

import com.automation.pages.interfaces.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPageAndroid extends BasePageAndroid implements SearchResultPage {
    public static String searchKey;


    @FindBy(xpath = "//android.widget.TextView[contains(@text,' Items')]/preceding-sibling::android.widget.TextView[1]")
    WebElement resultsTitle;

    static List<WebElement> searchResults=new ArrayList<>();



    public boolean checkResultsPresent() {
        int count=1;
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        while (count<3){
            System.out.println(count);
            if(!isPresentXpath(String.format("//android.view.ViewGroup[@content-desc='plp_product_%d']",++count))){
                scrollOrSwipe(width / 2, height/2 , width / 2, 0);
            }else{
                System.out.println(count);
                searchResults.add(driver.findElement(By.xpath(String.format("//android.view.ViewGroup[@content-desc='plp_product_%d']",count))));
            }
        }
        return !searchResults.isEmpty();
    }

    public void clickFirstResult() {
        System.out.println(searchResults);
        searchResults.get(0).click();
    }

    public boolean isProductDisplayed() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return resultsTitle.getText().toLowerCase().contains(searchKey);
    }
}
