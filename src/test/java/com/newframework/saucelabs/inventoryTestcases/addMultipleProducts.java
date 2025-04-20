package com.newframework.saucelabs.inventoryTestcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newframework.baseclass.newBaseclass;
import com.newframework.saucelabsPomPage.saucelabsInventorypage;
import com.newframework.saucelabsPomPage.saucelabsLoginpage;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class addMultipleProducts extends newBaseclass{
	
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
	public void addMultipleProductsToCart() throws Throwable {
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		extentReports.test.info("Waiting for webelement to load");
		wait.until(ExpectedConditions.visibilityOfAllElements(inv.productList()));
		
		for(int i =0; i<= 2; i++) {
			WebElement product = inv.productList().get(i);
			extentReports.test.info("Adding to cart : "+ product.getText());
			Thread.sleep(3000);
			inv.addtoCart(product).click();
		}
		
		try {
			Assert.assertEquals(inv.getcartCount(), "3", "Cart count should be 3");
			extentReports.test.pass("Number of products added to cart matches the count of cart");
		} catch (AssertionError e) {
			Assert.fail();
			extentReports.test.fail("Number of products added to cart does not matches the count of cart");
		}
	}
	

}
