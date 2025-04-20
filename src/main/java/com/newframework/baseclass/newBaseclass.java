package com.newframework.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.newframework.utils.browserUtils;
import com.newframework.utils.extentReports;
import com.newframework.utils.screenshotUtils;

public class newBaseclass {

	public static WebDriver driver;
	public static Properties configuration = new Properties();
	public static WebDriverWait wait;  


	@BeforeClass
	public void setUp() throws Throwable {
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--disable-blink-features=AutomationControlled");
		option.addArguments("--disable-infobars");
		option.addArguments("--disable-notifications");
		option.addArguments("--disable-save-password-bubble");
		option.addArguments("--incognito");
		
		
		if (driver == null) {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\browser_url.PROPERTIES");
			configuration.load(fis);
		}

		switch (configuration.getProperty("browser").toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver(option);
		}
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		browserUtils.max_Screen(driver);
	}


	@AfterClass
	public void tearDown() throws InterruptedException {

		if (driver != null) {
			Thread.sleep(3000);
			driver.close();
		}

	}

}
