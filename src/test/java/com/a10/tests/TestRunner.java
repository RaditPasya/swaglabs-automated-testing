package com.a10.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/a10",
        glue = {"com.a10.steps.API", "com.a10.steps.Automation"}, // Update the glue option
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner {
}
