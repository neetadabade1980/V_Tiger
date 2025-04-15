package Generic_Utilities;

import org.testng.annotations.Test;

import Object_Repo.HomePage;
import Object_Repo.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	
	public WebDriver driver;
	
	public static WebDriver sdriver;
	
  
  @BeforeSuite(groups = {"sanityTest", "regressionTest","smokeTest"})
  public void beforeSuite() {
	  
	  System.out.println("Database Connection");
  }
  
  @BeforeTest (groups = {"sanityTest", "regressionTest","smokeTest"})
  public void beforeTest() {
	  
	  System.out.println("Parallel execution");
  }
  
  //Pull1 changes
  //@Parameters("BROWSER")  //(String BROWSER)
  @BeforeClass(groups = {"sanityTest", "regressionTest","smokeTest"})
  
  public void beforeClass() throws Throwable {
	  
	   	File_Utility fLib = new File_Utility();
	   	
		String BROWSER = fLib.getKeyAndValuePair("browser");
		
		System.out.println("Launching Browser");
	  
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		sdriver=driver;
	  
	    Thread.sleep(2000);
  }
  
  
//  @Parameters({"URL", "USERNAME","PASSWORD"}) //(String URL,String USERNAME, String PASSWORD  )
  @BeforeMethod (groups = {"sanityTest", "regressionTest","smokeTest"})
  
  public void beforeMethod() throws Throwable {
	  
	  WebDriver_Utility wlib = new WebDriver_Utility();
	  
	  File_Utility fLib = new File_Utility();

		String URL = fLib.getKeyAndValuePair("Url");

		String USERNAME = fLib.getKeyAndValuePair("Username");

		String PASSWORD = fLib.getKeyAndValuePair("Password");

		wlib.maximizeWindow(driver);
		
		wlib.waitElementsToLoad(driver);

		driver.get(URL);
		
		// Business logic

		LoginPage loginPage = new LoginPage(driver);

		loginPage.loginIntoApp(USERNAME, PASSWORD);
	  
		System.out.println("Login into Application");
	  
  }

  @AfterMethod (groups = {"sanityTest", "regressionTest","smokeTest"})
  public void afterMethod() {
	  
	  HomePage homePage = new HomePage(driver);
	  
	  homePage.clickSignOut();
	  
	  System.out.println("Logout from Application");
  }

  

  @AfterClass (groups = {"sanityTest", "regressionTest","smokeTest"})
  public void afterClass() {
	  
	  driver.quit();
	  System.out.println("Close the Browser");
  }

 

  @AfterTest (groups = {"sanityTest", "regressionTest","smokeTest"})
  public void afterTest() {
	  
	  System.out.println("Parallel Excecution close");
  }

  

  @AfterSuite (groups = {"sanityTest", "regressionTest","smokeTest"})
  public void afterSuite() {
	  
	  System.out.println("Close Database Connection");
  }

}
