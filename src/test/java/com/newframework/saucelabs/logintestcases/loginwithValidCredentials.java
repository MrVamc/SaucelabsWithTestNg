package com.newframework.saucelabs.logintestcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.newframework.baseclass.newBaseclass;
import com.newframework.saucelabsDataprovider.loginData;
import com.newframework.saucelabsPomPage.saucelabsLoginpage;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class loginwithValidCredentials extends newBaseclass{
	
	
	
	@Test(dataProvider = "valid-login-data", dataProviderClass = loginData.class)
	public void login(String user, String pwd) {
		// Opening saucelabs URL
		browserUtils.open_URL(configuration.getProperty("url"));
		
		//POM instance
		saucelabsLoginpage slp = new saucelabsLoginpage(driver);
		
		slp.loginSauceLabs(user, pwd);
		
		
		 String expectedTitle = "Swag Labs";
		 String actualTitle = driver.getTitle();
		 
		 try {
		 Assert.assertEquals(actualTitle,expectedTitle, "Page title does not match!");
		 extentReports.test.pass("Page title matched :"+ actualTitle);
		 }catch (AssertionError e) {
			extentReports.test.fail("Page title does not match : " + e);
			throw e;
		}
		
		 
	}
	
	
	/*
	 * @Test(dataProvider = "invalid-login-data", dataProviderClass =
	 * loginData.class, priority = 2) public void invalidLogin(String user, String
	 * pwd) throws Throwable { slp.invalidloginSauceLabs(user, pwd);
	 * extentReports.test.log(Status.INFO,"Waiting for error mssg ");
	 * wait.until(ExpectedConditions.visibilityOf(slp.errorMssg()));
	 * 
	 * try { extentReports.test.log(Status.INFO, "Validating error mssg");
	 * Assert.assertTrue(slp.errorMssg().isDisplayed(), "Error mssg not displayed");
	 * extentReports.test.pass("Error mssg displayed as expected"); } catch
	 * (AssertionError e) { Assert.fail("Test failed due to : ", e);
	 * extentReports.test.fail(e); } }
	 */
	

}
