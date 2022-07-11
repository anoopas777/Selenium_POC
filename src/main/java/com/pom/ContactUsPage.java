package com.pom;

import org.openqa.selenium.By;
import com.constants.CommonFunctions;

public class ContactUsPage extends CommonFunctions{
	
	//Objects captured on ContactUs Page

	public static  By subjectHeading = By.id("id_contact");
	public static  By email = By.id("email");
	public static  By orderRef = By.id("id_order");
	public static  By messageText = By.id("message1");
	public static  By sendButton = By.id("submitMessage");
	public static  By successMessg = By.cssSelector("div#center_column p");


}
