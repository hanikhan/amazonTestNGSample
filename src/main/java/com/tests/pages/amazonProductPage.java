package com.tests.pages;

import org.openqa.selenium.WebDriver;
import utils.common.SeleniumUtils;
import utils.common.WebpageElements;

public class amazonProductPage {
    public WebDriver driver ;
    public amazonProductPage(WebDriver driver) {
        this.driver=driver;
    }

    public static WebpageElements addToListButton= new WebpageElements("Add to List Button","//input[@id='add-to-wishlist-button-submit']");
    public static WebpageElements wishListOption = new WebpageElements("Wish List Option - popup","//h3[text()='Wish List']/parent::span");
    public static WebpageElements createWishListButton = new WebpageElements("Create Wish List Button","//span[text()='Create List']");
    public static WebpageElements viewListButton = new WebpageElements("View List Button","//a[text()='View List']");
    public static WebpageElements viewListAlt = new WebpageElements("Alternate View List Button","//span[text()='View Your List']");

    public void addToListClick(){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.waitForElement(addToListButton);
        seleniumUtils.clickElement(addToListButton);
    }

    public void chooseWishList(){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        if(seleniumUtils.isVisible(viewListAlt)){
            seleniumUtils.clickElement(viewListAlt);
        }
        else {
            seleniumUtils.waitForElement(wishListOption);
            seleniumUtils.clickElement(wishListOption);
            seleniumUtils.waitForElement(createWishListButton);
            seleniumUtils.clickElement(createWishListButton);
            seleniumUtils.waitForElement(viewListButton);
            seleniumUtils.clickElement(viewListButton);
        }
    }
}
