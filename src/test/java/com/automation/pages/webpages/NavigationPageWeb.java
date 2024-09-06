package com.automation.pages.webpages;

import com.automation.pages.interfaces.NavigationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigationPageWeb extends BasePageWeb implements NavigationPage {

    public void clickOnNavigationLink(String nav){
        WebElement navigation= driver.findElement(By.xpath(String.format("//a[@data-group='%s']",nav)));
        navigation.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean isNavigatedPageDisplayed(String nav){
        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);
        return currentUrl.contains(nav);
    }
}
