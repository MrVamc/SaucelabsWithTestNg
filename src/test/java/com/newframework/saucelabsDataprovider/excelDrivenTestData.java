package com.newframework.saucelabsDataprovider;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.newframework.utils.ExcelUtils;

public class excelDrivenTestData {
	
	@DataProvider(name = "CheckOutData")
	public Object[][] userData(){
		
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\CheckOutData.xlsx";
		List<String[]> data = ExcelUtils.getCheckOutInfo(path, "Sheet1");
		
		Object[][] testData = new Object[data.size()][3];
		for(int i = 0 ; i< data.size(); i++) {
			testData[i] = data.get(i);
		}
		return testData;
	}

}
