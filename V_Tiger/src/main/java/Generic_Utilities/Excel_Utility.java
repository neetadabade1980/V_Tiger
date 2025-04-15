package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getExcelData(String SheetName, int rowNum, int cellNum) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");

		Workbook book = WorkbookFactory.create(fis);

		Sheet sheet = book.getSheet(SheetName);

		Row row = sheet.getRow(rowNum);

		Cell cell = row.getCell(cellNum);

		String excelData = cell.getStringCellValue();

		// System.out.println(excelData);

		return excelData;

	}

	public String getExcelDataUsingFormatter(String SheetName, int rowNum, int cellNum) throws Throwable {
		// step1:- path connection
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");
		// step2:-keeps the workbook/excelfile in read mode
		Workbook book1 = WorkbookFactory.create(fis1);
		// step3:- Navigating expected sheet
		Sheet sheet1 = book1.getSheet(SheetName);
		// step4:- Navigating expected row--->row value starts from 0
		Row row1 = sheet1.getRow(rowNum);
		// step5:- Navigating expected cell--->cell value starts from 0
		Cell cell1 = row1.getCell(cellNum);

		DataFormatter format = new DataFormatter();

		String ExcelData = format.formatCellValue(cell1);

		return ExcelData;
	}

	public Object[][] readDataFromDataProvider(String SheetName) throws EncryptedDocumentException, IOException {

		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData.xlsx");

		Workbook book1 = WorkbookFactory.create(fis1);

		Sheet sheet = book1.getSheet(SheetName);

		int lastRow = sheet.getLastRowNum() + 1;

		int lastCell = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRow][lastCell];

		for (int i = 0; i < lastRow; i++) {

			for (int j = 0; j < lastCell; j++) {

				obj[i][j] = sheet.getRow(i).getCell(j).toString();

			}
		}

		return obj;

	}

}
