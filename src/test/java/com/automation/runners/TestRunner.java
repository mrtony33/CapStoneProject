package com.automation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.automation.steps",
        plugin = "json:cucumber-json/CucumberJsonReport.json"
)

public class TestRunner {
}
