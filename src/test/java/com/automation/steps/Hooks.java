package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
    @Before
    public void setup(Scenario sc){
        CucumberReportManager.initScenario(sc);
        ConfigReader.initConfig();
        DriverManager.initDriver();
    }

    @After
    public void cleanup(){

       // DriverManager.getDriver().quit();
    }

//    @After
//    public void cleanup(Scenario sc){
//        if (sc.isFailed()){
//            CucumberReportManager.attachScreenShot();
//            sc.log("Failed Page");
//        }else{
//            CucumberReportManager.attachScreenShot();
//            sc.log("End page");
//        }
//        DriverManager.getDriver().quit();
//    }



}
