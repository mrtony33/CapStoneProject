package com.automation.pages.androidPages;

import com.automation.pages.interfaces.ProductPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageAndroid extends BasePageAndroid implements ProductPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='priceinfo_container']/android.widget.TextView[4]")
    WebElement productPrice;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='leftElement']")
    WebElement backIcon;


    public boolean isPageDisplayed(){
        return productPrice.isDisplayed();
    }
    public void goBackToResults(){
        backIcon.click();
    }

    String rating1;
    public void getRating(){


    }
}
