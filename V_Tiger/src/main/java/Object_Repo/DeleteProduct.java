package Object_Repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProduct {

	// element initialization
	
	public DeleteProduct(WebDriver driver) {
		
		
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (xpath = "//input[@value=\"Delete\"]")
	
	private WebElement deletePrd;;
	
	
	public void selectProdCheckBox(WebDriver driver, String prdName ) throws InterruptedException {
		
		
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]//a[text()='"+prdName+"']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
		
		Thread.sleep(2000);
		
	}
	
	public  void clickDeletePrdButton() {
		
		deletePrd.click();
		
	}
	
	public void validateDeleteProduct(WebDriver driver , String prdName) {
		
		List<WebElement> allNames = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
		boolean flag=false;
		
		for (WebElement name : allNames)
		{
			String actPrd = name.getText();
			if(actPrd.equals(prdName))
			{
			flag=true;
			break;
		}
			}
		if(flag)
		{
			System.out.println("product name is deleted");
		}
		else
		{
			System.out.println("Product name is not deleted");
		}
		
		
	}
	
	
	
}
