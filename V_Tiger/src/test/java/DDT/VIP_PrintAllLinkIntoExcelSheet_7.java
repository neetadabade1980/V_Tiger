package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VIP_PrintAllLinkIntoExcelSheet_7 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Flipkart.properties");
		
		Properties pro = new Properties();
		
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
		
		String URL = pro.getProperty("Url");

		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.get(URL);
		
		driver.manage().window().maximize();
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Ass.xlsx");
		
		Workbook book = WorkbookFactory.create(fis1);
		
		Sheet sheet = book.getSheet("Sheet1");
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		for (int i = 0 ; i< allLinks.size() ; i++) {
			
			Row row = sheet.createRow(i);
			
			Cell cell = row.createCell(0);
			
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
			
					
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Ass.xlsx");
		
		book.write(fos);
		
		book.close();
		
		//System.out.println(allLinks.getText());

		
		
		
		
		
	
		

	}

}
