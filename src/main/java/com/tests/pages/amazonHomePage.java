package com.tests.pages;

import org.openqa.selenium.WebDriver;
import utils.common.SeleniumUtils;
import utils.common.WebpageElements;

public class amazonHomePage {
    public WebDriver driver ;

    public amazonHomePage(WebDriver driver) {
        this.driver=driver;
    }

    public static WebpageElements signInButton= new WebpageElements("Sign In Button","//span[contains(text(),'Hello. Sign in')]");
    public static WebpageElements searchBar = new WebpageElements("Search Bar","//input[@id='twotabsearchtextbox']");
    public static WebpageElements searchButton = new WebpageElements("Search Button","//span[@id='nav-search-submit-text']/following-sibling::input");


    public void waitUntilPageLoaded(int timeout){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.checkIfPageLoadCompleted(timeout);
    }

    public void SendKeysToSearchBar(String searchString){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.waitForElement(searchBar);
        seleniumUtils.sendKeys(searchBar,searchString);
    }

    public void clickSigninButton(){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.waitForElement(signInButton);
        seleniumUtils.clickElement(signInButton);
    }

    public void clickSearchButton(){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.waitForElement(searchButton);
        seleniumUtils.clickElement(searchButton);
    }
}
