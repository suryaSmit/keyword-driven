package keyworddriven;

import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

public class Excel {
	Workbook book;
	Sheet sh;
	
	//set excel -- set an excel in file system to read the data
	public void setExcel(String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(Constants.folderPath+fileName);
			book = Workbook.getWorkbook(fis);
			sh =book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//get no of rows
	public int rowCount() {
		return sh.getRows();
	}
	
	//get no of columns
	public int columnCount() {
		return sh.getColumns();
	}
	
	//read data
	public String readData(int row, int column) {
		return sh.getCell(column, row).getContents();
	}

}
