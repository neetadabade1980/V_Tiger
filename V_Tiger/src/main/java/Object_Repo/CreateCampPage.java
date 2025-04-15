package Object_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {

	public CreateCampPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignname")

	private WebElement campName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")

	private WebElement saveButton;

	// product plus sign

	@FindBy(xpath = "//img[@alt=\"Select\"]")

	private WebElement productPlusSign;

	// methods

	public WebElement getCampName() {

		return campName;
	}

	public void setCampName(WebElement campName) {
		this.campName = campName;
	}

	public void setSaveButton(WebElement saveButton) {
		this.saveButton = saveButton;
	}

	public WebElement getSaveButton() {

		return saveButton;
	}

	public void campDetails(String name) {
		campName.sendKeys(name);

		saveButton.click();
	}

	public void campName(String name) {

		campName.sendKeys(name);
	}

	public void clickProductPlusSign() {

		productPlusSign.click();
	}

}
