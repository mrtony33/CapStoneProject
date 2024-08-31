package com.automation.pages.webpages;

import com.automation.pages.interfaces.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductPageWeb extends BasePageWeb implements ProductPage {
    @FindBy(xpath = "(//button[contains(@class,'size-buttons-size-button ')])[1]")
    WebElement selectSize;

    @FindBy(xpath = "//button[contains(@class,'size-buttons-size-button ')]")
    List<WebElement> sizes;
    @FindBy(xpath = "//div[text()='ADD TO BAG']")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[text()='GO TO BAG']")
    WebElement goToBag;
    @FindBy(xpath = "//span[contains(@class,'desktop-badge')]")
    WebElement cartIcon;
    @FindBy(xpath = "//h1[@class='title-title']")
    WebElement productTitle;
    @FindBy(xpath = "//li[@class='pagination-next']")
    WebElement nextButton;
    @FindBy(xpath = "//li[@class='pagination-paginationMeta']")
    WebElement pageNum;
    @FindBy(xpath = "//li[@class='pagination-prev']")
    WebElement previousButton;
    @FindBy(xpath = "//li[@class='product-base']")
    List<WebElement> searchResults;
    @FindBy(xpath = "(//div[@class='product-ratingsContainer']/span[1])[1]")
    WebElement fistProductRating;
    @FindBy(xpath = "//div[@class='index-overallRating']/div[1]")
    WebElement ratingOnPdpPage;
    @FindBy(xpath = "//div[@class='index-flexRow index-averageRating']/span[1]")
    WebElement averageRatingDisplayed;
    @FindBy(xpath = "//a[@class='detailed-reviews-allReviews']")
    WebElement viewAllReviews;
    @FindBy(xpath = "//div[@class='dropdown-filter-active']")
    WebElement ratingDropdown;
    @FindBy(xpath = "//div[@class='product-price']")
    WebElement productPrice;
    @FindBy(xpath = "//span[@class='pdp-price']")
    WebElement pdpPrice;


    public boolean isPageDisplayed() {
        switchHandles();
        doScroll(200);
        return isDisplayed(selectSize);
    }
    public void doAddToCart() {
        doScroll(300);
        selectSize.click();
        addToCartButton.click();
        if (isDisplayed(goToBag) && isDisplayed(cartIcon)) {
            cartIcon.click();
        }
    }


    public boolean isProductDisplayed() {

        return productTitle.getText().contains("Shirt");
    }

    public void selectAllAvailableSizes() {
        doScroll(300);
        System.out.println(sizes.size());
        for (WebElement i:sizes){
            jse.executeScript("arguments[0].click();", i);
            addToCartButton.click();
        }
    }
    int firstPageNumber;
    public void clickOnNextButton() {
        doScroll(300);
        String num=pageNum.getText().substring(5,6).trim();
        firstPageNumber=Integer.parseInt(num);
        System.out.println(firstPageNumber);
        nextButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    int secondPageNumber;
    public boolean isNextPageDisplayed() {
        String num=pageNum.getText().substring(5,6).trim();
        secondPageNumber=Integer.parseInt(num);
        System.out.println(secondPageNumber);
        return secondPageNumber==firstPageNumber+1;
    }
    public void clickOnPreviousButton() {
        doScroll(200);
        System.out.println(secondPageNumber);
        previousButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPreviousPageDisplayed() {
        String num=pageNum.getText().substring(5,6).trim();
        int firstPageNum=Integer.parseInt(num);
        System.out.println(firstPageNum);
        return firstPageNum==secondPageNumber-1;
    }
    String rating1;
    public void getRating() {
        rating1=fistProductRating.getText();
        System.out.println(rating1);
    }
    public void clickOnFirstProduct() {
        searchResults.get(0).click();
    }
    String rating2;
    public boolean verifyRating() {
        switchHandles();
        rating2=ratingOnPdpPage.getText();
        System.out.println(rating2);
        return rating1.equals(rating2);
    }
    float averageRatingCalculated;
    public void calculateAverageRating() {
        switchHandles();
        float sum=0;
        int reviewers=0;
        int star=5;
        for(int i=1;i<=5;i++){
            String s=driver.findElement(By.xpath(String.format("(//div[@class='index-count'])[%s]",i))).getText();
            int rate=Integer.parseInt(s);
            reviewers=reviewers+rate;
            sum =sum+(star*rate);
            star--;
        }
        averageRatingCalculated=sum/reviewers;
        averageRatingCalculated= Math.round(averageRatingCalculated * 10f) /10f;
       System.out.println(averageRatingCalculated);
        doScroll(5000);
    }

    public boolean verifyAverageRating() {
        String s=averageRatingDisplayed.getText();
        Float averageRating=Float.parseFloat(s);
        System.out.println(averageRating);
        return averageRating==averageRatingCalculated;
    }

    public void clickOnAllReviews() {
        switchHandles();
        doScroll(2000);
        viewAllReviews.click();
    }
    WebElement ratingOption;
    Character rating;
    public void reviewBasedOnRating(String rate) {
        ratingDropdown.click();
        ratingOption=driver.findElement(By.xpath(String.format("//div[@class='dropdown-filter-item']/span[contains(text(),'%s')]",rate)));
        rating=ratingOption.getText().charAt(0);
        ratingOption.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isRatingFilterApplied() {
            List<WebElement> filteredRating = driver.findElements(By.xpath("//div[@class='user-review-starWrapper']"));
            for (WebElement w : filteredRating) {
                if (w.getText().charAt(0) != (rating)) {
                    return false;
                }
                System.out.println(w.getText().charAt(0));
            }
            return true;
        }
}
