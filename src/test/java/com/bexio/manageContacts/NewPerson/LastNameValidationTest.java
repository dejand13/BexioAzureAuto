package com.bexio.manageContacts.NewPerson;

import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LastNameValidationTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(LastNameValidationTest.class.getName());

    @Test
    public void lastNameValidationNewPerson() throws InterruptedException {
        lastNameValidation(true);
    }

    public void lastNameValidation(boolean newPerson) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        LogIn_Selectors validation = new LogIn_Selectors(driver);
        Methods_TapOnCoordinate tapOnCoordinate = new Methods_TapOnCoordinate();

        validation.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        validation.addContactButton.click();
        log.info("Tapping on add new contact button");
        Thread.sleep(2000L);

        if(newPerson) {
            tapOnCoordinate.createNewPersonOrCompanyDialog(0.65,0.45);
            log.info("Tapping on \"New person\" button");

            validation.firstName.sendKeys("First name");
            log.info("Adding first name");
            validation.addContactSaveButton.click();
            log.info("Tapping on save button");
            Assert.assertTrue(validation.lastNameValidation.isDisplayed());

            validation.lastName.sendKeys("Last name");
            log.info("Adding last name");
        } else {
            tapOnCoordinate.createNewPersonOrCompanyDialog(0.65,0.52);
            log.info("Tapping on \"New company\" button");

            validation.nameSuffix.sendKeys("Name suffix");
            log.info("Adding company suffix");
            validation.addContactSaveButton.click();
            log.info("Tapping on save button");
            Assert.assertTrue(validation.lastNameValidation.isDisplayed());

            validation.companyName.sendKeys("Company name");
            log.info("Adding company name");
        }
        validation.addContactSaveButton.click();
        log.info("Tapping on save button again");

        wait.until(ExpectedConditions.visibilityOf(validation.editButton));
        Assert.assertTrue(validation.editButton.isDisplayed());
        log.info("Verifing that contact has been added and user is redirected in detailed view screen");

        validation.backButtonContactDetailView.click();
        validation.homeButton.click();
        log.info("Navigating on home page");
    }
}
