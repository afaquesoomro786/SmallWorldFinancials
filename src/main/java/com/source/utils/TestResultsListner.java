package com.source.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestResultsListner implements ITestListener{

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Triggering test - "+ iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test passed - "+ iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test failed - "+ iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Skipped/Failed will be picked for retrying... - "+ iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
