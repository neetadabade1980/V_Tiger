package CreateProduct;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.CreateProductPage;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;
import Object_Repo.ProductLookUpImg;
import Object_Repo.ProductValidation;

public class CreateProductTest  extends BaseClass{ //---------- working--pass
	
	@Test	(groups ="sanityTest")
	public void createProductTest()throws Throwable{

	

		WebDriver_Utility wlib = new WebDriver_Utility();

		Excel_Utility elib = new Excel_Utility();

		Java_Utility jLib = new Java_Utility();

//		File_Utility fLib = new File_Utility();
//
//		String BROWSER = fLib.getKeyAndValuePair("browser");
//
//		String URL = fLib.getKeyAndValuePair("Url");
//
//		String USERNAME = fLib.getKeyAndValuePair("Username");
//
//		String PASSWORD = fLib.getKeyAndValuePair("Password");
//
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
//
//		wlib.maximizeWindow(driver);
//
//		wlib.waitElementsToLoad(driver);
//
//		driver.get(URL);
//
//		LoginPage loginPage = new LoginPage(driver);
//
//		// Business logic
//
//		loginPage.loginIntoApp(USERNAME, PASSWORD);

		// home page product
		
		// driver.findElement(By.linkText("Products")).click();
		
		HomePage homePage = new HomePage(driver);

		homePage.clickProdLink();
		
		// lookup img

		// driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
		
		ProductLookUpImg lookUpProd = new ProductLookUpImg(driver);
		
		lookUpProd.clickProductLookUp();

		int ranNum = jLib.getRandomNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		
		System.out.println(prdName);
		
		// create prod page
//
//		driver.findElement(By.name("productname")).sendKeys(prdName);
//
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreateProductPage prodDetails = new CreateProductPage(driver);
		
		prodDetails.productDetails(prdName);
		
		Thread.sleep(2000);
			
		
		// validate

//		String actData = driver.findElement(By.id("dtlview_Product Name")).getText();
//
//		if (actData.contains(prdName)) {
//
//			System.out.println("Product Name is Created");
//		}
//
//		else {
//
//			System.out.println("Product Name is not Created");
//		}
		
		
		ProductValidation validateProd = new ProductValidation(driver);
		
		validateProd.validateProduct(driver, prdName);
		
		// signout
		
		//homePage.clickSignOut();

	}
	
	

}
