package com.bexio.manageContacts;

import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import com.bexio.manageContacts.NewPerson.SearchContactPersonTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoContactsFoundTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(SearchContactPersonTest.class.getName());

    @Test
    public void noContactsFound() {
        LogIn_Selectors searchContact = new LogIn_Selectors(driver);
        String randomString = RandomStringUtils.randomAlphabetic(12);
        searchContact.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");

        wait.until(ExpectedConditions.visibilityOf(searchContact.searchBar));
        searchContact.searchBar.sendKeys(randomString);
        log.info("Sending some random string as contact filter");
        wait.until(ExpectedConditions.visibilityOf(searchContact.noContactsFound));
        Assert.assertTrue(searchContact.noContactsFound.isDisplayed());
        log.info(" 'No contacts found' message is displayed");

        searchContact.homeButton.click();
        log.info("Navigating on home screen");
    }
}
