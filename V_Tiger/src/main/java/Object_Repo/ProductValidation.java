package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductValidation {
	
	
	
	public ProductValidation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void validateProduct(WebDriver driver,String prdName){
		
		
		String actPrd = driver.findElement(By.id("dtlview_Product Name")).getText();

		if (actPrd.equals(prdName)) {
			
				System.out.println("product name is created");
			
		} else 
			
		{
			System.out.println("product name is not created");
		}

	}

}
