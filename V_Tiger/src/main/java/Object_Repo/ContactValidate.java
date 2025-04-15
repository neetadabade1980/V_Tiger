package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactValidate {

	// elemnet initialisation

	public ContactValidate(WebDriver driver) {

			PageFactory.initElements(driver, this);
		}



	public String  validateContactFirstName(WebDriver driver ,String FirstName) {
			
		String actFirstName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
		
		return   actFirstName;
		
		
//		String actFirstName = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
//							
//	
//	if (actFirstName.contains(FirstName)) {
//		
//		
//		System.out.println("contact first name is created");
//	} 
//	else
//	
//	{
//		System.out.println("contact first name is not created");
//
//	
//	}
		}
		
		
	public void validateContactLastName(WebDriver driver ,String LastName) {
		
		String actLastName = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
	
			if (actLastName.contains(LastName)) {
				
				System.out.println("contact last name is created");
				
				} 
			else 
			
			{
					System.out.println("contact last name is not created");
			}

			
		
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
