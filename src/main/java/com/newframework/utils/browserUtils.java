package com.newframework.utils;

import org.openqa.selenium.WebDriver;

import com.newframework.baseclass.newBaseclass;

public class browserUtils extends newBaseclass{
	
	public static void max_Screen(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public static void min_Screen(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	public static void full_Screen(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	public static void open_URL(String url) {
		driver.get(url);
	}
	
	public static void navigate_To(String url) {
		driver.navigate().to(url);
	}
	
	public static void forward(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public static void backward(WebDriver driver) {
		driver.navigate().back();
	}
	
	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

}
