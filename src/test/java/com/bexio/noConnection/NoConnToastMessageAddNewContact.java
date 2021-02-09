package com.bexio.noConnection;

import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import com.bexio.logIn.LogIn_Selectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageAddNewContact extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(NoConnToastMessageAddNewContact.class.getName());

    @Test
    public void noConnToastAddNewContact() throws InterruptedException {
        LogIn_Selectors noConnection = new LogIn_Selectors(driver);
        Methods_TapOnCoordinate connectionControler = new Methods_TapOnCoordinate();

        noConnection.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        noConnection.addContactButton.click();
        log.info("Tapping on add new contact button");
        Thread.sleep(2000L);
        connectionControler.createNewPersonOrCompanyDialog(0.65,0.45);
        connectionControler.disableInternetConnection();
        noConnection.lastName.sendKeys("Last name");
        noConnection.addContactSaveButton.click();
        wait.until(ExpectedConditions.visibilityOf(noConnection.myBexioNoInternetToastMessage));
        Assert.assertTrue(noConnection.myBexioNoInternetToastMessage.isDisplayed());

        connectionControler.enableInternetConnection();
        Thread.sleep(7000L);
        noConnection.addContactSaveButton.click();
        Assert.assertTrue(noConnection.locationIcon.isDisplayed());
        noConnection.backButtonContactDetailView.click();
        noConnection.homeButton.click();
    }
}
