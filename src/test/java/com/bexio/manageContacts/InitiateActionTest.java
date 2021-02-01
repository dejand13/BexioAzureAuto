package com.bexio.manageContacts;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import com.bexio.manageContacts.NewCompany.SearchContactCompanyTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class InitiateActionTest extends LoginTest {
    public static Logger log = LogManager.getLogger(SearchContactCompanyTest.class.getName());

    @Test
    public void initiateAction() throws MalformedURLException, InterruptedException {
        Selectors initiateAction = new Selectors(driver);
        initiateAction.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");

        initiateAction.searchBar.sendKeys("Company name");
        Assert.assertTrue(initiateAction.searchCompanyResultName.isDisplayed());
        log.info("Searching for 'Company name Name suffix' contact");

        driver.hideKeyboard();
        initiateAction.searchCompanyResultName.click();
        log.info("Tapping on the contact so the detailed view will be opened");

        initiateAction.emailIcon.click();
        log.info("Tapping on email symbol");
//        Assert.assertTrue(initiateAction.tapMailSymbol.isDisplayed());
        log.info("User is redirected outside of the app. Email app is opened");
        driver.activateApp("com.bexio.bxBexio");
        log.info("Navigating back to the app");

        initiateAction.phoneIcon.click();
        log.info("Tapping on phone call symbol");
        Assert.assertTrue(initiateAction.callNumber.isDisplayed());
        if(executionStore.contains("android")) {
            driver.activateApp("com.bexio.bxBexio");
            log.info("Navigating back to the app");
        }
        else {
            Assert.assertTrue(initiateAction.cancelCallNumber.isDisplayed());
            log.info("Call XXX dialog is opened");
            initiateAction.cancelCallNumber.click();
            log.info("Tapping on cancel button");
        }
        initiateAction.mobilePhoneIcon.click();
        log.info("Tapping on mobile phone call symbol");
        Assert.assertTrue(initiateAction.callNumber.isDisplayed());
        if(executionStore.contains("android")) {
            driver.activateApp("com.bexio.bxBexio");
            log.info("Navigating back to the app");
        }
        else {
            Assert.assertTrue(initiateAction.cancelCallNumber.isDisplayed());
            log.info("Call XXX dialog is opened");
            initiateAction.cancelCallNumber.click();
            log.info("Tapping on cancel button");
        }

        initiateAction.mobileMessageIcon.click();
        Assert.assertTrue(initiateAction.tapMessageChatSymbol.isDisplayed());
        log.info("User is redirected outside of the app. Messages app is opened");
        driver.activateApp("com.bexio.bxBexio");
        log.info("Navigating back to the app");

        initiateAction.locationIcon.click();
        Assert.assertTrue(initiateAction.tapLocationSymbol.isDisplayed());
        log.info("User is redirected outside of the app. Maps app is opened");
        driver.activateApp("com.bexio.bxBexio");
        log.info("Navigating back to the app");

        initiateAction.backButtonContactDetailView.click();
        log.info("Navigating back to Manage contacts scene");
        initiateAction.homeButton.click();
        log.info("Navigating back to home screen");
    }
}
