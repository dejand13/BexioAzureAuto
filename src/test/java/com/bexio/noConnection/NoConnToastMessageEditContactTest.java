package com.bexio.noConnection;

import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageEditContactTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(NoConnToastMessageEditContactTest.class.getName());
    @Test
    public void NoConnToastMessageEditContact() throws InterruptedException {
        LogIn_Selectors noConnection = new LogIn_Selectors(driver);
        Methods_TapOnCoordinate connectionControler = new Methods_TapOnCoordinate();
        noConnection.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        noConnection.searchBar.sendKeys("Edit Contact");
        log.info("Searching for 'Edit Contact' entry");
        driver.hideKeyboard();
        noConnection.noConnToastMessageContact.click();
        log.info("Tapping on 'Edit Contact' entry");
        connectionControler.disableInternetConnection();
        noConnection.editButton.click();
        log.info("Tapping on edit button");
        wait.until(ExpectedConditions.visibilityOf(noConnection.addContactSaveButton));
        noConnection.addContactSaveButton.click();
        log.info("Tapping on save button");
        Assert.assertTrue(noConnection.myBexioNoInternetToastMessage.isDisplayed());
        log.info("Verifying that No internet connection toast message has been displayed");
        connectionControler.enableInternetConnection();
        Thread.sleep(7000L);
        noConnection.addContactSaveButton.click();
        Thread.sleep(2000L);
        noConnection.backButtonContactDetailView.click();
        log.info("Navigating back from contact detailed view screen to manage contacts screen");
        if(executionStore.contains("android")){
            driver.navigate().back();
        } else {
            wait.until(ExpectedConditions.visibilityOf(noConnection.homeButton));
            noConnection.homeButton.click();
        }
        log.info("Navigating on home screen / Tapping on home button");
    }
}
