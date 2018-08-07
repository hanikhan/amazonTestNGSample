package com.tests.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.common.SeleniumUtils;
import utils.common.WebpageElements;

import java.util.List;

public class amazonSearchResultsPage {
    public WebDriver driver ;
    public amazonSearchResultsPage(WebDriver driver) {
        this.driver=driver;
    }

    //search results exclude sponsored ads and expert recommendations
    public static WebpageElements searchResults= new WebpageElements("Search Results","//li[contains(@id,'result') and @class='s-result-item celwidget  ']//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal']");
    public static WebpageElements pageIndexTwo = new WebpageElements("Link to Page 2","//span[@class='pagnLink']/a[text()='2']");

    public void verifySearchResults(String searchString){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        List<WebElement> elements = seleniumUtils.findElements(searchResults);
        boolean relavantResults=false;
        for(WebElement element:elements){
            if(element.getText().toLowerCase().trim().contains(searchString.toLowerCase().trim())){
                relavantResults=true;
                break;
            }
        }
        if(!relavantResults){
            throw new RuntimeException("No relavent results");
        }
    }

    public void clickPageIndexTwo(){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        try{
            for(int i=0;i<5;i++) {
                js.executeScript("window.scrollBy(0,5000)");
                if(seleniumUtils.isVisible(pageIndexTwo,20)){
                    seleniumUtils.clickElement(pageIndexTwo);
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectSearchResult(int index){
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver);
        seleniumUtils.checkIfPageLoadCompleted(30);
        seleniumUtils.waitForElement(searchResults);
        List<WebElement> elements = seleniumUtils.findElements(searchResults);
        elements.get(index).click();
    }

}