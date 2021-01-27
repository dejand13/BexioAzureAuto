package com.bexio.manageContacts.NewPerson;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailValidationNewPersonTest extends LoginTest {
    public static Logger log = LogManager.getLogger(EmailValidationNewPersonTest.class.getName());

    @Test
    public void emailValidationNewPerson() throws Exception {
        emailValidation(true);
    }

    public void emailValidation(boolean newPerson) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,10);
        Selectors validation = new Selectors(driver);

        validation.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        validation.addContactButton.click();
        log.info("Tapping on add new contact button");

//        String executionStore = prop.getProperty("store");
        String executionStore = ("#{store}#");
        if(newPerson) {
            if (executionStore.equalsIgnoreCase("android")) {
                validation.newPerson.click();
            } else {
                AddContactTest addNewPerson = new AddContactTest();
                addNewPerson.newPersonCompanyCoordinates(0.65, 0.45);
            }
            log.info("Tapping on \"New person\" button");
            wait.until(ExpectedConditions.visibilityOf(validation.lastName));
            validation.lastName.sendKeys("Last name");
            log.info("Adding last name");
        } else {
            if (executionStore.equalsIgnoreCase("android")) {
                validation.newCompany.click();
            } else {
                AddContactTest newCompany = new AddContactTest();
                newCompany.newPersonCompanyCoordinates(0.65, 0.52);
            }
            log.info("Tapping on \"New company\" button");
            wait.until(ExpectedConditions.visibilityOf(validation.companyName));
            validation.companyName.sendKeys("Company name");
            log.info("Adding company name");
        }

        validation.email.sendKeys("invalidEmail");
        log.info("Adding invalid email address");

        validation.addContactSaveButton.click();
        log.info("Tapping on save button");

        Assert.assertTrue(validation.emailAddressValidation.getSize().getHeight()>0);
        log.info(" 'This email address is not valid' error message is displayed");
        validation.invalidEmailTextBox.clear();
        validation.email.sendKeys("email@gmail.com");
        log.info("Adding valid email address for the second email address field");

        validation.email2.sendKeys("email");
        log.info("Adding invalid email address in the second email address field");
        validation.addContactSaveButton.click();
        log.info("Tapping on save button");

        Assert.assertTrue(validation.emailAddressValidation.getSize().getHeight()>0);
        log.info(" 'This email address is not valid' error message is displayed");
        validation.invalidEmail2TextBox.clear();
        validation.email2.sendKeys("email@gmail.com");
        log.info("Adding valid email address for the second email address field");

        validation.addContactSaveButton.click();
        log.info("Tapping on save button");

        wait.until(ExpectedConditions.visibilityOf(validation.editButton));
        Assert.assertTrue(validation.editButton.isDisplayed());
        log.info("Verifying that contact has been added and user is redirected in detailed view screen");

        validation.backButtonContactDetailView.click();
        validation.homeButton.click();
        log.info("Navigating on home page");
    }
}
