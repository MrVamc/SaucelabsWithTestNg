package com.newframework.saucelabsDataprovider;

import org.testng.annotations.DataProvider;

public class loginData{
	
	@DataProvider(name = "valid-login-data")
	public static Object[][] getLoginData(){
		
		return new Object[][] {
			{"standard_user", "secret_sauce"},	
		};
	}
	
	@DataProvider(name = "invalid-login-data")
	public static Object[][] getinvalidLoginData(){
		
		return new Object[][] {
			{"locked_out_user","secret_sauce"},
				/*
				 * {"problem_user","secret_sauce"}, {"performance_glitch_user","secret_sauce"},
				 * {"error_user","secret_sauce"}, {"visual_user","secret_sauce"}
				 */
		};
	}
	
}
