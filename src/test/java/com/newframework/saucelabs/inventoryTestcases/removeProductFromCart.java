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

public class removeProductFromCart extends newBaseclass{
	
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
	public void removeProduct() throws Throwable {
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		extentReports.test.info("Waiting for webelements to visible");
		wait.until(ExpectedConditions.visibilityOfAllElements(inv.productList()));
		
		extentReports.test.info("Adding to cart");
		WebElement product = inv.productList().get(0);
		inv.addtoCart(product).click();
		
		Thread.sleep(3000);
		
		if (inv.getcartCount().equals("1")) {
			extentReports.test.info("Validation the count of cart passed");
			inv.getremoveButton(product).click();
		}
		
		String addCart = inv.addtoCart(product).getText();
		System.out.println(addCart);
		
		try {
			Assert.assertEquals(addCart, "Add to cart","Add to cart text should be visible");
			extentReports.test.pass("Test case passed");
} catch (AssertionError e) {
			Assert.fail();
			extentReports.test.fail("Test case failed");
		}
	}

}
