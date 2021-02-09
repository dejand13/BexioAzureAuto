package com.bexio.manageContacts.NewPerson;

import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchContactPersonTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(SearchContactPersonTest.class.getName());

    @Test
    public void searchContactPerson() {
        LogIn_Selectors searchContact = new LogIn_Selectors(driver);
        searchContact.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");

        searchContact.searchBar.sendKeys("LastName");
        Assert.assertTrue(searchContact.personAvatar.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultEmail.isDisplayed());
        log.info("Desired contact has been searched by last name");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("FirstName");
        Assert.assertTrue(searchContact.personAvatar.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultEmail.isDisplayed());
        log.info("Desired contact has been searched by first name");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("EmailPersonVer@email.com");
        Assert.assertTrue(searchContact.personAvatar.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultEmail.isDisplayed());
        log.info("Desired contact has been searched by email");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("00024271431");
        Assert.assertTrue(searchContact.personAvatar.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultEmail.isDisplayed());
        log.info("Desired contact has been searched by phone");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("0038977884455");
        Assert.assertTrue(searchContact.personAvatar.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchContactResultEmail.isDisplayed());
        log.info("Desired contact has been searched by mobile phone");

        searchContact.homeButton.click();
        log.info("Navigating on home screen");
    }
}