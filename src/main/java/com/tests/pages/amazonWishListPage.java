package com.tests.pages;

import org.openqa.selenium.WebDriver;
import utils.common.SeleniumUtils;
import utils.common.WebpageElements;

public class amazonWishListPage {
    public WebDriver driver ;
    public amazonWishListPage(WebDriver driver) {
        this.driver=driver;
    }

    public static WebpageElements productName= new WebpageElements("Product Name in WishList","//h3[@class='a-size-base']/a");
    public static WebpageElements deleteButton = new WebpageElements("Delete from wishlist","(//input[contains(@name,'deleteItem')])[1]");

    public boolean checkRelaventWishResult(String productToValidate){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.waitForElement(productName);
        boolean exist=false;
        if(seleniumUtils.findElement(productName).getText().toLowerCase().trim().contains(productToValidate.toLowerCase().trim())){
            exist=true;
        }
        return exist;
    }

    public void deleteWishListItem(){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.waitForElement(deleteButton);
        seleniumUtils.clickElement(deleteButton);
    }

    public boolean checkIfDeleted(){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        boolean exist=true;
        if(seleniumUtils.isVisible(productName)){
            exist=false;
        }
        return exist;
    }

}
