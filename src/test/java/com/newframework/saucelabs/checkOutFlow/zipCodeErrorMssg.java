package com.newframework.saucelabs.checkOutFlow;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newframework.baseclass.newBaseclass;
import com.newframework.saucelabsDataprovider.excelDrivenTestData;
import com.newframework.saucelabsPomPage.saucelabsCartpage;
import com.newframework.saucelabsPomPage.saucelabsInventorypage;
import com.newframework.saucelabsPomPage.saucelabsLoginpage;
import com.newframework.saucelabsPomPage.saucelabscheckOutFlow;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;

public class zipCodeErrorMssg extends newBaseclass{

	@BeforeMethod
	public void login() throws InterruptedException {
		browserUtils.open_URL(configuration.getProperty("url"));
		saucelabsLoginpage slp = new saucelabsLoginpage(driver);
		slp.enterUsername("standard_user");
		slp.enterPassword("secret_sauce");
		slp.clickLogin();
		Thread.sleep(3000);
	}
	
	@Test(dataProvider = "CheckOutData", dataProviderClass = excelDrivenTestData.class)
	public void verifyCheckOutwitValidData(String firstName, String lastName, String zipCode) throws InterruptedException {
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		extentReports.test.info("Waiting for webelements to load");
		wait.until(ExpectedConditions.visibilityOfAllElements(inv.productList()));
		
			
		for(int i = 0; i<2; i++) {
			WebElement product = inv.productList().get(i);
			String name = product.getText();
			Thread.sleep(3000);
			extentReports.test.info("Adding product to cart : "+name);
			inv.addtoCart(product).click();
		}
		
		saucelabsCartpage cart = new saucelabsCartpage(driver);
		extentReports.test.info("Navigating to cart");
		cart.cartIcon().click();
		Thread.sleep(3000);
		extentReports.test.info("Clicking on Check out button");
		cart.clickonCheckoutButton();
		
		saucelabscheckOutFlow check = new saucelabscheckOutFlow(driver);
		extentReports.test.info("Entering firstname: "+ firstName);
		check.getFirstName().sendKeys(firstName);
		extentReports.test.info("Entering lastname: "+ lastName);
		check.getLastName().sendKeys(lastName);

		extentReports.test.info("Clicking on continue order ");
		check.getContinueOrder().click();
		
		try {
			extentReports.test.info("Validating error message");
			Assert.assertEquals(check.getErrorMssg().getText(), check.zipCodErrorMssg, "Error message does not match!!");
			extentReports.test.pass("Error message matched!!");
		}
		catch (AssertionError e) {
			Assert.fail();
			extentReports.test.fail("Error message does not match!!"+ e);
		}
	}

	
}
