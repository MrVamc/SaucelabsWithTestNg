package com.newframework.utils;

import java.util.Set;

import org.openqa.selenium.Cookie;

import com.newframework.baseclass.newBaseclass;

public class cookieUtils extends newBaseclass {
	
	public static void addCookie(String cookieName, String cookieValue) {
		
		Cookie newCookie = new Cookie(cookieName, cookieValue);
		driver.manage().addCookie(newCookie);
		System.out.println("New cookie added: "+ cookieName);
	}
	
	public static void getCookieName(String cookieName) {
		String cookie = driver.manage().getCookieNamed(cookieName).getName();
		System.out.println("Cookie name: "+ cookie);
	}
	
	public static void getCookies() {
		Set<Cookie> cookies = driver.manage().getCookies();

        // Iterate through cookies and print their details
        for (Cookie cookie : cookies) {
            System.out.println("Cookie Name: " + cookie.getName());
            System.out.println("Cookie Value: " + cookie.getValue());
            System.out.println("Cookie Domain: " + cookie.getDomain());
            System.out.println("Cookie Path: " + cookie.getPath());
            System.out.println("Cookie Expiry: " + cookie.getExpiry());
            System.out.println("Is Secure: " + cookie.isSecure());
            System.out.println("-------------------------");
        }
	}
	
	public static void deleteCookieNmaed(String cookieName) {
		driver.manage().deleteCookieNamed(cookieName);
	}
	
	public static void deleteAllCookie() {
		driver.manage().deleteAllCookies();
	}
	
	public static void deleteCookie(Cookie cookie) {
		driver.manage().deleteCookie(cookie);
	}

}
