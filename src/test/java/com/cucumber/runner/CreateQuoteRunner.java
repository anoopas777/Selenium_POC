package com.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Cucumber Runner file for CreateQuote Feature File

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features/CreateQuote.feature"}, 
glue = "com.cucumber.test",
monochrome = true, dryRun=false,
plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		})
public class CreateQuoteRunner {
	


}

