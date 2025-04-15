package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUpImage {
	
		// initializing element 
	
			public OrgLookUpImage(WebDriver driver) {
				
				PageFactory.initElements(driver,this);
			}
			
			// element declaration
			
			@FindBy (xpath= "//img[@title=\"Create Organization...\"]")
			
			private WebElement orglookUpImg;
			
			
			public WebElement getOrglookUpImg() {
				
				return orglookUpImg;
			}
			
			public void clickOrglookUpImg() {
				
				orglookUpImg.click();
			}
			
			

}
