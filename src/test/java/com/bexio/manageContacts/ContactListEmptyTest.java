package com.bexio.manageContacts;

import com.bexio.init.DriverInit;
import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import com.bexio.manageContacts.NewPerson.AddContactTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactListEmptyTest extends DriverInit {
    public static Logger log = LogManager.getLogger(ContactListEmptyTest.class.getName());

    @Test
    public void contactListEmpty() throws Exception {
        initDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        Selectors noContacts = new Selectors(driver);

        LoginTest login = new LoginTest();
        login.loginCredentials(noContactsCompany,"allow");
        noContacts.manageContacts.click();
        log.info("User is redirected in manage contacts scene");
        wait.until(ExpectedConditions.visibilityOf(noContacts.contactListEmpty));
        Assert.assertTrue(noContacts.addContactButton.isDisplayed());
        Assert.assertTrue(noContacts.homeButton.isDisplayed());

        Assert.assertTrue(noContacts.contactListEmpty.isDisplayed());
        log.info("Contact list empty special screen is displayed");
        noContacts.addContactButton.click();
        log.info("Tapping on add contact button");

        if(executionStore.equalsIgnoreCase("android")) {
            noContacts.newPerson.click();
        } else{
            AddContactTest newPerson = new AddContactTest();
            newPerson.newPersonCompanyCoordinates(0.65,0.45);
        }
        log.info("Tapping on \"New person\" button");
        Assert.assertTrue(noContacts.lastName.isDisplayed());
        log.info("Add contact screen is displayed");
        noContacts.manageContactsXButton.click();
        Assert.assertTrue(noContacts.contactListEmpty.isDisplayed());
        log.info("User is redirected back to 'Contact list empty' special screen in manage contacts scene");
        noContacts.homeButton.click();
        log.info("Navigating on home screen");

        login.afterTestMethod();
    }
}
