package com.newframework.saucelabs.inventoryTestcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.newframework.baseclass.newBaseclass;
import com.newframework.saucelabsPomPage.saucelabsInventorypage;
import com.newframework.saucelabsPomPage.saucelabsLoginpage;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class productListCount extends newBaseclass{
	
	
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
	public void validateProductListCount() {
		int expectedProductList = 6;
		
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		
		extentReports.test.log(Status.INFO, "Waiting for list of products to display");
		wait.until(ExpectedConditions.visibilityOfAllElements(inv.productList()));
		
		try {
			
			Assert.assertEquals(inv.productListCount(), expectedProductList, "Pagination does not match. ");
			extentReports.test.pass("Pagination matches expected product list "+ expectedProductList);
		} catch (AssertionError e) {
			Assert.fail("Pagination does not match"+ e);
			extentReports.test.fail("Pagination does not match" + e);
		}
	}

}
