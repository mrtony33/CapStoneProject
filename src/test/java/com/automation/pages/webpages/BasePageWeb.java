package com.automation.pages.webpages;


import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;

public class BasePageWeb {
    WebDriver driver;
    JavascriptExecutor jse;
    BasePageWeb(){
        driver=DriverManager.getWebDriver();
        ConfigReader.initConfig();
        PageFactory.initElements(driver,this);
        jse = (JavascriptExecutor)driver;
    }

    public void switchHandles(){
        Set<String> handles=driver.getWindowHandles();
        if (handles.size()>1){
            String currentHandle=driver.getWindowHandle();
            for (String handle:handles){
                if (!handle.equals(currentHandle)){
                    driver.switchTo().window(handle);
                }
            }
        }else{
            for (String handle: handles) {
                driver.switchTo().window(handle);
            }
        }
    }
    public boolean isDisplayed(WebElement element){
        try {
            if (element.isDisplayed()){
                return true;
            }
        }catch (Exception ignored){
            return false;
        }
        return false;
    }

    public void javascriptClicker(WebElement element){
        jse.executeScript("arguments[0].click()",element);
    }

//    public void doScroll(WebElement element){
//        while (!isDisplayed(element)){
//            jse.executeScript("window.scrollBy(0,75)");
//        }
//    }

    public void doScroll(int distance){
        jse.executeScript(String.format("window.scrollBy(0,%d)",distance));
    }

}
