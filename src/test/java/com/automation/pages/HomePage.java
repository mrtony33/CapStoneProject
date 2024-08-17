package com.automation.pages;

import com.automation.utils.ConfigReader;

public class HomePage extends BasePage{
    public void openWebsite() {
        driver.get(ConfigReader.getProperty("base.url"));
    }
}
