package com.cucumber.test;

import org.testng.Assert;
import com.constants.CommonFunctions;
//import com.constants.ExtentReportsClass;
import com.pom.UploadFilePOM;
//import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadFileSteps extends CommonFunctions {
	
	//Step Definition file for Upload File Scenario
	
	@Given("^User is on the Monster India Home Page$")
	public void user_is_on_the_Monster_India_Home_Page() throws Throwable {
		try
		{
		DriverManager("https://www.monsterindia.com/seeker/registration");
		Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@When("^User clicks on Upload Resume Link$")
	public void user_clicks_on_Upload_Resume_Link() throws Throwable {
		try {
		Click(UploadFilePOM.FileUpload);
	}
	catch(Exception e)
	{
		throw e;
	}
	}

	@Then("^User upload the resume file$")
	public void user_upload_the_resume_file() throws Throwable {
		try
		{
		Thread.sleep(1000);
		Runtime.getRuntime().exec("C:\\Users\\anooas\\AutoIT\\DocUpload.exe");
		Thread.sleep(2000);
		String MessageBox=GetText(UploadFilePOM.MessageBox);
		if(MessageBox.contains(".docx")||MessageBox.contains(".txt"))
		{
		System.out.println("MessageBox :"+MessageBox);
		}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	
}
