package com.newframework.saucelabs.logintestcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.newframework.baseclass.newBaseclass;
import com.newframework.saucelabsPomPage.saucelabsLoginpage;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class loginwithEmptyFields extends newBaseclass{
	
	@Test
	public void loginwithoutCredentials() {
		browserUtils.open_URL(configuration.getProperty("url"));
		saucelabsLoginpage slp = new saucelabsLoginpage(driver);
		
		slp.clickLogin();
		
		extentReports.test.log(Status.INFO, "Waiting for error message");
		wait.until(ExpectedConditions.visibilityOf(slp.bothfieldsEmpty()));
		
		try {
			extentReports.test.log(Status.INFO, "Validation error message");
			Assert.assertTrue(slp.bothfieldsEmpty().isDisplayed(),"Error message not displayed.");
			extentReports.test.pass("Error message displayed as expected");
		} catch (AssertionError e) {
			Assert.fail("Error message not displayed : "+ e);
			extentReports.test.fail("Test case failed : "+ e);
			
		}
	}

}
