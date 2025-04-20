package com.newframework.saucelabs.cartTestcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newframework.baseclass.newBaseclass;
import com.newframework.saucelabsPomPage.saucelabsCartpage;
import com.newframework.saucelabsPomPage.saucelabsLoginpage;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class navigateToCart extends newBaseclass{
	
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
	public void navToCart() throws Throwable{
		saucelabsCartpage cart =  new saucelabsCartpage(driver);
		extentReports.test.info("Waiting for webelements to load");
		wait.until(ExpectedConditions.visibilityOf(cart.cartIcon()));
		
		WebElement ele = cart.cartIcon();
		extentReports.test.info("Clicking on cart icon");
		ele.click();
		
		String currentUrl = driver.getCurrentUrl();
		extentReports.test.info("Current url :"+ currentUrl);
		
		try {
			Assert.assertTrue(currentUrl.contains("cart"), "Cart page did not open.");
			extentReports.test.pass("Cart page opened!!");
			
		}catch (AssertionError e) {
			Assert.fail();
			extentReports.test.fail("Cart page did not opened : "+ e);
		}
	}

}
