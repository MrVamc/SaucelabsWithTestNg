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

public class invalidLogin extends newBaseclass{

	
	
	@Test(dataProvider = "invalid-login-data", dataProviderClass = loginData.class) 
	  public void invalidLogin(String user, String pwd) throws Throwable 
	 
	{ 
		
		browserUtils.open_URL(configuration.getProperty("url"));
		
		saucelabsLoginpage slp = new saucelabsLoginpage(driver);
		  slp.invalidloginSauceLabs(user, pwd);
		  extentReports.test.log(Status.INFO,"Waiting for error mssg ");
		  wait.until(ExpectedConditions.visibilityOf(slp.errorMssg()));
	  
		  try { 
			  extentReports.test.log(Status.INFO, "Validating error mssg");
			  Assert.assertTrue(slp.errorMssg().isDisplayed(), "Error mssg not displayed");
			  extentReports.test.pass("Error mssg displayed as expected");
			  } catch (AssertionError e) { 
				  Assert.fail("Test failed due to : ", e);
				  extentReports.test.fail(e);
				  } 
		  }
	 
	
}
