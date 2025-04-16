package Contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.CampLookUpImage;
import Object_Repo.CampValidation;
import Object_Repo.ContactLookUpImage;
import Object_Repo.ContactValidate;
import Object_Repo.CreateCampPage;
import Object_Repo.CreateContactPage;
import Object_Repo.CreateProductPage;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;
import Object_Repo.ProductLookUpImg;
import Object_Repo.ProductValidation;

public class CreateContactsTest extends BaseClass { // working 
	
	
	
	
	// eng 1
	
	@Test (groups = {"regressionTest", "sanityTest"})
	public void createContactsTest() throws Throwable {
		

		Excel_Utility elib = new Excel_Utility();

		Java_Utility jlib = new Java_Utility();

		WebDriver_Utility wlib = new WebDriver_Utility();

//		File_Utility flib = new File_Utility();
//
//		//String BROWSER = flib.getKeyAndValuePair("browser");
//		String URL = flib.getKeyAndValuePair("Url");
//		String USERNAME = flib.getKeyAndValuePair("Username");
//		String PASSWORD = flib.getKeyAndValuePair("Password");

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
//		wlib.waitElementsToLoad(driver);
//
//		driver.get(URL);
//
//		LoginPage loginPage = new LoginPage(driver);
//
//		loginPage.loginIntoApp(USERNAME, PASSWORD);

		// home page contact

		HomePage homePage = new HomePage(driver);

		homePage.clickContactLink();
		
		// lookup image

		//driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();
		
		ContactLookUpImage lookupCont = new ContactLookUpImage(driver);
		
		lookupCont.clickContactLookUp();
		
		//Assert.fail("---failing the script-----");
		
		// create contact page--
		
		// dropdown-- 
		
//		WebElement ele = driver.findElement(By.xpath("//select[@name='salutationtype']"));
//
//		wlib.dropDown(ele, "Mrs.");
//		
		CreateContactPage contactDetails = new CreateContactPage(driver);
		
		contactDetails.selectDropDownValue(driver);
		
		// or
		
		// driver.findElement(By.xpath("//option[contains(@value,'Mrs.')]")).click();

		int ranNum = jlib.getRandomNum();

		String FirstName = elib.getExcelData("Contacts", 0, 0) + ranNum;
		
		System.out.println("First Name : "+FirstName);

		// driver.findElement(By.name("firstname")).sendKeys(FirstName);

		String LastName = elib.getExcelData("Contacts", 1, 0) + ranNum;
		
		System.out.println("Last Name :"+LastName);

		//driver.findElement(By.name("lastname")).sendKeys(LastName);
		
		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		contactDetails.contactDetails(FirstName, LastName);
		
		contactDetails.saveButtonContact();
		
		// validation

//		String actFirstName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
//
//		if (actFirstName.contains(FirstName)) {
//			System.out.println("contact first name is created");
//		} else {
//			System.out.println("contact first name is not created");
//		}

	
		
		
//		String actLastName = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
//
//		if (actLastName.contains(LastName)) {
//			System.out.println("contact last name is created");
//		} else {
//			System.out.println("contact last name is not created");
//		}

		ContactValidate validateContact = new ContactValidate(driver);
		
		String actData = validateContact.validateContactFirstName(driver, FirstName);
		
		//SoftAssert soft = new SoftAssert();
		
		//soft.assertEquals(actData,FirstName);
		
		System.out.println("assert pas");
		
		validateContact.validateContactLastName(driver, LastName);
		
		
		
		
		
		
		
		
		
		// signout

		//homePage.clickSignOut();
		
		//-----------------------------------------------------------
		
		
		
		
				
		

	}

}
