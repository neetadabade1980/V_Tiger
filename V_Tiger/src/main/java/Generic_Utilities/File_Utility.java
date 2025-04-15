 package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_Utility {
	
	/**
	 * This method is useed to read data from Properties file(external resource)
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author neeta
	 */
	
	
	public String getKeyAndValuePair(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/browser.properties");

		Properties pro = new Properties();
		
		pro.load(fis);
		
		String value = pro.getProperty(key);
		
		return value;		
	}
	
	
		
	

}
