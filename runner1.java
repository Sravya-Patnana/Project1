package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "Features",
glue = "Stepdefinition",
tags = "@E2ETest",
plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
monochrome = true,
dryRun = false)

public class runner1 {

}
