package com.automation.pages.androidPages;

import com.automation.pages.interfaces.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPageAndroid extends BasePageAndroid implements ProductPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='priceinfo_container']/android.widget.TextView[4]")
    WebElement productPrice;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='leftElement']")
    WebElement backIcon;
    @FindBy(xpath = "(//android.widget.TextView[@content-desc=\"text_price\" ])[1]")
    WebElement priceOfProduct;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='cart_back_button']")
    WebElement cartBackIcon;
    @FindBy(xpath = "//android.widget.TextView[@text='Add to Bag']")
    WebElement addToCart;
    @FindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'size_select_')]")
    List<WebElement> sizes;
    @FindBy(xpath = "//android.widget.TextView[@text='DONE']")
    WebElement addToCartDone;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='bag']")
    WebElement cartIcon;

    public static int size;


    public boolean isNextPageDisplayed(){
        return false;
    }
    public void selectAllAvailableSizes(){
        Dimension screenSize=driver.manage().window().getSize();
        size=sizes.size();
        for (WebElement i:sizes){
            if (!isPresentXpath("//android.view.ViewGroup[@content-desc='priceinfo_container']")){
                scrollOrSwipe(screenSize.getWidth(),300,screenSize.getWidth(),screenSize.getHeight());
            }
            if (!isPresentXpath("//android.widget.TextView[@content-desc='selling_price']")){
                scrollOrSwipe(screenSize.getWidth(),screenSize.getHeight(),screenSize.getWidth(),0);
            }
            i.click();
            addToCart.click();
            cartBackIcon.click();
        }
    }
    public void clickOnNextButton(){

    }
    public void clickOnPreviousButton(){

    }


    public void doAddToCart(){
        addToCart.click();
        sizes.get(0).click();
        addToCartDone.click();
        addToCartDone.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cartIcon.click();
    }

    public boolean isPageDisplayed(){
        return productPrice.isDisplayed();
    }
    public void goBackToResults(){
        backIcon.click();
    }

    @FindBy(xpath = "((//android.view.ViewGroup[@content-desc=\"ratings_view_small\"])[1]//android.widget.TextView)[1]")
    WebElement rate1;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"touchable_image_container\"]")
    List<WebElement> searchResults;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"ratings_pdp\"]/android.view.ViewGroup//android.widget.TextView)[1]")
    WebElement rate2;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"reviewsQnA\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
    WebElement reviewsButton;
    @FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView")
     WebElement averageRatingDisplayed;

    String rating1;
    public void getRating(){
        rating1=rate1.getText();
        System.out.println(rating1);
    }
    String pricing1;
    public void getPricing(){
        pricing1=priceOfProduct.getText().replaceAll("\\D","").trim();
        System.out.println(pricing1);
    }
    public   boolean verifyPricing(){
        String pricing2=driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"priceinfo_container\"]/android.widget.TextView[4]")).getText();
        System.out.println(pricing2);
        return pricing1.equals(pricing2);
    }
    public void clickOnFirstProduct(){
        searchResults.get(0).click();
    }
    public boolean verifyRating(){
        String rating2=rate2.getText();
        System.out.println(rating2);
        return rating1.equals(rating2);
    }

    float averageRatingCalculated;
    public void calculateAverageRating(){
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(reviewsButton)) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }
        reviewsButton.click();
        float sum=0;
        int reviewers=0;
        int star=5;
        for(int i=1;i<=5;i++){
            String s=driver.findElement(By.xpath(String.format("(//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2])[%s]",i))).getText();
            int rate=Integer.parseInt(s);
            reviewers=reviewers+rate;
            sum =sum+(star*rate);
            star--;
        }
        averageRatingCalculated=sum/reviewers;
        averageRatingCalculated= Math.round(averageRatingCalculated * 10f) /10f;
        System.out.println(averageRatingCalculated);
    }
    public boolean verifyAverageRating(){
        String s=averageRatingDisplayed.getText();
        Float averageRating=Float.parseFloat(s);
        System.out.println(averageRating);
        return averageRating==averageRatingCalculated;
    }
    public void clickOnAllReviews(){
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(reviewsButton)) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }
        reviewsButton.click();
    }
    WebElement ratingOption;
    String rating;
    public void reviewBasedOnRating(String rate){
        int r=5-Integer.parseInt(rate);
        ratingOption= driver.findElement(By.xpath(String.format("//android.view.ViewGroup[@content-desc='cross_sell_pill%d']",r)));
        ratingOption.click();
        rating=ratingOption.getText();
        System.out.println(rating);
    }
    public boolean isRatingFilterApplied(){
        WebElement filteredRating=driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView"));
            if (!filteredRating.getText().equals(rating)) {
                return true;
            }
            System.out.println(filteredRating.getText());

        return false;
    }
}

