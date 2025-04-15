package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Element Initialization
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
				
	}
		
	// element decration
	
	@FindBy (name = "user_name")
	private WebElement UserTextField;
	

	@FindBy (name = "user_password")
	private WebElement PasswordTextField;
	
	@FindBy (id = "submitButton")
	private WebElement LoginButton;
	
	// getter methods
	
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Business logic
	
	/*
	 *Thi s method is use to login into application 
	 * 
	 */
	public void loginIntoApp(String userName , String passWord) {
		
		UserTextField.sendKeys(userName);
		PasswordTextField.sendKeys(passWord);
		LoginButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
