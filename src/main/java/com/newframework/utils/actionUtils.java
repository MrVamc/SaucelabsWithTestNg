package com.newframework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class actionUtils  {
	
	
	public void click(WebDriver driver) {
		Actions act = new Actions(driver);
		act.click();
	}
	
	public void clickElement(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.click(ele);
	}
	
	public void clickandhold(WebDriver driver) {
		Actions act = new Actions(driver);
		act.clickAndHold();
	}
	
	public void clickandholdElement(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.clickAndHold(ele).perform();
	}
	
	public void moveToelement(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void doubleClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void doubleClickElement(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	public void rightClickElement(WebDriver driver,WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}
	
	public void drag_and_drop(WebDriver driver,WebElement src, WebElement dst){
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}

}
