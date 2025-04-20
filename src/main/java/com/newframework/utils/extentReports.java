package com.newframework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.newframework.baseclass.newBaseclass;

public class extentReports extends newBaseclass{
	
	/*When implementing parallel execution, ensure thread safety, especially with shared resources like the Extent Reports. 
	 * Utilize ThreadLocal for ExtentTest instances to maintain thread safety.* */
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void initializeReport() {
		
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "\\src\\test\\resources\\reports\\extent.html" );
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("My framework report");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setTimeStampFormat("dd/mm/yyyy HH:mm:ss");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
	
	}
	
	
	public static void tearReport() {
		if(extent != null) {
			extent.flush();
		}
	}

}
