package com.automation.pages;


import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    BasePage(){
        driver=DriverManager.getDriver();
        ConfigReader.initConfig();
        PageFactory.initElements(driver,this);
    }
}
