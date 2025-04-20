package com.newframework.saucelabs.inventoryTestcases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

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

public class sortLowToHigh extends newBaseclass{
	
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
	public void sortLowtoHigh() throws Throwable {
		saucelabsInventorypage sip = new saucelabsInventorypage(driver);
		
		extentReports.test.log(Status.INFO, "Waiting for dropdown element to visisble");
		wait.until(ExpectedConditions.visibilityOf(sip.getselectDropdown()));
		
		selectUtils sle = new selectUtils();
		extentReports.test.log(Status.INFO, "Selecting the dropdown from low to high");
		sle.selectbyVisibleText(sip.getselectDropdown(), sip.getlohi());
		
		//To avoid Stale element reference exception
		saucelabsInventorypage sort = new saucelabsInventorypage(driver);
		
		List<Double> actualPriceList = sort.getProductPrice();
		
		  for (Double price : actualPriceList) { 
			  System.out.println(price); 
			  extentReports.test.log(Status.INFO, "Sorted amount: "+price);
		}
		 
		
		
		List<Double> expectedPriceList = new ArrayList<>(actualPriceList);
		Collections.sort(expectedPriceList);
		
		try {
			Assert.assertEquals(actualPriceList, expectedPriceList, "Products are not sorted from Low to High");
			extentReports.test.pass("Products are sorted from Low price to High price");
		}catch (AssertionError e) {
			Assert.fail("Prices are not in low to high order!!"+ e);
			extentReports.test.fail("Prices are not sorted from low to high : "+ e);
		}
		
	}
	
	
}
