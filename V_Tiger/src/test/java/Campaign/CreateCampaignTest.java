package Campaign;

import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.CampLookUpImage;
import Object_Repo.CampValidation;
import Object_Repo.CreateCampPage;
import Object_Repo.CreateProductPage;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;
import Object_Repo.ProductLookUpImg;
import Object_Repo.ProductValidation;
@Listeners(Generic_Utilities.ExtentReportImp.class)
public class CreateCampaignTest extends BaseClass{ // ------------working
	
	
	@Test (retryAnalyzer = Generic_Utilities.RetryImp.class)
	public  void createCampaignNameTest() throws Throwable	{

		WebDriver_Utility wlib = new WebDriver_Utility();

		Excel_Utility elib = new Excel_Utility();

		Java_Utility jLib = new Java_Utility();

				
		// home page campaign

		HomePage homePage = new HomePage(driver);

		homePage.clickCampLink();

		// LookUp Image

		// driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		CampLookUpImage lookUp = new CampLookUpImage(driver);

		lookUp.clickCampLookUp();
		
		//Assert.fail("---failing the script-----");

		int ranNum = jLib.getRandomNum();

		String campName = elib.getExcelData("Product", 1, 0) + ranNum;

		System.out.println(" Campaign name :"+campName);

		// Camp Page

//		driver.findElement(By.name("campaignname")).sendKeys(excelData);
//		
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		CreateCampPage campDetails = new CreateCampPage(driver);

		campDetails.campDetails(campName);
		
	//	Assert.assertEquals(true, false);

		// validation

//		String actData = driver.findElement(By.id("dtlview_Campaign Name")).getText();
//
//		if (actData.contains(excelData)) {
//
//			System.out.println("Campaign Name is Created");
//		}
//
//		else {
//
//			System.out.println("Campaign Name is not Created");
//		}

		CampValidation validate = new CampValidation(driver);
		
		//validate.validateCamp(driver, excelData);
		
		  String actData = validate.validateCamp(driver, campName);
		  
		  Assert.assertEquals(actData, campName);
		  
		  System.out.println("Assert Pass");
		  
		  
		// signout

		//homePage.clickSignOut();

	}
	
	//-------------------------------------------------------------------
	
	

}
