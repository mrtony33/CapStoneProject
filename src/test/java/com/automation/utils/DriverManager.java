package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {
    static WebDriver webDriver;
    static AppiumDriver androidDriver;

    public static void initDriver() {
        if (ConfigReader.getProperty("automation.type").equals("web")) {
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        else{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", ConfigReader.getProperty("platform.name"));
            capabilities.setCapability("deviceName", ConfigReader.getProperty("device.name"));
            capabilities.setCapability("automationName", ConfigReader.getProperty("automation.name"));
            capabilities.setCapability("app", ConfigReader.getProperty("app.path"));
            capabilities.setCapability("appActivity", ConfigReader.getProperty("app.activity"));
            capabilities.setCapability("appPackage", ConfigReader.getProperty("app.package"));
            androidDriver = new AndroidDriver(capabilities);
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }

    }
    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public static AppiumDriver getAndroidDriver() {
        return androidDriver;
    }
}
