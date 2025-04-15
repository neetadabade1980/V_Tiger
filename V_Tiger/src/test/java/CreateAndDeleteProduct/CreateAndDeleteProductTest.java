package CreateAndDeleteProduct;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
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
import Object_Repo.DeleteProduct;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;
import Object_Repo.ProductLookUpImg;
import Object_Repo.ProductValidation;

public class CreateAndDeleteProductTest extends BaseClass { // working

	@Test
	public void createAndDeleteProductTest() throws Throwable {
	

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
//		// Business logic
//
//		loginPage.loginIntoApp(USERNAME, PASSWORD);

		// home page product

		HomePage homePage = new HomePage(driver);

		// driver.findElement(By.linkText("Products")).click();

		homePage.clickProdLink();

		// lookup image

		// driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();

		ProductLookUpImg lookUpProduct = new ProductLookUpImg(driver);

		lookUpProduct.clickProductLookUp();

		int ranNum = jLib.getRandomNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;

		System.out.println(prdName);

		// product page

		// driver.findElement(By.name("productname")).sendKeys(prdName);

		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); //
		// save

		CreateProductPage prodDetails = new CreateProductPage(driver);

		prodDetails.productDetails(prdName);

		// validate

//		String actData = driver.findElement(By.id("dtlview_Product Name")).getText();
//
//		if (actData.contains(prdName)) {
//
//			System.out.println("Product is created");
//		} else {
//
//			System.out.println("Product is not  created");
//		}

		ProductValidation validateProd = new ProductValidation(driver);

		validateProd.validateProduct(driver, prdName);

		// driver.findElement(By.linkText("Products")).click();

		homePage.clickProdLink();

		// table[@class="lvt small"]//a[text()='Product
		// Name']/../preceding-sibling::td//input[@type="checkbox"]

		// -----delete product

//		driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='"+prdName+"']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
//		
//		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();

		DeleteProduct delete = new DeleteProduct(driver);

		delete.selectProdCheckBox(driver, prdName);
		
		delete.clickDeletePrdButton();
		
		Thread.sleep(3000);

		// handle alert

		// driver.switchTo().alert().accept();

		wlib.alertAccept(driver);
		
		// validate deleted product

//		List<WebElement> allNames = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
//				
//				boolean flag=false;
//				for (WebElement name : allNames)
//				{
//					String actPrd = name.getText();
//					if(actPrd.equals(prdName))
//					{
//					flag=true;
//					break;
//				}
//					}
//				if(flag)
//				{
//					System.out.println("product name is deleted");
//				}
//				else
//				{
//					System.out.println("Product name is not deleted");
//				}
//				
		delete.validateDeleteProduct(driver, prdName);

		Thread.sleep(3000); // imp step

		// signout

		//homePage.clickSignOut();

	}

}
