package com.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;  
public class PropertyFileReader 
{  
	public static String Chrome_Download_Path;
	public static String Path_TestData;
	public static String Page_Url;
	public static String PDFUrl;
	public static String Test_Data_Sample;
	public static String AutomationPracticeURL;
	public static String ScreenShotPath;
	public static String JSONFilePath;
	public static String JiraUrl;
	public static String JiraUsername;
	public static String JiraAPIToken;
	public static String JiraProjectName;
	public static String JiraReporterName;
	public static String VBSFilePath;
	
	/**********************************************************************************
	 **Read Property File & Store the values to static variables
	 **********************************************************************************/
	public static void ReadPropertiesFile()
	{
		try
		{
			Properties p = new Properties();
			InputStream fis = new FileInputStream("config.properties");
		    p.load(fis);
		    Path_TestData = p.getProperty("Path_TestData");
			Page_Url =p.getProperty("Page_Url");
			Chrome_Download_Path=p.getProperty("Chrome_Download_Path");
			PDFUrl=p.getProperty("PDFUrl");
			Test_Data_Sample=p.getProperty("Test_Data_Sample");
			AutomationPracticeURL=p.getProperty("AutomationPracticeURL");
			ScreenShotPath=p.getProperty("ScreenShotPath");
			JSONFilePath=p.getProperty("JSONFilePath");
			JiraUrl=p.getProperty("JiraUrl");
			JiraUsername=p.getProperty("JiraUsername");
			JiraAPIToken=p.getProperty("JiraAPIToken");
			JiraProjectName=p.getProperty("JiraProjectName");
			JiraReporterName=p.getProperty("JiraReporterName");
			VBSFilePath=p.getProperty("VBSFilePath");
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	/**********************************************************************************
	 **Getter and Setter Methods for Property File Values
	 **********************************************************************************/

	public static String getChrome_Download_Path() {
		return Chrome_Download_Path;
	}


	public static void setChrome_Download_Path(String chrome_Download_Path) {
		Chrome_Download_Path = chrome_Download_Path;
	}


	public static String getPath_TestData() {
		return Path_TestData;
	}


	public static void setPath_TestData(String path_TestData) {
		Path_TestData = path_TestData;
	}


	public static String getPage_Url() {
		return Page_Url;
	}


	public static void setPage_Url(String page_Url) {
		Page_Url = page_Url;
	}


	public static String getPDFUrl() {
		return PDFUrl;
	}


	public static void setPDFUrl(String pDFUrl) {
		PDFUrl = pDFUrl;
	}


	public static String getTest_Data_Sample() {
		return Test_Data_Sample;
	}


	public static void setTest_Data_Sample(String test_Data_Sample) {
		Test_Data_Sample = test_Data_Sample;
	}


	public static String getAutomationPracticeURL() {
		return AutomationPracticeURL;
	}


	public static void setAutomationPracticeURL(String automationPracticeURL) {
		AutomationPracticeURL = automationPracticeURL;
	}


	public static String getScreenShotPath() {
		return ScreenShotPath;
	}


	public static void setScreenShotPath(String screenShotPath) {
		ScreenShotPath = screenShotPath;
	}


	public static String getJSONFilePath() {
		return JSONFilePath;
	}


	public static void setJSONFilePath(String jSONFilePath) {
		JSONFilePath = jSONFilePath;
	}
	}