package com.newframework.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.newframework.baseclass.newBaseclass;

public class screenshotUtils extends newBaseclass{
	
	public static String captureScreenshot(String testName) {
		String screenshotpath = System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+testName+".png";
		TakesScreenshot ss = (TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dist = new File(screenshotpath);
		try {
			Files.copy(src, dist);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotpath;
	}

}
