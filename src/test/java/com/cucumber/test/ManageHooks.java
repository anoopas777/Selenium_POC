package com.cucumber.test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.CommonFunctions;
import com.utils.JiraUtils;
import com.utils.PropertyFileReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestCaseFinished;
import gherkin.formatter.model.Result;  
import org.apache.commons.lang3.reflect.FieldUtils;  
import java.lang.reflect.Field;  
import java.util.ArrayList;

public class ManageHooks extends CommonFunctions {
	
	//Hooks are defined to control the execution
	
	 public static File dest;
	
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
	public void tearDownAndScreenshotOnFailure(Scenario scenario) throws IOException, InterruptedException {
		if (scenario.isFailed()) {
		final byte[] ts = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(ts, "image/png", "screenshot");
		//System.out.println("***>> Scenario '" + scenario.getName() + "' failed at line(s) " + scenario.getLine() + " with status '" + scenario.getStatus() + "'");
		}
		
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
        Date date = new Date();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(dest+"\\"+dateFormat.format(date)+".png"));
        
        //Create Jira Ticket
        //JiraUtils.JiraMain(dest+"\\"+dateFormat.format(date)+".png");
		driver.quit();
		
		//Send email via VBScript Code
		
		 try {
		      Runtime.getRuntime().exec( "wscript "+PropertyFileReader.VBSFilePath+"" );
		   }
		   catch( IOException e ) {
		      System.out.println("Error While Sending the Reports in Email");
		   }
	}
	
	

	//Take Screenshot after every step
	@AfterStep
	public void takeScreenshot() throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
        Date date = new Date();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(dest+"\\"+dateFormat.format(date)+".png"));
	}
}
