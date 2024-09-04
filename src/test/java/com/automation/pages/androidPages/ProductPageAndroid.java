package com.automation.pages.androidPages;

import com.automation.pages.interfaces.ProductPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPageAndroid extends BasePageAndroid implements ProductPage {

    @FindBy(xpath = "((//android.view.ViewGroup[@content-desc=\"ratings_view_small\"])[1]//android.widget.TextView)[1]")
    WebElement rate1;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"touchable_image_container\"]")
    List<WebElement> searchResults;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"ratings_pdp\"]/android.view.ViewGroup//android.widget.TextView)[1]")
    WebElement rate2;

    String rating1;
    public void getRating(){
        rating1=rate1.getText();
        System.out.println(rating1);
    }
    public void clickOnFirstProduct(){
        searchResults.get(0).click();
    }
    public boolean verifyRating(){
        String rating2=rate2.getText();
        System.out.println(rating2);
        return rating1.equals(rating2);
    }
}
