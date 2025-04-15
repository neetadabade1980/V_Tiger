package DDT;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadi_1 {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.prokabaddi.com/standings");
		
		WebElement hariyana = driver.findElement(By.xpath("//p[text()='Haryana Steelers']"));
		
		
		WebElement hariyanaWon = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-won'] "));
		
		WebElement hariyanaLost = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-lost'] "));
		
		WebElement hariyanaDraw = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data matches-draw'] "));
		
		WebElement hariyanaPoints = driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class='row-head']//div[@class='table-data points'] "));
		
		System.out.println("Team name :=" +hariyana.getText());
		
		System.out.println("Team Won  :=" +hariyanaWon.getText());
		
		System.out.println("Team lost :=" +hariyanaLost.getText());
		
		System.out.println("Team Draw :=" +hariyanaDraw.getText());
		
		System.out.println("Team points :=" +hariyanaPoints.getText());
		
		
		
		
		
		

	}

}
