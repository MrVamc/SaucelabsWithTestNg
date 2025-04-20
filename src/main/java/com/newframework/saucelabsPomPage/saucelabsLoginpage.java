package com.newframework.saucelabsPomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.newframework.baseclass.newBaseclass;
import com.newframework.utils.extentReports;

public class saucelabsLoginpage extends newBaseclass{
	
	@FindBy(xpath = "//input[@id = 'user-name']")
	private WebElement enterUsername;
	
	@FindBy(xpath = "//input[@id = 'password']")
	private WebElement enterPassword;
	
	@FindBy(xpath = "//input[@id ='login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//h3[text() = 'Epic sadface: Sorry, this user has been locked out.']")
	private WebElement erroeMssg;
	
	@FindBy(xpath = "//h3[text()='Epic sadface: Username is required']")
	private WebElement emptyFields;
	
	@FindBy(xpath = "//h3[text()='Epic sadface: Password is required']")
	private WebElement userfield;
	
	@FindBy(xpath = "//h3[text()='Epic sadface: Username is required']")
	private WebElement pwdfield;
	
	public void enterUsername(String user) {
		enterUsername.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		enterPassword.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public WebElement errorMssg() {
		return erroeMssg;
	}
	
	public WebElement bothfieldsEmpty() {
		return emptyFields;
	}
	
	public WebElement pwdfieldEmpty() {
		return userfield;
	}
	
	public WebElement userfieldEmpty() {
		return pwdfield;
	}
	
	public saucelabsLoginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginSauceLabs(String username, String password) {
		
		enterUsername.clear();
		
		extentReports.test.log(Status.INFO, "Entering Valid username : " + username);
		enterUsername(username);
		
		enterPassword.clear();
		
		extentReports.test.log(Status.INFO, "Entering Valid password : "+ password);
		enterPassword(password);
		
		extentReports.test.log(Status.INFO, "Click on login button");
		clickLogin();
		
	}
	
	public void invalidloginSauceLabs(String username, String password) throws Throwable {
		
		Thread.sleep(3000);
		
		enterUsername.clear();
		
		
		
		extentReports.test.log(Status.INFO, "Entering Invalid Username : "+ username);
		enterUsername(username);
		
		
		Thread.sleep(3000);
		enterPassword.clear();
		
		
		
		extentReports.test.log(Status.INFO, "Entering Invalid password : "+ password);
		enterPassword(password);
		
		extentReports.test.log(Status.INFO, "Click on login button");
		clickLogin();
		
		Thread.sleep(3000);
	}

}
