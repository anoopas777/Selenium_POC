/*package com.cucumber.test;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;

import com.constants.CommonFunctions;
import com.constants.PropertyFileReader;
import com.constants.ExcelUtils;
import com.pom.AxaHomePage;
import com.pom.BuyingForPage;
import com.pom.PersonalDetailsPage1;
import com.pom.PersonalDetailsPage2;
import com.pom.PlanSummaryPage;
import com.pom.ReceiveBenefitsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateQuoteStepseExcel extends CommonFunctions {
	
	
	@Given("^User is on the BharatiAxa HomePage$")
	public void user_is_on_the_BharatiAxa_HomePage() throws Throwable {
		try
		{
		DriverManager(PropertyFileReader.Page_Url);
		//ExtentReportsClass.startReport("ChromeBrowserTest", "Chrome");
		//ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Launched BharatiAxa Home Page");
		//ExtentReportsClass.test.log(LogStatus.PASS, "Assert Pass as condition is True");
		Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			//ExtentReportsClass.test.log(LogStatus.FAIL,ExtentReportsClass.capture(driver,"Failed"));
			//ExtentReportsClass.endreport();
			throw e;
		}
	
	}

	@When("^User fills Firstname, Mobilenumber$")
	public void User_fills_Firstname_Mobilenumber() throws Throwable {
		
		try
		{
		  ExcelUtils.setExcelFile(PropertyFileReader.Path_TestData, "Sheet1");
	      String FName = ExcelUtils.getCellData(1, 1);
		  String MobNum = ExcelUtils.getCellData(1, 3);
		  System.out.println("FName: "+FName);
		  System.out.println("MobNum: "+MobNum);
		  SendKeys(AxaHomePage.FirstName, FName);
		  SendKeys(AxaHomePage.MobileNumber, MobNum);
		  Click(AxaHomePage.BuyNow);
		//ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Clicked on Get A Quote Link.");
		//ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}
		catch (Exception e) {
			//ExtentReportsClass.endreport();
			throw e;
		}
	   
	}

	@Then("^User fill LastName$")
	public void User_fill_LastName() throws Throwable {
		try
		{
		ExcelUtils.setExcelFile(PropertyFileReader.Path_TestData, "Sheet1");
		//String FName = ExcelUtils.getCellData(1, 1);
		String LName = ExcelUtils.getCellData(1, 2);
		//String MobNum = ExcelUtils.getCellData(1, 3);
		//System.out.println("Mobile Number:"+MobNum);
		//SwitchTabs();
		//SendKeys(GetQuote.FirstName, FName);
		SendKeys(PersonalDetailsPage1.LastName, LName);
		//SendKeys(GetQuote.MobileNumber, MobNum);
		//ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Filled FirstName, LastName and Mobile Number");
		//ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}
		catch (Exception e) {
			//ExtentReportsClass.endreport();
			throw e;
		}
	    
	}

	@Then("^User Click on Next Button$")
	public void user_Click_on_Next_Button() throws Throwable {
		try
		{
		Thread.sleep(3000);	
		Click(PersonalDetailsPage1.NextButton);
		//ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Clicked on Next Button");
		//ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}
		catch (StaleElementReferenceException e) {
			//Click(GetQuote.NextButton);
			//ExtentReportsClass.endreport();
			throw e;
		}
	    
	}

	@Then("^User Fills Email Address, DOB and Pin Code$")
	public void user_Fills_Email_Address_DOB_and_Pin_Code() throws Throwable {
		try
		{
		ExcelUtils.setExcelFile(PropertyFileReader.Path_TestData, "Sheet1");
		String EmailId = ExcelUtils.getCellData(1, 4);
		String Pin_Code = ExcelUtils.getCellData(1, 5);
		SendKeys(PersonalDetailsPage2.EmailId, EmailId);
		Click(PersonalDetailsPage2.Calendar);
		Click(PersonalDetailsPage2.OkButton);
		SendKeys(PersonalDetailsPage2.PINCODE, Pin_Code);
		//ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Filled Email Address, DOB and Pincode");
		//ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}
		catch (Exception e) {
			//ExtentReportsClass.endreport();
			throw e;
		}
	}

	@Then("^User Select Buying For Option$")
	public void user_Select_Buying_For_Option() throws Throwable {
		
		try
		{
		Click(BuyingForPage.JustMe);
		//ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Selected buying option");
		//ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}

		catch (Exception e) {
			//ExtentReportsClass.endreport();
			throw e;
		}
	    
	}

	@Then("^User Click on How to Receive Benefit Option$")
	public void user_Click_on_How_to_Receive_Benefit_Option() throws Throwable {
		
		try
		{
		//ExplicitWait(GetQuote.AllAtOnce);
		Thread.sleep(3000);
		Click(ReceiveBenefitsPage.AllAtOnce);
		//ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Selected how to receive benefit option");
		//ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		}

		catch (Exception e) {
			//ExtentReportsClass.endreport();
			throw e;
		}
		
	}

	@Then("^User Gets QuoteNumber Displayed on the screen$")
	public void user_Gets_QuoteNumber_Displayed_on_the_screen() throws Throwable {
		
		try
		{
		ExcelUtils.setExcelFile(PropertyFileReader.Path_TestData, "Sheet1");
		ExplicitWait(PlanSummaryPage.QuoteNo);
		String QuoteNumber=GetText(PlanSummaryPage.QuoteNo);
		String[] Quote=QuoteNumber.split(":");
		System.out.println("Quote Number :"+Quote[1].trim());
		//ExtentReportsClass.test = ExtentReportsClass.extent.startTest("Quote Number Displayed");
		//ExtentReportsClass.test.log(LogStatus.INFO, "Assert Pass as condition is True");
		ExcelUtils.setCellData(Quote[1].trim(), 1, 6);
		}

		catch (Exception e) {
			//ExtentReportsClass.endreport();
			throw e;
		}
		
	    
	    
	}
	

	
}
*/