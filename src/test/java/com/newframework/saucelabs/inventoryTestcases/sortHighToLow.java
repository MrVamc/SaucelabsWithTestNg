package com.newframework.saucelabs.inventoryTestcases;

import static org.testng.Assert.fail;

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

public class sortHighToLow extends newBaseclass{

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
	public void sortHighToLow() {
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		extentReports.test.log(Status.INFO, "Waiting untill select drop down is visible");
		wait.until(ExpectedConditions.visibilityOf(inv.getselectDropdown()));
		
		selectUtils sle = new selectUtils();
		extentReports.test.log(Status.INFO, "Selecting the drop down High to Low");
		sle.selectbyVisibleText(inv.getselectDropdown(), inv.gethilo());
		
		//To avoid stale element exception
		saucelabsInventorypage invh = new saucelabsInventorypage(driver);
		List<Double> actualPrice = invh.getProductPrice();
		
		for(Double actual:actualPrice) {
			extentReports.test.log(Status.INFO, "Sorted price:"+actual);
		}
		
		List<Double> expectedPrice = new ArrayList<Double>(actualPrice);
		Collections.sort(expectedPrice);
		Collections.reverse(expectedPrice);
		
		try {
			Assert.assertEquals(actualPrice, expectedPrice, "Price are not sorted in High to Low !!");
		} catch (AssertionError e) {
			Assert.fail();
		}
	}
}
