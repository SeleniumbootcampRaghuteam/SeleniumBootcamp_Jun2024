package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;

public class ReadExcelData {
	//public static void main(String[] args) {
	public static String[][] readExcelData(String Testdata){
		XSSFWorkbook wbook;
		String[][] data = null;
		try {
			wbook = new XSSFWorkbook("./data/"+Testdata+".xlsx");
			XSSFSheet sheet = wbook.getSheetAt(0);
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(rowCount).getLastCellNum();
			data = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					//data[i-1][j] =  sheet.getRow(i).getCell(j).getStringCellValue();
					String value =  sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(value);
					data[i-1][j] = value;
					
				} 
			}
			wbook.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return data;
	}

}
