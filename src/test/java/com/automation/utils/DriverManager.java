package com.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {
    static WebDriver driver;


    public static void initDriver() {
        if (ConfigReader.getProperty("automation.type").equals("web")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        else{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", ConfigReader.getProperty("platform.name"));
            capabilities.setCapability("deviceName", ConfigReader.getProperty("device.name"));
            capabilities.setCapability("automationName", ConfigReader.getProperty("automation.name"));
            capabilities.setCapability("app", System.getProperty("user.dir")+"/"+ConfigReader.getProperty("app.path"));
            capabilities.setCapability("appActivity", ConfigReader.getProperty("app.activity"));
            capabilities.setCapability("appPackage", ConfigReader.getProperty("app.package"));
            driver = new AndroidDriver(capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }

    }
    public static WebDriver getDriver(){
        return driver;
    }

}
