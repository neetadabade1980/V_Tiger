package DDT;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fliplart_IPhone_Ass {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.name("q")).sendKeys("iphones");
		
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		
		List<WebElement> List	=driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		
		for (int i = 0; i < List.size(); i++) {
			
								
			System.out.println(List.get(i).getText());
			
			}
		
		

	}
	

}
