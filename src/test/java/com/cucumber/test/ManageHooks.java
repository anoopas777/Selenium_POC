package com.cucumber.test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.constants.CommonFunctions;
import com.constants.PropertyFileReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ManageHooks extends CommonFunctions {
	
	//Hooks are defined to control the execution
	
	static public File dest;
	
	//Define driver, load property file, create screenshot folder
	@Before
	public void setup()
	{
		driver=CommonFunctions.getDriver();
		PropertyFileReader.ReadPropertiesFile();
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss a");
		String time = dateFormat.format(now);
		dest = new File(PropertyFileReader.ScreenShotPath+"\\"+time);
		boolean bool = dest.mkdir();  
	      if(bool){  
	         System.out.println("ScreenShot Folder is created successfully");  
	      }else{  
	         System.out.println("Error Found!");  
	      } 
	}
	
	//Take screenshot on failure
	@After
	public void tearDownAndScreenshotOnFailure(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
		final byte[] ts = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(ts, "image/png", "screenshot");
		driver.quit();
		}
		}

	//Take Screenshot after every step
	@AfterStep
	public void takeScreenshot() throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
        Date date = new Date();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(dest+"\\"+dateFormat.format(date)+".png"));
	}
}
