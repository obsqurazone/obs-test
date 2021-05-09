/*package com.obsqura.Listeners;

import com.aventstack.extentreports.Status;
import com.obsqura.ExtentReports.ExtentManager;
import com.obsqura.ExtentReports.ExtentTestManager;
import com.obsqura.scripts.TestHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;

public class Retry implements IRetryAnalyzer {
    private int count = 0;
    private static int maxTry = 1; //Run the failed test 2 times


    public void extendReportsFailOperations(ITestResult iTestResult) throws IOException {
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((TestHelper) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
        //ExtentTestManager.getTest().log(Status.FAIL, "Test Failed",
              //  ExtentTestManager.getTest().addScreenCaptureFromPath(base64Screenshot));
        ExtentTestManager.getTest().addScreenCaptureFromPath(base64Screenshot,"test failed");
    }


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
            if (count < maxTry) {                            //Check if maxTry count is reached
                count++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed and take base64Screenshot
                try {
                    extendReportsFailOperations(iTestResult);    //ExtentReports fail operations
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;                                 //Tells TestNG to re-run the test
            }
        }
        else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
}*/
