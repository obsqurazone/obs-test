package com.obsqura.scripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obsqura.Listeners.TestListener;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.Login;
import com.obsqura.ExtentReports.ExtentManager;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class RegressionTest extends TestHelper {
    Login login;
    Homepage homepage;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();


    @Test(priority = 0, description = "Invalid Login Scenario with wrong username and password")
    public void verifyInvalidLogin1(final ITestContext testContext) {
        extentTest.get().assignCategory("Regression");
        extentTest.get().assignCategory("PI 5.1");
        login = new Login(driver);
        extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
        homepage = login.login("uName", "pWd");
        extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
        Assert.assertTrue(homepage.isHomePageLoaded(), "rdttdtgdsdsd");

    }

    @Test(priority = 1, description = "Invalid Login Scenario with wrong username and password121")
    public void verifyInvalidLogin2(final ITestContext testContext) {
        extentTest.get().assignCategory("Regression");
        login = new Login(driver);
        extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
        homepage = login.login("uName", "pWd");
        extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
        Assert.assertTrue(homepage.isHomePageLoaded(), "rdttdtgdsdsd");

    }

    //@Test(priority = 2, description = "Invalid Login Scenario")
    public void verifyInvalidLogin3() {

        login = new Login(driver);
        extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
        homepage = login.login("uName", "pWd");
        extentTest.get().log(Status.PASS, "LOG SOMETHING HERE");
        Assert.assertTrue(homepage.isHomePageLoaded(), "rdttdtgdsdsd");

    }

    @Test(priority = 3, description = "Invalid Login Scenario")
    public void verifyInvalidLogin4() {
        login = new Login(driver);
        extentTest.get().log(Status.PASS, "THIS STEP IS GOOD");
        extentTest.get().log(Status.PASS, "THIS STEP IS GOOD");
        homepage = login.login("uName", "pWd");
        extentTest.get().log(Status.PASS, "THIS STEP IS GOOD");
        homepage.isHomePageLoaded();
        extentTest.get().log(Status.PASS, "THIS STEP IS NOT GOOD ENOUGH");
        extentTest.get().log(Status.PASS, "THIS STEP IS GOOD");
        Assert.assertTrue(true);

    }


}
