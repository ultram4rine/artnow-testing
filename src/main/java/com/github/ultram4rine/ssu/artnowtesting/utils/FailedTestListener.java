package com.github.ultram4rine.ssu.artnowtesting.utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class FailedTestListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        ScreenShotMaker.takeScreenShot();
    }
}
