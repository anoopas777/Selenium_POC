package com.constants;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsClass {
	public static ExtentReports extent;
	public static ExtentTest test;

    
    @BeforeTest
    public static void startReport(String ReportName, String BrowserName)
    {
    	
    	Path currentRelativePath = Paths.get("");

    	String ExtentReportFolder = currentRelativePath.toAbsolutePath().toString() + File.separator
    			+ "ExtentReport" + File.separator;

        extent = new ExtentReports(ExtentReportFolder +"/test-output/"+ReportName+".html", true);
        extent
        .addSystemInfo("Host Name", "Anoop's Laptop")
        .addSystemInfo("Environment", "AXATest")
        .addSystemInfo("Browser ", BrowserName)
        .addSystemInfo("User Name", "Anoop A S");
        extent.loadConfig(new File(ExtentReportFolder+"\\extent-config.xml"));
    }
    
    @AfterMethod
    public static void getResult(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL, result.getThrowable());
             
        }
        extent.endTest(test);
    }
     
    @AfterTest
    public static void endreport()
    {
        extent.flush();
        
    }
    
}
