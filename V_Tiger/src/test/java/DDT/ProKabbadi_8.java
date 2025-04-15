package DDT;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadi_8 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stu
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.prokabaddi.com/standings");
		
		List<WebElement> team = driver.findElements(By.xpath("//div[@class='table-data team']"));
		
				
		//WebElement Hariyana = driver.findElement(By.xpath("//div[@class='table-data team']/../..//p[text()='Haryana Steelers']"));
	
				
		List<WebElement> won = driver.findElements(By.xpath("//div[@class='table-data matches-won']"));
		
		List<WebElement> lost = driver.findElements(By.xpath("//div[@class='table-data matches-lost']"));
		
		List<WebElement> draw  = driver.findElements(By.xpath("//div[@class='table-data matches-draw']"));
		
		List<WebElement> points  = driver.findElements(By.xpath("//div[@class='table-data points']"));
	
		
		System.out.println("Hariyana Team: =" +team);
		
				
		for (int i = 0; i < team.size(); i++) {
			
			System.out.println(team.get(i).getText()+ "--" +won.get(i).getText()+ "--" +lost.get(i).getText()+ "--" +draw.get(i).getText()+ "--" +points.get(i).getText());
			
			
		}
	
	
	
	
	
	
	
	
	
	}

}
