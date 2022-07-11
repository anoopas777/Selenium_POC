package com.cucumber.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.constants.CommonFunctions;
import com.constants.PropertyFileReader;
import com.constants.ExcelUtils;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class PDFValidationSteps extends CommonFunctions{
	
	// Step definition File for PDF Validations
	
	@Given("^User is opening and validating the PDF file$")
	public void user_downloads_and_validates_the_pdf_generated() throws Throwable {
		try
		{
			PropertyFileReader.ReadPropertiesFile();
			purgeDirectory(PropertyFileReader.Chrome_Download_Path);
			DriverManager(PropertyFileReader.PDFUrl);
			Thread.sleep(2000);
			String FileName=DownloadPDFChrome();
			URL url = new URL("file:///"+PropertyFileReader.Chrome_Download_Path+"/"+FileName+"");
			InputStream is=url.openStream();
			BufferedInputStream fileparse= new BufferedInputStream(is);
			PDDocument document=null;
			document = PDDocument.load(fileparse);
			String pdfContent=new PDFTextStripper().getText(document);
			System.out.println(pdfContent);

			ExcelUtils.setExcelFile(PropertyFileReader.Path_TestData, "Sheet2");
			for(int i=1;i<=ExcelUtils.getExcelWSheet().getLastRowNum();i++)
			{
			String Keyword = ExcelUtils.getCellData(i, 0);
			System.out.println("Excel Data :"+Keyword);
			Assert.assertTrue(pdfContent.contains(Keyword));
			System.out.println("Validated :"+Keyword);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//ExtentReportsClass.getResult("FAILURE");
		}
	}

}
