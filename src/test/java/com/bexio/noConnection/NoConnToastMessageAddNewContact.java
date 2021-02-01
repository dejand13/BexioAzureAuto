package com.bexio.noConnection;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import com.bexio.manageContacts.NewPerson.AddContactTest;
import io.appium.java_client.TouchAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageAddNewContact extends LoginTest {
    public static Logger log = LogManager.getLogger(NoConnToastMessageAddNewContact.class.getName());

    @Test
    public void noConnToastAddNewContact() throws InterruptedException {
        Selectors noConnection = new Selectors(driver);
        TouchAction touch = new TouchAction(driver);

        noConnection.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        noConnection.addContactButton.click();
        log.info("Tapping on add new contact button");
        Thread.sleep(2000L);

        AddContactTest newPersonDialog = new AddContactTest();
        newPersonDialog.newPersonCompanyDialog();

        NoConnToastMessageMyBexioAddTest connectionControler = new NoConnToastMessageMyBexioAddTest();
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
