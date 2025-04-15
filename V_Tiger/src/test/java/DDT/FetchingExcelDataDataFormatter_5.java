package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingExcelDataDataFormatter_5 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {


		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet1");
		
		//step4:- Navigating expected row--->row value starts from 0
		
		Row row = sheet.getRow(0);
		
		//step5:- Navigating expected cell--->cell value starts from 0
		
		Cell cell = row.getCell(0);
		
		DataFormatter format = new DataFormatter();
		
		String excelData = format.formatCellValue(cell);
	
		System.out.println(excelData);
		
		
		
		
		
		

	}

}
