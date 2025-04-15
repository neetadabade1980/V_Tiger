package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchingWindowPage {
	
	
	public SwitchingWindowPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy (name ="search_text")
	private WebElement searchProd;
	
	@FindBy (css = "[name=\"search\"]")	
	private WebElement searchBar;
	
	
	// methods
	
	public void searchProductName(String name) {
		
		searchProd.sendKeys(name);
		searchBar.click();
		
	}
	
	
	public void dynamicXpath(WebDriver driver, String prdName) {
		
		
		driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
	}
	

}
