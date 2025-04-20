package com.newframework.saucelabs.inventoryTestcases;

import org.openqa.selenium.WebElement;
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

public class addtoCart extends newBaseclass{
	
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
	public void addToCart() {
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		extentReports.test.log(Status.INFO, "Waiting for webelements");
		wait.until(ExpectedConditions.visibilityOfAllElements(inv.productList()));
		
		extentReports.test.info("Fetching first product");
		WebElement product = inv.productList().get(0);
		
		extentReports.test.info("Clicking on cart");
		inv.addtoCart(product).click();
		
		extentReports.test.info("Fetching remove button text");
		String removeButtonText = inv.getremoveButton(product).getText();
		
		try {
			extentReports.test.info("Validating 'Remove' text");
			Assert.assertEquals(removeButtonText, "Remove", "Button text should be 'Remove' after adding to cart");
			extentReports.test.info("Validating cart count");
			Assert.assertEquals(inv.getcartCount(), "1","Cart count should be 1");
			extentReports.test.pass("Test case passed!!");
		} catch (AssertionError e) {
			Assert.fail("Test case failed due to : "+ e);
			extentReports.test.fail("Test case failed due to : "+ e);
		}
	}
	
	

}
