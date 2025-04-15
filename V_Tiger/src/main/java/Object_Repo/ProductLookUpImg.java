package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUpImg {
	
	
	// initializing element 
	
		public ProductLookUpImg(WebDriver driver) {
			
			PageFactory.initElements(driver,this);
		}
		
		// element declaration
		
		@FindBy (xpath = "//img[@alt='Create Product...']")
		
		private WebElement lookUpImg;
		
		public WebElement getLookUpImg() {
			
			return lookUpImg;
		}
		
		
		// business logic
		
		public void clickProductLookUp() {
			
			lookUpImg.click();
		}
		

}
