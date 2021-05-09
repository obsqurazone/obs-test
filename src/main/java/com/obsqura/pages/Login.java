package com.obsqura.pages;


import com.obsqura.utilities.PageUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
