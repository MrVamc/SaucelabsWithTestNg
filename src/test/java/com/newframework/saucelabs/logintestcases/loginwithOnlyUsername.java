package com.newframework.saucelabs.logintestcases;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.newframework.baseclass.newBaseclass;
import com.newframework.saucelabsDataprovider.loginData;
import com.newframework.saucelabsPomPage.saucelabsLoginpage;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class loginwithOnlyUsername extends newBaseclass{
	
	@Test(dataProvider =  "valid-login-data", dataProviderClass = loginData.class)
	public void usernameOnly(String user, String pwd) {
		browserUtils.open_URL(configuration.getProperty("url"));
		
		saucelabsLoginpage slp = new saucelabsLoginpage(driver);
		extentReports.test.log(Status.INFO, "Entering Username :"+ user);
		slp.enterUsername(user);
		
		extentReports.test.log(Status.INFO, "Clicking on login");
		slp.clickLogin();
		
		extentReports.test.log(Status.INFO, "Waiting for error message");
		wait.until(ExpectedConditions.visibilityOf(slp.pwdfieldEmpty()));
		
		try {
			Assert.assertTrue(slp.pwdfieldEmpty().isDisplayed(), "Error message not displayed");
			extentReports.test.pass("Error message displayed");
		} catch (AssertionError e) {
			Assert.fail("Error message not displayed" + e);
			extentReports.test.fail("Test case failed : "+ e);
			
		}
	}

}
