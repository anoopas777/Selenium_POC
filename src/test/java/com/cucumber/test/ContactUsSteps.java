package com.cucumber.test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;

import com.constants.CommonFunctions;
import com.constants.PropertyFileReader;
import com.constants.ExcelReader;
import com.pom.ContactUsPage;
import com.pom.UploadFilePOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps extends CommonFunctions {
	
	//Step Definition File for Contact US Page 
	
	ContactUsPage contactUsPage = new ContactUsPage();
	
	@Given("^user navigates to contact us page$")
	public void user_navigates_to_contact_us_page() throws Throwable 
	{
		DriverManager(PropertyFileReader.AutomationPracticeURL);
	}

	@When("^user fills the form from given sheetname \"([^\"]*)\" and rownumber (\\d+)$")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws Throwable {
		try
		{
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData(PropertyFileReader.Test_Data_Sample, sheetName);
		
		String heading = testData.get(rowNumber).get("Subjectheading");
		String email = testData.get(rowNumber).get("Email");
		String orderRef = testData.get(rowNumber).get("Orderref");
		String message = testData.get(rowNumber).get("Message");

		
		Select select = new Select(driver.findElement(ContactUsPage.subjectHeading));
		select.selectByVisibleText(heading);
		driver.findElement(ContactUsPage.email).sendKeys(email);
		driver.findElement(ContactUsPage.orderRef).sendKeys(orderRef);
		driver.findElement(ContactUsPage.messageText).sendKeys(message);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@When("^user clicks on send button$")
	public void user_clicks_on_send_button() throws Throwable {
		
		driver.findElement(ContactUsPage.sendButton).click();

	}

	@Then("^it shows a successful message \"([^\"]*)\"$")
	public void it_shows_a_successful_message(String expSuccessMessage) throws Throwable {
		String actualSuccMessg = driver.findElement(ContactUsPage.successMessg).getText();
		Assert.assertEquals(actualSuccMessg, expSuccessMessage);
		driver.close();
	}

	
}
