package com.newframework.saucelabs.inventoryTestcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
import com.newframework.utils.selectUtils;

public class sortZtoA extends newBaseclass{

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
	public void sortZToA() {
		saucelabsInventorypage slp = new saucelabsInventorypage(driver);
		extentReports.test.log(Status.INFO, "Waiting for select drop down");
		wait.until(ExpectedConditions.visibilityOf(slp.getselectDropdown()));
		
		selectUtils sle = new selectUtils();
		extentReports.test.log(Status.INFO, "Selecting the option");
		sle.selectbyVisibleText(slp.getselectDropdown(), slp.getZtoA());
		
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		List<String> actualproductName =  inv.getProductName();
		for(String product : actualproductName) {
			System.err.println(product);
			extentReports.test.log(Status.INFO,"Sorted products : "+ product);
		}
		
		List<String> expectedproductName = new ArrayList<String>(actualproductName);
		Collections.sort(expectedproductName);
		Collections.reverse(expectedproductName);
		
		try {
			Assert.assertEquals(actualproductName, expectedproductName, "Products have not sorted from Z to A");
			extentReports.test.pass("Products have sorted from Z to A");
		} catch (AssertionError e) {
			Assert.fail();
			extentReports.test.fail("Products have not sorted from Z to A : "+ e);
		}
		
	}
	
}
