package com.automation.pages.androidPages;

import com.automation.pages.interfaces.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPageAndroid extends BasePageAndroid implements SearchResultPage {
    public static String searchKey;

    @FindBy(xpath = "(//android.widget.TextView[contains(@text,'Best Price')])[2]")
    WebElement item2ForScroll;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='search']")
    WebElement searchIcon;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,' Items')]/preceding-sibling::android.widget.TextView[1]")
    WebElement resultsTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"touchable_image_container\"]")
    List<WebElement> searchResults;



    public boolean checkResultsPresent() {
        int count=1;
        while (count<60){
            System.out.println("inside while");
            WebElement item=driver.findElement(By.xpath(String.format("//android.view.ViewGroup[@content-desc='plp_product_%d']",count++)));
            if (isPresent(item)){
                searchResults.add(item);
            }else{
                int startX=item2ForScroll.getLocation().getX();
                int startY=item2ForScroll.getLocation().getY();
                int endX=searchIcon.getLocation().getX();
                int endY=searchIcon.getLocation().getY();
                scrollOrSwipe(startX,startY,endX,endY);
                count--;
            }
        }
        return !searchResults.isEmpty();
    }

    public void clickFirstResult() {
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
