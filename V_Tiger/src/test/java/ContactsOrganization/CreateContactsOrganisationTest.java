package ContactsOrganization;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.ContactLookUpImage;
import Object_Repo.ContactValidate;
import Object_Repo.CreateContactPage;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;

public class CreateContactsOrganisationTest extends BaseClass{ // need to check--
	
	@Test
	public void createContactsOrganisationTest () throws Throwable{

	
		WebDriver_Utility wlib = new WebDriver_Utility();

		Java_Utility jLib = new Java_Utility();

		Excel_Utility elib = new Excel_Utility();

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
//		wlib.waitElementsToLoad(driver);
//
//		driver.get(URL);
//
//		LoginPage loginPage = new LoginPage(driver);
//
//		loginPage.loginIntoApp(USERNAME, PASSWORD);

		// -----------------------------------------------------------

		// create product

		// home page contact

		HomePage homePage = new HomePage(driver);

		homePage.clickContactLink();

		// driver.findElement(By.linkText("Contacts")).click();
		
		//lookup image Contact

		//driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
		
		ContactLookUpImage lookupCont = new ContactLookUpImage(driver);
		
		lookupCont.clickContactLookUp();

		int ranNum = jLib.getRandomNum();
		
		// dropdown
		
		CreateContactPage contactDetails = new CreateContactPage(driver);
		
		contactDetails.selectDropDownValue(driver);
		

		String firstName = elib.getExcelData("Contacts", 0, 0) + ranNum;

		System.out.println("First Name:" + firstName);

		// ---------------------------------------------------------------

		String lastName = elib.getExcelData("Contacts", 1, 0) + ranNum;

		System.out.println("Last Name:" + lastName);
		
		
//		WebElement ele = driver.findElement(By.name("salutationtype"));
//
//		wlib.dropDown(ele, "Mr.");
//
//		driver.findElement(By.name("firstname")).sendKeys(firstName);
//
//		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
				
		contactDetails.contactDetails(firstName, lastName);
		
		contactDetails.saveButtonContact();
		
		

		driver.findElement(By.xpath("//img[@title=\"Select\"]")).click();

		wlib.windowSwitching(driver, "Accounts&action");

		driver.findElement(By.name("search_text")).sendKeys("ABC");

		driver.findElement(By.cssSelector("[name=\"search\"]")).click();

		Thread.sleep(2000);

		//driver.findElement(By.xpath("//a[text()='Puma']")).click();

		// Dynamic Xpath

		driver.findElement(By.xpath("//a[text()='ABC']")).click();

		// ------------------------------------------------------

		wlib.windowSwitching(driver, "Campaigns&action");
		

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// ------------------------------------------------------------------------

		// validate first name and last name
		
//
//		String actData = driver.findElement(By.id("dtlview_First Name")).getText();
//
//		if (actData.contains(firstName)) {
//
//			System.out.println("First name Created ");
//		} else {
//
//			System.out.println("First name not Created ");
//		}
//		//=================================================================
//		String actData1 = driver.findElement(By.id("dtlview_Last Name")).getText();
//
//		if (actData1.contains(lastName)) {
//
//			System.out.println("Last name Created ");
//		} else {
//
//			System.out.println("Last name not Created ");
//		}

		ContactValidate validateContact = new ContactValidate(driver);
		
		validateContact.validateContactFirstName(driver, firstName);
		
		validateContact.validateContactLastName(driver, lastName);
		
//--------------------------------------------------------------------------------------
		String actData2 = driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=DetailView&record=14\"]"))
				.getTagName();

		if (actData2.contains("ABC")) {

			System.out.println("Organisation name created");
		}

		else {
			System.out.println("Organisation name  Created ");
		}

		
		
		// close the application

		// signout

		homePage.clickSignOut();

	}

}
