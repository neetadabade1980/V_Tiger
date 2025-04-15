package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUpImage {

	// initializing element 
	
	public CampLookUpImage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	// element declaration
	
	@FindBy (xpath="//img[@alt='Create Campaign...']")
	
	private WebElement lookUpImg;
	
	public WebElement getLookUpImg() {
		
		return lookUpImg;
	}
	
	public void clickCampLookUp() {
		
		lookUpImg.click();
	}
	
	
	
	
	
}
