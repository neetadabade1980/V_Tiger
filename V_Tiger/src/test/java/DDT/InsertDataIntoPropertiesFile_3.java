package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataIntoPropertiesFile_3 {

	public static void main(String[] args) throws IOException {
		
		Properties pro = new Properties();
		
		pro.setProperty("browser", "chrome");
		
		pro.setProperty("url","http://localhost:8888");
		
		pro.setProperty("username", "admin");
		
		pro.setProperty("password","admin");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/InsertData.properties");
		
		pro.store(fos,"Storing Data");
		
		//__________________________________________________________________________
		
		FileInputStream fis = new FileInputStream("./src/test/resources/InsertData.properties");
		
		//	Properties pro = new Properties();
			pro.load(fis);

			String BROWSER = pro.getProperty("browser");
			String URL = pro.getProperty("url");
			String USERNAME = pro.getProperty("username");
			String PASSWORD = pro.getProperty("password");

			WebDriver driver;

			if (BROWSER.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (BROWSER.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else {
				driver = new ChromeDriver();
			}
			
			driver.get(URL);		
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
	
	}

}
