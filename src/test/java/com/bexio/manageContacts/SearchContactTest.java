package com.bexio.manageContacts;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchContactTest extends LoginTest {
    public static Logger log = LogManager.getLogger(SearchContactTest.class.getName());

    @Test
    public void searchContact() {
        Selectors searchContact = new Selectors(driver);
        searchContact.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");

        searchContact.searchBar.sendKeys("LastName");
        Assert.assertTrue(searchContact.searchContactResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultEmail.isDisplayed());
        log.info("Desired contact has been searched by last name");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("FirstName");
        Assert.assertTrue(searchContact.searchContactResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultEmail.isDisplayed());
        log.info("Desired contact has been searched by first name");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("Email@email.com");
        Assert.assertTrue(searchContact.searchContactResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultEmail.isDisplayed());
        log.info("Desired contact has been searched by email");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("046271431");
        Assert.assertTrue(searchContact.searchContactResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultEmail.isDisplayed());
        log.info("Desired contact has been searched by phone");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("0038972885484");
        Assert.assertTrue(searchContact.searchContactResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultEmail.isDisplayed());
        log.info("Desired contact has been searched by mobile phone");

        searchContact.homeButton.click();
        log.info("Navigating on home screen");
    }
}