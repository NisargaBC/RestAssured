package generalUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataForPostFromExelUtility {

	public Object[][] dataForPost(String sheets) throws Exception
	{
		File f= new File(".\\data\\dataAPI.xlsx");
		FileInputStream fi = new FileInputStream(f);
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheet(sheets);
		
		int rCount = sheet.getPhysicalNumberOfRows();
//		System.out.println(rCount);
//		int lastRowCount = sheet.getLastRowNum(); //this will print the number row present in the excel sheet
		int lastCellcount = sheet.getRow(0).getLastCellNum(); //this will print the number column present in the excel sheet
		
//		System.out.println(lastRowCount);
//		System.out.println(lastCellcount);
		
		
		Object[][] data = new Object[rCount][lastCellcount];
		for(int i=0; i<rCount; i++)
		{
			for(int j=0; j<lastCellcount; j++)
			{
				 data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();

			}
		}
		return data;
		
	}
	
	
}
