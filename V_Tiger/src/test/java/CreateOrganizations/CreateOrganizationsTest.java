package CreateOrganizations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import Object_Repo.CreateOrgPage;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;
import Object_Repo.OrgLookUpImage;
import Object_Repo.OrgValidate;

public class CreateOrganizationsTest extends BaseClass { //------------working 
	
	@Test (groups ="smokeTest")
	public void createOrganizationsTest()throws Throwable{

	
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

//		driver.get(URL);
//		wlib.maximizeWindow(driver);
//		wlib.waitElementsToLoad(driver);
//
//		LoginPage loginPage = new LoginPage(driver);
//
//		// Business logic
//
//		loginPage.loginIntoApp(USERNAME, PASSWORD);

		// home page organization

		HomePage homePage = new HomePage(driver);

		homePage.clickOrgLink();

		// driver.findElement(By.linkText("Organizations")).click();
		
		// lookup image

	//	driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		
		OrgLookUpImage orgLookUp = new OrgLookUpImage(driver);
		
		orgLookUp.clickOrglookUpImg();

		// To avoid Duplicates

		int ranNum = jLib.getRandomNum();
		
		// create page

		String orgName = elib.getExcelData("Organizations", 0, 0) + ranNum;
		
		System.out.println(orgName);

	//	driver.findElement(By.name("accountname")).sendKeys(orgName);		

		String phnNum = elib.getExcelDataUsingFormatter("Organizations", 1, 0);

		//driver.findElement(By.id("phone")).sendKeys(phnNum);
		
		String emailId = elib.getExcelDataUsingFormatter("Organizations", 2, 0);
		
		//driver.findElement(By.id("email1")).sendKeys(emailId);
		
		CreateOrgPage orgDetails = new CreateOrgPage(driver);
		
		orgDetails.enterOrgDetails(orgName, phnNum, emailId);
		
		// save page

		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		orgDetails.clickSaveButton();

		Thread.sleep(3000);

		// validation
		
//		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
//
//		if (actData.contains(orgName))
		{
//			System.out.println("Organization name is created");
//		}
//
//		else {
//			System.out.println("Organization name is not created");
//		}

		OrgValidate validate = new OrgValidate(driver);
		
		validate.ValidateOrganisation(driver, orgName);
		
		Thread.sleep(3000);
		
		// signout

		//homePage.clickSignOut();


		}
	}
	
}

