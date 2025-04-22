package com.newframework.saucelabs.cartTestcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newframework.baseclass.newBaseclass;
import com.newframework.saucelabsPomPage.saucelabsCartpage;
import com.newframework.saucelabsPomPage.saucelabsInventorypage;
import com.newframework.saucelabsPomPage.saucelabsLoginpage;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class checkOut extends newBaseclass {
	
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
	public void verifyCheckOut() throws Throwable{
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		extentReports.test.info("Waiting for elements");
		wait.until(ExpectedConditions.visibilityOfAllElements(inv.productList()));
		
		extentReports.test.info("Adding products to cart");
		WebElement product = inv.productList().get(0);
		
		inv.addtoCart(product).click();
		
		Thread.sleep(3000);
		
		extentReports.test.info("Navigating to Cart");
		saucelabsCartpage cart = new saucelabsCartpage(driver);
		
		cart.cartIcon().click();
		
		Thread.sleep(3000);
		
		extentReports.test.info("Clicking on Check Out");
		cart.clickonCheckoutButton();
		
		try {
			String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains("checkout-step-one"), "In check out page");
			extentReports.test.pass("Products have Check out");
		} catch (AssertionError e) {
			Assert.fail();
			extentReports.test.fail("Product have not check out: "+ e);
		}
		
		
	}

}
