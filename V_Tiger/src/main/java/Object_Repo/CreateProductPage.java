package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	
	private WebElement prodName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	
	private WebElement saveButton; 
	

	public WebElement getprodName() {
		
		return prodName;
	}

	public WebElement getSaveButton() {
		
		return saveButton;
	}
	
	
	
	public void productDetails(String name)
	{
		prodName.sendKeys(name);
		
		saveButton.click();
	}
	
	
	
	
	
	
}
