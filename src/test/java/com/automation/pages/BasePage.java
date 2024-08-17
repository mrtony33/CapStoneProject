package com.automation.pages;


import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    JavascriptExecutor jse;
    WebDriver driver;
    BasePage(){
        driver=DriverManager.getDriver();
        ConfigReader.initConfig();
        PageFactory.initElements(driver,this);
        jse = (JavascriptExecutor)driver;
    }

    public boolean isDisplayed(WebElement element){
        try {
            if (element!=null){
                return true;
            }
        }catch (Exception ignored){
        }
        return false;
    }

    public void doScroll(int distance){
        jse.executeScript(String.format("window.scrollBy(0,%d)",distance));
    }


}
