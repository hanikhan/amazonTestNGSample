package com.tests.Tests;

import com.tests.Tests.launcher.TestNGTest;
import com.tests.pages.*;
import org.testng.annotations.Test;

public class testCase extends TestNGTest {

    @Test
    public void testWishList() throws Exception{
        amazonHomePage homePage = new amazonHomePage(driver);
        amazonLoginPage loginPage = new amazonLoginPage(driver);
        amazonProductPage productPage = new amazonProductPage(driver);
        amazonSearchResultsPage searchResultsPage = new amazonSearchResultsPage(driver);
        amazonWishListPage wishListPage = new amazonWishListPage(driver);

        //Wait 30 seconds for page load to complete
        homePage.waitUntilPageLoaded(30);

        //Click on the sign in Button on the homepage
        homePage.clickSigninButton();

        //Fetch environment variables
        String loginEmail = System.getenv("AMAZON_USERNAME");
        String loginPassword = System.getenv("AMAZON_PASSWORD");
        String searchString = System.getenv("SEARCH_STRING");

        //Enter Login details
        loginPage.enterEmail(loginEmail);
        loginPage.clickContinue();
        loginPage.enterPassword(loginPassword);
        loginPage.clickLogin();

        //Wait 30 seconds for page load to complete
        homePage.waitUntilPageLoaded(30);

        //Enter search string and click search
        homePage.SendKeysToSearchBar(searchString);
        homePage.clickSearchButton();

        //Verify search string against search results
        searchResultsPage.verifySearchResults(searchString);

        //Navigate to page 2 of search results
        searchResultsPage.clickPageIndexTwo();

        //Select product at index 2(third product on page 2)
        searchResultsPage.selectSearchResult(2);

        //Add product to wishlist
        productPage.addToListClick();
        productPage.chooseWishList();

        //Check for product on wishlist page
        wishListPage.checkRelaventWishResult(searchString);

        //Remove product from wishlist
        wishListPage.deleteWishListItem();

        //Confirm deletion
        if(wishListPage.checkIfDeleted()){
            System.out.println("Product Deleted successfully from wishlist");
        }
    }
}
