package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class CreateContactPage {

	// elemnet initialisation

	public CreateContactPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// element declaration

	@FindBy(name = "firstname")

	private WebElement firstName;

	@FindBy(name = "lastname")

	private WebElement lastName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")

	private WebElement saveButon;

	public WebElement getFirstName() {

		return firstName;
	}

	public WebElement getLastName() {

		return lastName;
	}

	public WebElement getSaveButon() {

		return saveButon;
	}

	// business logic

	public void contactDetails(String firstname, String lastname) {

		firstName.sendKeys(firstname);

		lastName.sendKeys(lastname);

	}

	public void saveButtonContact() {

		saveButon.click();
	}

	public void selectDropDownValue(WebDriver driver) {

		WebElement ele = driver.findElement(By.xpath("//select[@name='salutationtype']"));

		WebDriver_Utility wlib = new WebDriver_Utility();

		wlib.dropDown(ele, "Mrs.");

	}

}
