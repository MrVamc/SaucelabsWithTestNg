package com.newframework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	public static List<String[]> getCheckOutInfo(String filePath, String sheetName){
		
		List<String[]> dataList = new ArrayList<String[]>();
		
		try(FileInputStream fis = new FileInputStream(filePath);
				Workbook book = WorkbookFactory.create(fis)) {
			
		  Sheet sheet = book.getSheet(sheetName);
		  Iterator<Row> rowIterator = sheet.iterator();
		  rowIterator.next();
		  
		  DataFormatter df = new DataFormatter();
		  
		  while(rowIterator.hasNext()) {
			  
			  Row row = rowIterator.next();
			  String[] data = new String[3];
			  data[0] = df.formatCellValue(row.getCell(0));
			  data[1] = df.formatCellValue(row.getCell(1));
			  data[2] = df.formatCellValue(row.getCell(2));
			  
			  dataList.add(data);
			  
		  }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dataList;
	}
	 

}
