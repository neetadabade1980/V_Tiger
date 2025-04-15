package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampValidation {
	
	
	public CampValidation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateCamp(WebDriver driver,String campName){
		
		// assert 
		
		return  driver.findElement(By.id("dtlview_Campaign Name")).getText();
		
	//String actData = driver.findElement(By.id("dtlview_Campaign Name")).getText();

//		if (actData.equals(campName)) {
//			
//			System.out.println("Campaign name is created");
//			
//		} else 
//		
//		{
//			
//			System.out.println("Campaign name is not created");
//		}
	}
	
	
	
	public void validateProductForCamp(WebDriver driver,String prdName){
		
		
		String actPrd = driver.findElement(By.id("dtlview_Product")).getText();

		if (actPrd.equals(prdName)) {
			
				System.out.println("product name is created");
			
		} else 
			
		{
			System.out.println("product name is not created");
		}

	}

}
