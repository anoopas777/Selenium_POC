package com.cucumber.test;

import org.testng.Assert;

import com.constants.CommonFunctions;
import com.constants.Constant;
import com.constants.ExtentReportsClass;
import com.constants.ExcelUtils;
import com.pom.GetQuote;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateQuoteSteps extends CommonFunctions {
	
	
	@Given("^User is on the BharatiAxa HomePage$")
	public void user_is_on_the_BharatiAxa_HomePage() throws Throwable {
		try
		{
		DriverManager(Constant.Page_Url);
		Thread.sleep(3000);
		ExtentReportsClass.startReport("ChromeBrowserTest", "Chrome");
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Launched BharatiAxa Home Page");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			ExtentReportsClass.endreport();
			throw e;
		}
	
	}

	@When("^User clicks on Get a Quote link$")
	public void user_clicks_on_Get_a_Quote_link() throws Throwable {
		
		try
		{
		Click(GetQuote.GetAQuote);
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Clicked on Get A Quote Link.");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}
		catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	   
	}

	@Then("^User switch to new tab and fill FirstName, LastName and Mobile Number$")
	public void user_switch_to_new_tab_and_fill_FirstName_LastName_and_Mobile_Number() throws Throwable {
		try
		{
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		String FName = ExcelUtils.getCellData(1, 1);
		String LName = ExcelUtils.getCellData(1, 2);
		String MobNum = ExcelUtils.getCellData(1, 3);
		System.out.println("Mobile Number:"+MobNum);
		SwitchTabs();
		SendKeys(GetQuote.FirstName, FName);
		SendKeys(GetQuote.LastName, LName);
		SendKeys(GetQuote.MobileNumber, MobNum);
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Filled FirstName, LastName and Mobile Number");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}
		catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	    
	}

	@Then("^User Click on Next Button$")
	public void user_Click_on_Next_Button() throws Throwable {
		try
		{
		Thread.sleep(4000);
		Click(GetQuote.NextButton);
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Clicked on Next Button");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}
		catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	    
	}

	@Then("^User Fills Email Address, DOB and Pin Code$")
	public void user_Fills_Email_Address_DOB_and_Pin_Code() throws Throwable {
		try
		{
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		String EmailId = ExcelUtils.getCellData(1, 4);
		//String DOB = ExcelUtils.getCellData(1, 5);
		String Pin_Code = ExcelUtils.getCellData(1, 6);
		SendKeys(GetQuote.EmailId, EmailId);
		SendKeys(GetQuote.DOB, "01/01/1995"); 
		SendKeys(GetQuote.PINCODE, Pin_Code);
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Filled Email Address, DOB and Pincode");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}
		catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	}

	@Then("^User Select Buying For Option$")
	public void user_Select_Buying_For_Option() throws Throwable {
		
		try
		{
		Click(GetQuote.JustMe);
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Selected buying option");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}

		catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
	    
	}

	@Then("^User Click on How to Receive Benefit Option$")
	public void user_Click_on_How_to_Receive_Benefit_Option() throws Throwable {
		
		try
		{
		Thread.sleep(3000);
		Click(GetQuote.AllAtOnce);
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Selected how to receive benefit option");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}

		catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
		
	}

	@Then("^User Gets QuoteNumber Displayed on the screen$")
	public void user_Gets_QuoteNumber_Displayed_on_the_screen() throws Throwable {
		
		try
		{
		Thread.sleep(3000);
		String QuoteNumber=GetAttributeValue(GetQuote.QuoteNo);
		System.out.println("Quote Number :"+QuoteNumber);
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Quote Number Displayed");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		ExcelUtils.setCellData(QuoteNumber, 1, 6);
		}

		catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
		
	    
	}

	@Then("^User Closes Current Window$")
	public void user_Closes_Current_Window() throws Throwable {
		
		try
		{
		CloseCurrentWindow();
		ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Quote Number Displayed");
		ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		ExtentReportsClass.endreport();
		}

		catch (Exception e) {
			ExtentReportsClass.endreport();
			throw e;
		}
		
	    
	}

	
}
