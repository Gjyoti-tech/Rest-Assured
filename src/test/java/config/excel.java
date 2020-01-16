package config;



import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.Test;


import junit.framework.Assert;

public class excel {
	
	
	@Test
public 	void test () throws IOException, InvalidFormatException
	{
		ClassLoader classLoader=this.getClass().getClassLoader();
		FileInputStream file=new FileInputStream(classLoader.getResource("POST.xlsx").getFile());
	XSSFWorkbook workbook = new XSSFWorkbook(file);

	XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowStart=sheet.getFirstRowNum();
		int rowEnd=sheet.getLastRowNum();
		
		for(int i=rowStart;i<=rowEnd;++i)
		{
			
			Row row=sheet.getRow(i);
			String request=row.getCell(0).getStringCellValue();
			String url=row.getCell(1).getStringCellValue();
			int expected=(int )row.getCell(2).getNumericCellValue();
			int actual=helper.decide(request,url);
			
				Assert.assertEquals(expected, actual);
				
				
}
			
				 
				 
			
		}
	}


