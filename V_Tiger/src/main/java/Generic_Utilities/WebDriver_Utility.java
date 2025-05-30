 package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * 
	 * @param driver
	 */
	public void waitElementsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	/**
	 * This method is used to switch windows
	 * @param driver
	 * @param partial_Title
	 */
	
	public void windowSwitching(WebDriver driver,String partial_Title)
	{
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> it = allWins.iterator();

		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(partial_Title)) {
				break;
			}
		}
	}
	
	
	/**
	 * THis method is used to handle the drop down ele
	 * @param ele
	 * @param value
	 */
	public void dropDown(WebElement ele,String value)
	{
		Select select = new Select(ele);
		
		select.selectByValue(value);
	}
	
	
	/*
	 * 
	 * used for Action class
	 */
	public void actionClass(WebDriver driver , WebElement ele) {
		
		Actions act = new Actions(driver);
		
		act.moveToElement(ele).perform();		
		
	}
	
	
	public void alertAccept(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	}
	
	public static String takeScreenShotEx(WebDriver driver , String screenShotName) throws IOException {
		
		
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
		
		File src = takeScreenShot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./ScreenShots/"+screenShotName+".png");
		
		FileUtils.copyFile(src, dest);
		
		return dest.getAbsolutePath();
		
		
		
	}
	
	
	
}
