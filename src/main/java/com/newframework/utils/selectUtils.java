package com.newframework.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.newframework.baseclass.newBaseclass;

public class selectUtils {

	//Selects an option by visible text. 
	public void selectbyVisibleText(WebElement ele, String text) {
		Select sle = new Select(ele);
		sle.selectByVisibleText(text);
	}
	
	//Selects an option by value attribute. 
	public void selectByValue(WebElement ele, String value) {
		Select sle = new Select(ele);
		sle.selectByValue(value);
	}
	
	
	//Selects an option by index.
	public void selectByIndex(WebElement ele, int index) {
		Select sle = new Select(ele);
		sle.selectByIndex(index);
	}
	
	
	// Deselects all options (for multi-select dropdowns).
	public void deselectAll(WebElement ele) {
		Select sle = new Select(ele);
		sle.deselectAll();
	}
	
	
	//Deselects an option by visible text. 
	public void deselectByVisibleText(WebElement ele, String text) {
		Select sle = new Select(ele);
		sle.deselectByVisibleText(text);
	}
	
	
	// Deselects an option by value attribute. 
	public void deselectByValue(WebElement ele, String value) {
		Select sle = new Select(ele);
		sle.deselectByValue(value);
	}
	
	
	//Deselects an option by index. 
	public void deselectByIndex(WebElement ele, int index) {
		Select sle = new Select(ele);
		sle.deselectByIndex(index);
	}
	
	
	//Returns all options in the dropdown. Return type List<WebElement>
	public void getOptions(WebElement ele) {
		Select sle = new Select(ele);
		sle.getOptions();
	}
	
	// Returns all selected options. Return type List<WebElement>
	public void getAllSelectedOption(WebElement ele) {
		Select sle = new Select(ele);
		sle.getAllSelectedOptions();
	}
	
	// Return first selected options.
	public void getFirstSelectedOption(WebElement ele) {
		Select sle = new Select(ele);
		sle.getFirstSelectedOption();
	}
	
	//Checks if the dropdown allows multiple selections.
	public void checkIsMultiple(WebElement ele) {
		Select sle = new Select(ele);
		sle.isMultiple();
	}
}
