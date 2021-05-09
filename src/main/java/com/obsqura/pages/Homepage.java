package com.obsqura.pages;

import com.obsqura.utilities.PageUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends PageUtility {

    WebDriver driver;

    @FindBy(xpath = "\n" +
            "                ERP | Dashboard            ")
    WebElement pageTitle;

    @FindBy(xpath = "//*[text()=' All rights\n" +
            "    reserved.\n" +
            "  ']")
    WebElement logo;

    public Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean isHomePageLoaded() {
        //example of using wait utility methods
        waitForElementTobeVisible(driver, logo, 15);
        return logo.isDisplayed();
    }

}
