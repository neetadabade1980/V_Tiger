package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUpImage {

	public ContactLookUpImage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	// element declaration
	
		@FindBy (css= "[alt=\"Create Contact...\"]")
		
		private WebElement lookUpImgCont;
		
		
		public WebElement getLookUpImgCont() {
			
			return lookUpImgCont;
		}
		
		public void clickContactLookUp() {
			
			lookUpImgCont.click();
		}
	
	
	
}
