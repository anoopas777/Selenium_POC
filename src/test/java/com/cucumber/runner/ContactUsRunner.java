package com.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Cucumber Runner file for ContactUS Feature File

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/ContactUS.feature", 
glue = "com.cucumber.test", 
monochrome = true, 
plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		})
public class ContactUsRunner {
	
}

