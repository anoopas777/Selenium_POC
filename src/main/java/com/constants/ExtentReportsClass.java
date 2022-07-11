//package com.constants;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//public class ExtentReportsClass {
//	public static ExtentReports extent;
//	public static ExtentTest test;
//	public static WebDriver driver;
//    
//	@BeforeTest
//    public static void startReport(String ReportName, String BrowserName)
//    {
//    	
//    	Path currentRelativePath = Paths.get("");
//
//    	String ExtentReportFolder = currentRelativePath.toAbsolutePath().toString() + File.separator
//    			+ "ExtentReport" + File.separator;
//
//        extent = new ExtentReports(ExtentReportFolder +"/test-output/"+ReportName+".html", true);
//        extent
//        .addSystemInfo("Host Name", "Anoop's Laptop")
//        .addSystemInfo("Environment", "AXATest")
//        .addSystemInfo("Browser ", BrowserName)
//        .addSystemInfo("User Name", "Anoop A S");
//        extent.loadConfig(new File(ExtentReportFolder+"\\extent-config.xml"));
//    }
//    
//	@AfterMethod
//    public static void getResult(ITestResult result) throws IOException
//    {
//        if(result.getStatus()==ITestResult.FAILURE)
//        {
//        	String screenShotPath = capture(driver, "screenShotName");
//            test.log(LogStatus.FAIL, result.getThrowable());
//            test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotPath));
//             
//        }
//        extent.endTest(test);
//    }
//     
//
//	@AfterTest
//    public static void endreport()
//    {
//        extent.flush();
//        
//    }
//    
//    public static String capture(WebDriver driver,String screenShotName) throws IOException
//    {
//        TakesScreenshot ts = (TakesScreenshot)driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
//        File destination = new File(dest);
//        FileUtils.copyFile(source, destination);        
//                     
//        return dest;
//    }
//    
//}
