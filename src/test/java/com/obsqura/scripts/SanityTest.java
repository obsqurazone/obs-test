package com.obsqura.scripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obsqura.Listeners.TestListener;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.Login;
import com.obsqura.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class SanityTest extends TestHelper {
    Login login;
    Homepage homepage;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();


    @Test(priority = 0, description = "Invalid Login Scenario with wrong username and password")
    public void verifyUserisAbleToAddComments1() {
        extentTest.get().assignCategory("Sanity");
        login = new Login(driver);
        extentTest.get().log(Status.PASS, "LOG SOMETHING ABOUT THE SUCCESS OF THIS STEP HERE");
        homepage = login.login("uName", "pWd");
        extentTest.get().log(Status.PASS, "LOG SOMETHING ABOUT THE SUCCESS OF THIS STEP HERE");
        //Assert.assertTrue(homepage.isHomePageLoaded(), "rdttdtgdsdsd");

    }

    //@Test(priority = 1, description = "Invalid Login Scenario with wrong username and password121")
    public void verifyUserisAbleToAddComments2() {
        extentTest.get().assignCategory("Sanity");
        login = new Login(driver);
        extentTest.get().log(Status.PASS, "LOG SOMETHING ABOUT THE SUCCESS OF THIS STEP HERE");
        homepage = login.login("uName", "pWd");
        extentTest.get().log(Status.PASS, "LOG SOMETHING ABOUT THE SUCCESS OF THIS STEP HERE");
        Assert.assertTrue(homepage.isHomePageLoaded(), "rdttdtgdsdsd");

    }

    //@Test(priority = 2, description = "Invalid Login Scenario")
    public void verifyUserisAbleToAddComments3() {
        login = new Login(driver);
        extentTest.get().log(Status.PASS, "LOG SOMETHING ABOUT THE SUCCESS OF THIS STEP HERE");
        homepage = login.login("uName", "pWd");
        extentTest.get().log(Status.PASS, "LOG SOMETHING ABOUT THE SUCCESS OF THIS STEP HERE");
        Assert.assertTrue(homepage.isHomePageLoaded(), "rdttdtgdsdsd");

    }

    //@Test(priority = 3, description = "Invalid Login Scenario")
    public void verifyUserisAbleToAddComments4() {
        extentTest.get().assignCategory("Sanity");
        login = new Login(driver);
        extentTest.get().log(Status.PASS, "LOG SOMETHING ABOUT THE SUCCESS OF THIS STEP HERE");
        Assert.assertTrue(true);
    }

    //@Test(priority = 3, description = "Invalid Login Scenario")
    public void verifyUserisAbleToAddComments5() {
        extentTest.get().assignCategory("Sanity");
        login = new Login(driver);
        extentTest.get().log(Status.PASS, "LOG SOMETHING ABOUT THE SUCCESS OF THIS STEP HERE");
        Assert.assertTrue(true);
    }

    @Test(priority = 3, description = "Invalid Login Scenario")
    public void verifyUserisAbleToAddComments6() {
        extentTest.get().assignCategory("Sanity");
        login = new Login(driver);
        extentTest.get().log(Status.PASS, "LOG SOMETHING ABOUT THE SUCCESS OF THIS STEP HERE");
        Assert.assertTrue(true);
    }

    @Test(priority = 4, description = "Excel Read")
    public void verifySampleTest_ReadDataFromExcel() {
        extentTest.get().assignCategory("Sanity");
        login = new Login(driver);
        System.out.println("Printing excel value : "+ExcelUtility.getCellData(0,1));
        System.out.println("Printing excel value : "+ExcelUtility.getCellData(1,1));
        login.login(ExcelUtility.getCellData(0,1),ExcelUtility.getCellData(1,1));
        extentTest.get().log(Status.PASS, "LOG SOMETHING ABOUT THE SUCCESS OF THIS STEP HERE");
        Assert.assertTrue(true);
    }

}
