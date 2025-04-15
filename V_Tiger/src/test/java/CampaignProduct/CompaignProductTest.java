package CampaignProduct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import Object_Repo.SwitchingWindowPage;

public class CompaignProductTest extends BaseClass { // working
	
	
	@Test
	public void compaignProductTest() throws FileNotFoundException, Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();

		Excel_Utility elib = new Excel_Utility();

		Java_Utility jLib = new Java_Utility();

//		File_Utility fLib = new File_Utility();
//
//		//String BROWSER = fLib.getKeyAndValuePair("browser");
//
//		String URL = fLib.getKeyAndValuePair("Url");
//
//		String USERNAME = fLib.getKeyAndValuePair("Username");
//
//		String PASSWORD = fLib.getKeyAndValuePair("Password");

//		WebDriver driver;
//
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}

//		wlib.maximizeWindow(driver);
//
//		wlib.waitElementsToLoad(driver);
//
//		driver.get(URL);
//
//		LoginPage loginPage = new LoginPage(driver);
//
//		loginPage.loginIntoApp(USERNAME, PASSWORD);

		// home page

		// driver.findElement(By.linkText("Products")).click();
		
		HomePage homePage = new HomePage(driver);

		homePage.clickProdLink();
		
		// lookup image
		
	//	driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
		
		ProductLookUpImg lookUp = new ProductLookUpImg(driver);
		
		lookUp.clickProductLookUp();
		
		
		int ranNum = jLib.getRandomNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;

		System.out.println("Product name : " + prdName);
		
		// create product page
//
//		driver.findElement(By.name("productname")).sendKeys(prdName);
//
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreateProductPage productDetails = new CreateProductPage(driver);	
		
		productDetails.productDetails(prdName);

//------------------------------------------------------------------------------------------
		// homepage campaign

		homePage.clickCampLink();
		
		// camp lookup

		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		CampLookUpImage lookUp1 = new CampLookUpImage(driver);

		lookUp1.clickCampLookUp();
				

		String CampName = elib.getExcelData("Product", 1, 0) + ranNum;

		System.out.println("Campaign name : " + CampName);
		
		

		// driver.findElement(By.name("campaignname")).sendKeys(CampName);
		
		CreateCampPage campDetails = new CreateCampPage(driver);
		
		campDetails.campName(CampName);
		

		//driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
		campDetails.clickProductPlusSign();
		
		
		
		wlib.windowSwitching(driver, "Products&action");
		
		// switching window
		
//		driver.findElement(By.name("search_text")).sendKeys(prdName);
//
//		driver.findElement(By.cssSelector("[name=\"search\"]")).click();
//
//		Thread.sleep(2000);
//
//		// driver.findElement(By.xpath("//a[text()='Puma']")).click();
//
//		// Dynamic Xpath
//
//		driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
		
		
		SwitchingWindowPage switching = new SwitchingWindowPage(driver);
		
		switching.searchProductName(prdName);
		
		switching.dynamicXpath(driver, prdName);

		// -------------------------------------------------------------------------------------------------

		wlib.windowSwitching(driver, "Campaigns&action");
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//---------------------------------------------------------------------------

		// validate camp
		
//		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
//
//		if (actData.equals(CampName)) {
//
//			System.out.println("Campaign name is created");
//		} else {
//			System.out.println("Campaign name is not created");
//		}
		
		CampValidation validateCamp = new CampValidation(driver);
		
		validateCamp.validateCamp(driver, CampName);

		//------------------------------------------------------------------------------
		
		// validate Product
		
//		String actPrd1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
//
//		if (actPrd1.equals(prdName)) {
//
//			System.out.println("product name is created");
//		} else {
//			System.out.println("product name is not created");
//		}
		
			
		validateCamp.validateProductForCamp(driver, prdName);
		
		Thread.sleep(2000);
		
		// signout

		//homePage.clickSignOut();
		
		

	}

}
