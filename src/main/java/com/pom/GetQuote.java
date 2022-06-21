package com.pom;

import org.openqa.selenium.By;

public class GetQuote {
	
	public static By GetAQuote = By.linkText("Get a Quote");
	public static By FirstName = By.id("@PROPOSER_FNAME");
	public static By LastName = By.id("@PROPOSER_LNAME");
	public static By MobileNumber = By.id("@PROPOSER_MOBILE_NO");
	public static By NextButton = By.className("gip-next-button");
	public static By EmailId = By.id("@PROPOSER_EMAIL");
	public static By DOB = By.id("@PROPOSER_DOB");
	public static By PINCODE = By.id("@PROPOSER_PINCODE");
	public static By JustMe = By.className("radio-area-variation-1");
	public static By AllAtOnce = By.xpath("//*[@id=\"1\"]/span[2]/div/div");
	public static By QuoteNo = By.className("quote-no-box");
	
			
}
