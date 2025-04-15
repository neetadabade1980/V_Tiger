package DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderCreateContact { // working

	@Test(dataProvider = "getData")
	public void createContact(String firstname, String lastname) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();

		driver.findElement(By.name("firstname")).sendKeys(firstname);

		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] objArr = new Object[4][2];

		objArr[0][0] = "Test10";

		objArr[0][1] = "test11";

		objArr[1][0] = "Test12";

		objArr[1][1] = "Test13";

		objArr[2][0] = "Test14";

		objArr[2][1] = "Test15";

		objArr[3][0] = "Test16";

		objArr[3][1] = "Test17";

		return objArr;

	}

}
