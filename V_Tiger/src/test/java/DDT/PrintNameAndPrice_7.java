package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PrintNameAndPrice_7 {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Flipkart.properties");
		
		Properties pro = new Properties();
		
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
		
		String URL = pro.getProperty("Url");

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
			
			driver.findElement(By.name("q")).sendKeys("Bluetooth");
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
					
			List<WebElement> nameBluetooth = driver.findElements(By.xpath("//a[@class='wjcEIp']"));
		
			System.out.println("Name of the bluetooth: " +nameBluetooth.size());
			
			System.out.println("----------------------------------------------------");
			
					
			List<WebElement> priceBluetooth = driver.findElements(By.xpath("//div[@class='Nx9bqj']"));
			
			System.out.println("Price of the bluetooth: " +priceBluetooth.size());
			
			System.out.println("----------------------------------------------------");
			
					
			for (int i = 0; i < nameBluetooth.size(); i++) {
				
				System.out.println(nameBluetooth.get(i).getText() + "---------------" +priceBluetooth.get(i).getText());
				
				
			}
		
		
				
	}

	}


