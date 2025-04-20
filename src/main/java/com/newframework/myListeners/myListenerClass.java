package com.newframework.myListeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
//import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.newframework.utils.extentReports;
import com.newframework.utils.screenshotUtils;

public class myListenerClass implements ITestListener, ISuiteListener{

	/*	• What it is: ISuite is an interface in the TestNG framework that represents an entire test suite. A test suite in TestNG is typically defined in an testng.xml file and contains one or more test tags, which in turn contain one or more classes or methods to be tested (often involving Selenium WebDriver for browser automation).
	• When to use it: You, as a test automation engineer using TestNG, will primarily interact with ISuite through ISuiteListener.
		○ Implementing ISuiteListener: You create a class that implements the org.testng.ISuiteListener interface. This interface has two methods:
			§ onStart(ISuite suite): This method is invoked before the execution of all the tests within the suite defined in your testng.xml file begins.
			§ onFinish(ISuite suite): This method is invoked after all the tests within the suite have finished executing (regardless of whether they passed, failed, or were skipped).
		○ Use Cases for ISuiteListener:
			§ Suite-Level Setup: Perform actions that need to happen once before the entire test suite runs, such as: 
				□ Initializing global configurations.
				□ Setting up test environments (e.g., starting databases or servers).
				□ Loading data needed by multiple tests in the suite.
				□ Creating initial reports or log files.
			§ Suite-Level Teardown: Perform actions that need to happen once after the entire test suite has finished, such as: 
				□ Generating final reports or summaries.
				□ Closing connections to databases or servers.
				□ Cleaning up test environments.
				□ Sending email notifications about the test results.
			§ Accessing Suite Information: Within your ISuiteListener implementation (or sometimes within tests if you can obtain an ISuite instance), you can access information about the test suite using the methods provided by the ISuite interface (and its parent interface IAttributes). This includes: 
				□ Getting the suite name (suite.getName()).
				□ Getting the results of the suite execution.
				□ Accessing parameters defined in the testng.xml file at the suite level (suite.getParameter("parameterName")).
				□ Setting and getting attributes that can be shared across different parts of the suite execution.
	 * */

	@Override
	public void onStart(ISuite suite) {
		extentReports.initializeReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		extentReports.tearReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// This line creates a new test entry in the Extent Report.
	    // It uses the name of the test method that is about to start.
		extentReports.test = extentReports.extent.createTest(result.getMethod().getMethodName());
		
		// This line adds a log message to the Extent Report for the current test.
	    // It indicates that the test has just started and includes the test method's name.
		extentReports.test.log(Status.INFO, "Starting Test : "+ result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// Logs a "pass" status with the test name in the Extent Report.
		extentReports.test.pass(result.getMethod().getMethodName() +" Test passed successfully!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Captures a screenshot and gets the file path.
		String path = screenshotUtils.captureScreenshot(result.getName());
		
		 // Logs a "fail" status with the failure exception in the Extent Report.
		extentReports.test.fail("Test failed : "+ result.getThrowable());
		try {
			// Attaches the captured screenshot to the Extent Report.
		extentReports.test.addScreenCaptureFromPath(path);
		}catch (Exception e) {
			// Prints the stack trace of the exception for debugging.
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Logs a "skip" status with the skip exception in the Extent Report.
		extentReports.test.skip("Test skipped: "+ result.getThrowable());
	}
	
	
	
	

}
