package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData 
{
	public static String[][] readExcel(String excelFileName, String excelSheetName) throws IOException
	{
		XSSFWorkbook wbook = new XSSFWorkbook("./data/" + excelFileName + ".xlsx");
		XSSFSheet sheet = wbook.getSheet(excelSheetName);
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String celValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = celValue;
			}
		}
		wbook.close();
		return data;
		
	}
	
}
