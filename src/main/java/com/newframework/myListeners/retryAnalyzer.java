package com.newframework.myListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.newframework.utils.extentReports;

public class retryAnalyzer implements IRetryAnalyzer{
	/*
	 * Handles the retry mechanism for individual failed tests.
	 * 
	 * This class is used to run the failed test case one more than once.
	 * "presentCount" variable represents how many times does test case have executed.
	 * "repeatTestCase" variable is used to how many time does failed test case should run.
	 * 
	 * so i have provided repeatTestCase has 1, so the failed test case will execute one more even it is failed.
	 * 
	 */
	
	int presentCount = 0;
	int repeatTestCase = 1;

	@Override
	public boolean retry(ITestResult result) {
		if(presentCount < repeatTestCase) {
			System.out.println("Retrying test : "+ result.getName() +" |Attempt = "+ (presentCount+1));
			extentReports.test.log(Status.WARNING, "Retrying test : Attempt "+ (presentCount+1));
			presentCount++;
			return true;
		}
		return false;
	}
	
}
