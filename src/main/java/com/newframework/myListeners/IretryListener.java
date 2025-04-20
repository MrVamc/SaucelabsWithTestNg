package com.newframework.myListeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class IretryListener implements IAnnotationTransformer{
	//Automatically applies RetryAnalyzer to all test methods.
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(retryAnalyzer.class);;
	}
}
