package com.obsqura.pages;


import com.obsqura.enums.DbQueries;
import com.obsqura.utilities.PageUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.obsqura.common.SqlDB.getQueryResultWithHeaders;

public class Login extends PageUtility {
    WebDriver driver;

    @FindBy(name = "LoginForm[username]")
    WebElement userName;

    @FindBy(id = "loginform-password")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"login-form\"]/button/span")
    WebElement btn_Login;

    @FindBy(xpath = "//*[@id=\"login-form\"]//li")
    WebElement invalidLoginErrorMsg;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Homepage login(String uName, String pWd) {
        userName.sendKeys(uName);
        password.sendKeys(pWd);
        btn_Login.click();
        return new Homepage(driver);
    }

    public Login loginWithLoginPageAsReturn(String uName, String pWd) {
        userName.sendKeys(uName);
        password.sendKeys(pWd);
        btn_Login.click();
        return this;
    }

    public String getTextOfInvalidLoginError() {
        sleep(500);
        return invalidLoginErrorMsg.getText();
    }

    public String getSampleResultFromDBTable() {
        List<HashMap<String,String>> result = getQueryResultWithHeaders(DbQueries.valueOf("Get_SampleData_SampleTable").queryStr);
        System.out.println("printing values from db:firstname is "+result.get(0).get("firstname"));
        System.out.println("printing values from db: lastname is "+result.get(0).get("lastname"));
        System.out.println("printing values from db: address is "+result.get(0).get("address"));
        return result.get(0).get("lastname");
    }
}
