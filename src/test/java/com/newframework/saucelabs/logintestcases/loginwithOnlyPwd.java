package com.newframework.saucelabs.logintestcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.newframework.baseclass.newBaseclass;
import com.newframework.saucelabsDataprovider.loginData;
import com.newframework.saucelabsPomPage.saucelabsLoginpage;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class loginwithOnlyPwd extends newBaseclass{
	
	@Test(dataProvider = "valid-login-data", dataProviderClass = loginData.class)
	public void pwdOnly(String user, String pwd) {
		browserUtils.open_URL(configuration.getProperty("url"));
		
		saucelabsLoginpage slp = new saucelabsLoginpage(driver);
		
		slp.enterPassword(pwd);
		
		slp.clickLogin();
		
		wait.until(ExpectedConditions.visibilityOf(slp.userfieldEmpty()));
		
		try {
			Assert.assertTrue(slp.userfieldEmpty().isDisplayed(),"Error message not displayed");
			extentReports.test.pass("Error message displayed");
		} catch (AssertionError e) {
			Assert.fail("Error message not displayed"+ e);
			extentReports.test.fail("Test case failed : "+ e);
		}
		
	}

}
