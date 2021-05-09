package com.obsqura.scripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.obsqura.ExtentReports.ExtentManager;
//import com.obsqura.ExtentReports.ExtentTestManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class TestHelper {

    WebDriver driver;
    public static Properties prop = null;

    public static void TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources"
                    + "/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void createReport(final ITestContext testContext) {
        ExtentManager.createInstance().createTest(testContext.getName(), "wwwdsd");
    }

    @BeforeMethod
    public void onSetup() {
        TestBase();
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult, ITestContext iTestContext) throws IOException {
        if (iTestResult.FAILURE == iTestResult.getStatus()) {
            takeScreenshot(iTestResult.getName());
        }
        driver.quit();
    }

    public String takeScreenshot(String name) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\target\\" + name + dateName
                + ".png";
        System.out.println(destination);
        File finalDestination = new File(destination);
        FileHandler.copy(source, finalDestination);
        return destination;

    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
