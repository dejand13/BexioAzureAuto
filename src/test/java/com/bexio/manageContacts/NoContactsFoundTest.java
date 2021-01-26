package com.bexio.manageContacts;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoContactsFoundTest extends LoginTest {
    public static Logger log = LogManager.getLogger(SearchContactTest.class.getName());

    @Test
    public void noContactsFound() {
        WebDriverWait wait = new WebDriverWait(driver,10);

        Selectors searchContact = new Selectors(driver);

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
