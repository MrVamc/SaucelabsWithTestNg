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

public class sortAtoZ extends newBaseclass{
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
	public void sortingAtoZ() {
		saucelabsInventorypage slp = new saucelabsInventorypage(driver);
		extentReports.test.log(Status.INFO, "Waiting for select drop down");
		wait.until(ExpectedConditions.visibilityOf(slp.getselectDropdown()));
		
		selectUtils sle = new selectUtils();
		extentReports.test.log(Status.INFO, "Selecting the dropdown");
		sle.selectbyVisibleText(slp.getselectDropdown(), slp.getAtoZ());
		
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		 List<String> actualProductNames = inv.getProductName();
		 for(String produtNames : actualProductNames) {
			 System.out.println(produtNames);
			 extentReports.test.log(Status.INFO, "Sorted product names: "+ produtNames);
		 }
		 
		 List<String> expectedProductName = new ArrayList<String>(actualProductNames);
		 Collections.sort(expectedProductName);
		 
		 try {
			Assert.assertEquals(actualProductNames, expectedProductName, "Product names not sorted from A to Z");
			extentReports.test.pass("Product names sorted from A to Z");
		} catch (AssertionError e) {
			Assert.fail("Product names not sorted from A to Z : "+ e);
			extentReports.test.fail("Product names not sorted from A to Z :"+ e);
		}
	}

}
