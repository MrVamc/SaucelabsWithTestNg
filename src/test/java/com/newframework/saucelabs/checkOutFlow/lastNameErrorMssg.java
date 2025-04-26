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

public class lastNameErrorMssg extends newBaseclass{

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
	public void verifyLastNameErrorMssg(String firstname, String lastName, String zipCode) {
		saucelabsInventorypage inv = new saucelabsInventorypage(driver);
		extentReports.test.info("Waiting for webelements to load");
		wait.until(ExpectedConditions.visibilityOfAllElements(inv.productList()));
		
		WebElement product = inv.productList().get(0);
		String name = product.getText();
		extentReports.test.info("Adding product to cart : "+name);
		inv.addtoCart(product).click();
		
		saucelabsCartpage cart = new saucelabsCartpage(driver);
		extentReports.test.info("Navigating to cart");
		cart.cartIcon().click();
		extentReports.test.info("Clicking on Check out button");
		cart.clickonCheckoutButton();
		
		saucelabscheckOutFlow check = new saucelabscheckOutFlow(driver);
		extentReports.test.info("Entering firstname: "+ firstname);
		check.getFirstName().sendKeys(firstname);
		extentReports.test.info("Entering zipcode: "+ zipCode);
		check.getZipCode().sendKeys(zipCode);
		extentReports.test.info("Clicking on continue order ");
		check.getContinueOrder().click();
		
		try {
			extentReports.test.info("Validating error message");
			Assert.assertEquals(check.getErrorMssg().getText(), check.lastNameErrorMssg, "Error message does not match");
			extentReports.test.pass("Error message matched!!");
		}
		catch (AssertionError e) {
			Assert.fail();
			extentReports.test.fail("Error message does not match!!"+ e);
		}
	}
}
