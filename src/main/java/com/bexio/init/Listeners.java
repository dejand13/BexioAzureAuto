package com.bexio.init;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;

public class Listeners extends DriverInit implements ITestListener, IRetryAnalyzer {
    private int retryCnt = 0;
    private int maxRetryCnt = 1;

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String getMethodName =iTestResult.getName();
        try {
           DriverInit.takeScreenshot(getMethodName);
        } catch (Exception e) {
            log.info("Take Screenshot exception");
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

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

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCnt < maxRetryCnt) {
            System.out.println("Retrying " + iTestResult.getName() + " again and the count is " + (retryCnt+1));
            retryCnt++;
            return true;
        }
        return false;
    }
}
