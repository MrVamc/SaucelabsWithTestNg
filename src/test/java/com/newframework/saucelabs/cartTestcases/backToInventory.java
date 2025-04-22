package com.newframework.saucelabs.cartTestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newframework.baseclass.newBaseclass;
import com.newframework.saucelabsPomPage.saucelabsCartpage;
import com.newframework.saucelabsPomPage.saucelabsLoginpage;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class backToInventory extends newBaseclass{
	@BeforeMethod
	public void login() throws InterruptedException {
		browserUtils.open_URL(configuration.getProperty("url"));
		saucelabsLoginpage slp = new saucelabsLoginpage(driver);
		slp.enterUsername("standard_user");
		slp.enterPassword("secret_sauce");
		slp.clickLogin();
		Thread.sleep(3000);
	}
	
	@Test
	public void toContinueShopping() throws Throwable{
		
		extentReports.test.info("Mavigating to Cart page");
		saucelabsCartpage cart = new saucelabsCartpage(driver);
		cart.cartIcon().click();
		
		Thread.sleep(3000);
		extentReports.test.info("In cart page");
		try {
			extentReports.test.info("Clicking on continue shopping button");
			cart.clickonContinueShoppingBtn();
			String currentURL = driver.getCurrentUrl();
			extentReports.test.info("Validating the current url");
			Assert.assertTrue(currentURL.contains("inventory"), "Back to Inventory page");
			extentReports.test.pass("Successfully navigated back to inventory page");
		} catch (AssertionError e) {
			Assert.fail();
			extentReports.test.fail("Still in cart page: "+ e);
			
		}
		
	}
}
