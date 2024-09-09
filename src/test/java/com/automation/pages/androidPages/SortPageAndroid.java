package com.automation.pages.androidPages;

import com.automation.pages.interfaces.SortPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPageAndroid extends BasePageAndroid implements SortPage {
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"touchable_sort\"]")
    WebElement sortButton;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"text_sort_item-1\"]")
    WebElement highToLowSort;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"text_sort_item-4\"]")
    WebElement lowToHighSort;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"text_sort_item-5\"]")
    WebElement ratingSort;

    public void sortThePriceHighToLow(){
        sortButton.click();
        highToLowSort.click();
    }

    @Override
    public List<Integer> verifySort() {
        List<Integer> priceList=new ArrayList<>();
        List<String> l=new ArrayList<>();
        for(int i=0;i<=4;i++){
            List<WebElement> prices=driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"text_price\"]"));
            for (WebElement e:prices){
                String s=e.getText();
                if(!l.contains(s)) {
                    l.add(s.replaceAll("\\D", ""));
                }
            }
            Dimension dimension = driver.manage().window().getSize();
            int width = dimension.getWidth();
            int height = dimension.getHeight();
                scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }
        for(String s:l){
            if(!priceList.contains(Integer.parseInt(s))) {
                priceList.add(Integer.parseInt(s));
                System.out.println(Integer.parseInt(s));
            }
        }

        return priceList;
    }
    public void sortThePriceLowToHigh(){
        sortButton.click();
        lowToHighSort.click();

    }
    public void sortBasedOnRating(){
        sortButton.click();
        ratingSort.click();
    }
    public boolean verifyRatingSort(){
        List<Float> ratings=new ArrayList<>();
        for (int i=1;i<=3;i++){
            List<WebElement> rates=driver.findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"ratings_view_small\"]/android.widget.TextView[1]"));
            for(WebElement e:rates) {
                float n = Float.parseFloat(e.getText());
                if (!ratings.contains(n)) {
                    ratings.add(n);
                }
            }
                Dimension dimension = driver.manage().window().getSize();
                int width = dimension.getWidth();
                int height = dimension.getHeight();
                scrollOrSwipe(width / 2, height / 2, width / 2, 0);

        }
        List<Float> ratings2=new ArrayList<>(ratings);
        Collections.sort(ratings2);
        return ratings.equals(ratings2);
    }

    @Override
    public void sortByDiscount() {

    }

    @Override
    public boolean verifyDiscountSort() {

        return false;
    }
}
