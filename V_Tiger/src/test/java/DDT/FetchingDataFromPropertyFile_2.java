package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchingDataFromPropertyFile_2 {

	public static void main(String[] args) throws IOException {
				
				FileInputStream fis = new FileInputStream("./src/test/resources/browser.properties");
			
				Properties pro = new Properties();
				
				pro.load(fis);

				String BROWSER = pro.getProperty("browser");
				String URL = pro.getProperty("Url");
				String USERNAME = pro.getProperty("Username");
				String PASSWORD = pro.getProperty("Password");

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
