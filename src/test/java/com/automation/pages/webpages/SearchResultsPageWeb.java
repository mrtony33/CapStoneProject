package com.automation.pages.webpages;

import com.automation.pages.interfaces.CartPage;
import com.automation.pages.interfaces.SearchResultPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
public class SearchResultsPageWeb extends BasePageWeb implements SearchResultPage {
    @FindBy(xpath = "//li[@class='product-base']")
    List<WebElement> searchResults;
    @FindBy(xpath = "//span[text()='Bag']")
    WebElement cartIcon;
    @FindBy(xpath = "//span[text()='CLEAR ALL']")
    WebElement clearAllFilters;

    String filter;


    CartPage cartPage;

    public SearchResultsPageWeb() {
        if (ConfigReader.getProperty("automation.type").equals("web")){
            cartPage=new CartPageWeb();
        }
    }
    public void selectMany(int totalItemsToBeAdded) {
        for (int i = 0; i < totalItemsToBeAdded; i++) {
            searchResults.get(i).click();
            switchHandles();
            cartPage.getPriceOnProductPage();
            driver.close();
            switchHandles();
        }
    }

    public void clickFirstResult() {
        searchResults.get(0).click();
    }

    public boolean checkResultsPresent() {
        return !searchResults.isEmpty();
    }

    public void goToCart() {
        cartIcon.click();
    }

    WebElement radio;

    public void doFilter(String filterKey) {
        try {
            radio = driver.findElement(By.xpath(String.format("//input[contains(@value,'%s.')]", filterKey)));
        }catch (Exception e){
            radio = driver.findElement(By.xpath(String.format("//input[contains(@value,'%s,')]", filterKey)));
        }
        javascriptClicker(radio);
        filter = filterKey;
    }


    public boolean checkFilterGender() {
        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {
        }
        return radio.isSelected();
    }

    public boolean checkFilterDiscount() {
        int key = Integer.parseInt(filter);
        boolean flag = true;
        if (isDisplayed(clearAllFilters)) {
            for (WebElement i : driver.findElements(By.xpath("//span[@class='product-discountPercentage']"))) {
                int currentDiscount = Integer.parseInt(i.getText().replaceAll("\\D+", ""));
                if (currentDiscount < key) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public void removeFilter() {
        clearAllFilters.click();
    }

    public boolean removeFilterSuccess() {
        try {
            Thread.sleep(3000);
        } catch ( InterruptedException e) {
            throw new RuntimeException(e);
        }
        return !isDisplayed(clearAllFilters);
    }
}
