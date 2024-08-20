package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage{
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


    public boolean isPageDisplayed() {
        return isDisplayed(selectSize);
    }
    public void doAddToCart() {
        switchHandles();
        doScroll(300);
        selectSize.click();
        addToCartButton.click();
        if (isDisplayed(goToBag) && isDisplayed(cartIcon)) {
            cartIcon.click();
        }
    }


    public boolean isProductDisplayed() {
        return productTitle.getText().contains("Shoe");
    }

    public void selectAllAvailableSizes() {
        switchHandles();
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
}
