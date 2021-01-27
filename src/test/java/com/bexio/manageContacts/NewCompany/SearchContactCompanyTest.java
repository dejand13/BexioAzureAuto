package com.bexio.manageContacts.NewCompany;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchContactCompanyTest extends LoginTest {
    public static Logger log = LogManager.getLogger(SearchContactCompanyTest.class.getName());

    @Test
    public void searchContactCompany() {
        Selectors searchContact = new Selectors(driver);
        searchContact.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");

        searchContact.searchBar.sendKeys("Company name");
        Assert.assertTrue(searchContact.companyAvatar.isDisplayed());
        Assert.assertTrue(searchContact.searchCompanyResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchCompanyResultEmail.isDisplayed());
        log.info("Desired contact has been searched by company name");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("Name suffix");
        Assert.assertTrue(searchContact.companyAvatar.isDisplayed());
        Assert.assertTrue(searchContact.searchCompanyResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchCompanyResultEmail.isDisplayed());
        log.info("Desired contact has been searched by first name");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("EmailComVer@email.com");
        Assert.assertTrue(searchContact.companyAvatar.isDisplayed());
        Assert.assertTrue(searchContact.searchCompanyResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchCompanyResultEmail.isDisplayed());
        log.info("Desired contact has been searched by email");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("0002444555");
        Assert.assertTrue(searchContact.companyAvatar.isDisplayed());
        Assert.assertTrue(searchContact.searchCompanyResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchCompanyResultEmail.isDisplayed());
        log.info("Desired contact has been searched by phone");

        searchContact.searchBar.clear();
        log.info("Clearing the search bar");
        searchContact.searchBar.sendKeys("0038979333444");
        Assert.assertTrue(searchContact.companyAvatar.isDisplayed());
        Assert.assertTrue(searchContact.searchCompanyResultName.isDisplayed());
        Assert.assertTrue(searchContact.searchCompanyResultEmail.isDisplayed());
        log.info("Desired contact has been searched by mobile phone");

        searchContact.homeButton.click();
        log.info("Navigating on home screen");
    }
}
