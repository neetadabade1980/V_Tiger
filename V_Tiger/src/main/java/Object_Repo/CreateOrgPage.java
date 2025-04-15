package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {

	// initializing element

	public CreateOrgPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// element declaration

	@FindBy(name = "accountname")

	private WebElement orgName;

	@FindBy(id = "phone")

	private WebElement orgPhone;

	@FindBy(id = "email1")

	private WebElement orgEmail;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")

	private WebElement orgSaveButton;
	
	
	public WebElement getOrgName(){
		
		return orgName;		
	}
	
	public WebElement getOrgPhone() {
		
		return orgPhone;
	}
	
	public WebElement getOrgEmail() {
		
		return orgEmail;
		
	}
	
	public WebElement getOrgSaveButton() {
		
		return orgSaveButton;
	}
	
	
	public void enterOrgDetails(String Name,String phnNum,String Email)
	
	{
		orgName.sendKeys(Name);
		
		orgPhone.sendKeys(phnNum);
		
		orgEmail.sendKeys(Email);
	}
	
	public void clickSaveButton(){
		
		orgSaveButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
