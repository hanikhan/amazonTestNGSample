package com.tests.pages;

import org.openqa.selenium.WebDriver;
import utils.common.SeleniumUtils;
import utils.common.WebpageElements;

public class amazonLoginPage {
    public WebDriver driver ;

    public amazonLoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public static WebpageElements emailField= new WebpageElements("Email Field","//input[@id='ap_email']");
    public static WebpageElements continueButton = new WebpageElements("Continue Button For email","//input[@id='continue']");
    public static WebpageElements passwordField = new WebpageElements("Password Field","//input[@id='ap_password']");
    public static WebpageElements loginButton = new WebpageElements("Login Button","//input[@id='signInSubmit']");

    public void enterEmail(String username){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.waitForElement(emailField);
        seleniumUtils.sendKeys(emailField,username);
    }

    public void clickContinue(){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.waitForElement(continueButton);
        seleniumUtils.clickElement(continueButton);
    }

    public void enterPassword(String password){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.waitForElement(passwordField);
        seleniumUtils.sendKeys(passwordField,password);
    }

    public void clickLogin(){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.waitForElement(loginButton);
        seleniumUtils.clickElement(loginButton);
    }
}
