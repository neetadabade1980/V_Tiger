package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	// Element Initialization
	
	public  HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
				
	}
	
	// element decration
	
	@FindBy (linkText = "More")
	
	private WebElement moreLink;
	
	@FindBy (linkText = "Campaigns")
	
	private WebElement campLink;
	
	
	// contacts 
	
	@FindBy (linkText= "Contacts")
	
	private WebElement contactLink;
	
	// organization
	
	@FindBy (linkText = "Organizations")
	
	private WebElement orgLink;
	
	// product
	
	@FindBy (linkText = "Products")
	
	private WebElement prodLink;
	
		
	// sign out 
	
	@FindBy (xpath= "//img[@src= 'themes/softed/images/user.PNG']")
	
	private WebElement signOutImage;
	
	@FindBy (linkText = "Sign Out")
	
	private WebElement signOut;
	
		
	
	//getter methods
	
	public WebElement getMoreLink() {
		
		return moreLink;
	}
	
	public WebElement getCampLink() {
		
		return campLink;
	}
	
		
	// business logic 
	
	/*
	 * This is methos to use campaign link
	 * 
	 * 
	 */
	
	public void clickCampLink() {
		
		moreLink.click();
		campLink.click();
		
	}
	
	/*
	 * 
	 * this method is used for Contact link
	 */
	
	public void clickContactLink() {
		
		contactLink.click();
		
	}
	
	
	/*
	 * 
	 * this methods is used for organization link
	 */
	public void clickOrgLink(){
		
		orgLink.click();
		
	}
	
	/*
	 * 
	 * this method is used for product link
	 */
	
	public void clickProdLink() {
		
		prodLink.click();
	}
	
	/*
	 * This method is used for Signout
	 * 
	 * 
	 */
	public void clickSignOut() {
		
		signOutImage.click();
		signOut.click();
		
	}

}
