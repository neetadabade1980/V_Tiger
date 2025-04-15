package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertExcelDataIntoExcelSheet_6 {

	public static void main(String[] args) throws IOException {


		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet1");
		
		 Row row = sheet.createRow(3);
		 
		 Cell cell = row.createCell(4);
	
		cell.setCellValue("Neeta Mutyala");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		
		book.write(fos);
		
		book.close();
		
		
		
		
		
		
		

	}

}
