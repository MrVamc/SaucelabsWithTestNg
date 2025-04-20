package com.newframework.saucelabs.inventoryTestcases;

import java.util.List;

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
import com.newframework.utils.screenshotUtils;

public class productDetails extends newBaseclass {
	
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
	public void verifyProductDetails() {
		
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(inv.productList()));
		
		try {
			
			for (WebElement product : inv.productList() ) {
				Assert.assertTrue(inv.productName(product).isDisplayed(), "Product name not displayed");
				extentReports.test.pass("Product name : "+ inv.productName(product).getText());
				
				Assert.assertTrue(inv.productImage(product).isDisplayed(), "Product image not displayed");
				extentReports.test.pass("Image displayed");
				
				Assert.assertTrue(inv.productPrice(product).isDisplayed(),"Product price not displayed");
				extentReports.test.pass("Price : "+ inv.productPrice(product).getText());
				
			}
			
		} catch (AssertionError e) {
			Assert.fail("Product details not displayed :"+ e);
			extentReports.test.fail(e);
		}
	}

}
