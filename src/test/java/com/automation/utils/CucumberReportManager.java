package com.automation.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberReportManager {
    static Scenario scenario;
    public static void initScenario(Scenario sc){
        scenario=sc;
    }

    public static void attachScreenShot(){
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","screenshot");
    }
}

