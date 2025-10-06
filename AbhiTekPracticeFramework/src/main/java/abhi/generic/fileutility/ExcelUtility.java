package abhi.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readDataFromExcel(String sheet, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./configTestData/Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet shet = workbook.getSheet(sheet);
		Row row = shet.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String data = cel.toString();
		workbook.close();
		return data;
	}
	
	public void writeDataInExcel(String sheet, int rowNum, int cellNum, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./configTestData/Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet shet = workbook.getSheet(sheet);
		Row row = shet.getRow(rowNum);
		Cell cel = row.createCell(cellNum, CellType.STRING);
		cel.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream("./configTestData/Book1.xlsx");
		workbook.write(fos);
		workbook.close();
	}
}
