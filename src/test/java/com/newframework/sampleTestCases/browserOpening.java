package com.newframework.sampleTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.newframework.baseclass.newBaseclass;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class browserOpening extends newBaseclass{
	
	@Test
	public static void openBrowser() {
		browserUtils.open_URL("https://www.linkedin.com/feed/");
		extentReports.test.log(Status.INFO, "Navigating to Login Page");
		Assert.assertTrue(true);
	}

}
