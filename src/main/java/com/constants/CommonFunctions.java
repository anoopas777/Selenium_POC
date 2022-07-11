package com.constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

	protected static WebDriver driver;
	
/**********************************************************************************
	 **CHROME BROWSER DECLARATION
**********************************************************************************/

	protected void DriverManager(String url)
	{
		try {
			System.out.println("Chrome Browser Environment Created");
			System.out.println("________________________________________");
			Path currentRelativePath = Paths.get("");
			String pathToDriver = currentRelativePath.toAbsolutePath().toString() + File.separator + "DriverExe"+ File.separator;
			String downloadFilepath = PropertyFileReader.Chrome_Download_Path;
			System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");

			Map<String, Object> pref = new HashMap<String, Object>();
			pref.put("credentials_enable_service", false);
			pref.put("profile.password_manager_enabled", false);
			pref.put("profile.default_content_setting_values.notifications", 2);
			pref.put("download.default_directory", downloadFilepath);
			pref.put("plugins.always_open_pdf_externally", true);

			options.setExperimentalOption("prefs", pref);


			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
	protected void CloseCurrentWindow()
	{
		driver.close();
		driver.quit();

	}
	
/**********************************************************************************
	 **CHROME BROWSER DOWNLOAD
**********************************************************************************/
	
	protected String DownloadPDFChrome()
	{
		File directoryPath = new File(PropertyFileReader.Chrome_Download_Path);
		//List of all files and directories
		String contents[] = directoryPath.list();
		//System.out.println("List of files and directories in the specified directory:");
		for(int i=0; i<contents.length; i++) 
		{
			System.out.println(contents[i]);
		}
		return contents[0];

	}

	protected void purgeDirectory(String userInput) throws IOException {
		File directory = new File(userInput);
        FileUtils.cleanDirectory(directory);
	}

/**********************************************************************************
	 **CLICK METHODS
**********************************************************************************/
	protected void Click(By by)
	{
		driver.findElement(by).click();

	}

/**********************************************************************************
	 **JS METHODS & JS SCROLL
**********************************************************************************/
	

	protected void JSExecutorClick(By by)
	{
		WebElement wb = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", wb);
	}

/**********************************************************************************
	 **SEND KEYS METHODS /
**********************************************************************************/
	protected void SendKeys(By by,String val) throws InterruptedException
	{
		WebElement wb = driver.findElement(by);
		wb.sendKeys(val);

	}

/**********************************************************************************
	 **ACTION METHODS
**********************************************************************************/
	
	
	public void MoveToElement(By by) throws InterruptedException
	{
		WebElement wb = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wb);
	}


/**********************************************************************************
	 **WAIT METHODS
**********************************************************************************/
	protected void ExplicitWait(By by)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	protected void ImplicitWait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

/**********************************************************************************
	 **OTHER METHODS
**********************************************************************************/
	
	
	protected List<WebElement> selectAllOptions(By by)
	{
		Select select = new Select(driver.findElement(by));
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		return selectedOptions;
	}

	protected String GetText(By quoteNo)
	{
		WebElement wb = driver.findElement(quoteNo);
		String Value=wb.getText();
		return Value;

	}

	protected String GetAttributeValue(By element)
	{
		WebElement wb = driver.findElement(element);
		String val = wb.getAttribute("href");
		return val;

	}
	protected void SwitchTabs()
	{
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}

}
