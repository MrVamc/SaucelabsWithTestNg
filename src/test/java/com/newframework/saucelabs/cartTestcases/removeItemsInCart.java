package com.newframework.saucelabs.cartTestcases;

import java.util.List;

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

public class removeItemsInCart extends newBaseclass {

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
	public void removeItemsInCart() throws Throwable{
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		extentReports.test.info("Added product to the caart");
		WebElement productName = inv.productList().get(0);
		inv.addtoCart(productName).click();
		
		String name = inv.productName(productName).getText();
		
		saucelabsCartpage cart = new saucelabsCartpage(driver);
		extentReports.test.info("Navigationg to cart page");
		WebElement ele1 = cart.cartIcon();
		//extentReports.test.info("Clicking on cart icon");
		ele1.click();
		
		Thread.sleep(3000);
		
		extentReports.test.info("Clicking on remove button");
		cart.clickonRemoveButton();
		
		Thread.sleep(3000);
		
		try {
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(cart.getRemoveButton())));
		extentReports.test.pass("Product successfully removed from cart");
		}catch (AssertionError e) {
			Assert.fail();
			extentReports.test.fail("Product not removed : "+ e);
		}
		
	}
	
}
