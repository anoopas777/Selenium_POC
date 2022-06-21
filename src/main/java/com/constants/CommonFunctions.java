package com.constants;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.relevantcodes.extentreports.LogStatus;

public class CommonFunctions {
	
	WebDriver driver;
	
protected void DriverManager(String url)
{
	try {
		System.out.println("Chrome Browser Environment Created");
		System.out.println("________________________________________");
		Path currentRelativePath = Paths.get("");
		String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverExe"
				+ File.separator;
		System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		options.addArguments("--no-proxy-server");

		Map<String, Object> pref = new HashMap<String, Object>();
		pref.put("credentials_enable_service", false);
		pref.put("profile.password_manager_enabled", false);
		pref.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", pref);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

protected void Click(By by)
{
		driver.findElement(by).click();
		
}

protected void SendKeys(By by,String val) throws InterruptedException
{
		WebElement wb = driver.findElement(by);
		wb.sendKeys(val);
		
}

protected void CloseCurrentWindow()
{
		driver.close();
		driver.quit();
		
}
protected String GetAttributeValue(By quoteNo)
{
		WebElement wb = driver.findElement(quoteNo);
		String Value=wb.getText();
		return Value;
		
}
protected void SwitchTabs()
{
	 	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	 	driver.switchTo().window(tabs2.get(1));
}

}
