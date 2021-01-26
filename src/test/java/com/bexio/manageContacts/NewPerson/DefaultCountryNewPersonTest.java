package com.bexio.manageContacts.NewPerson;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import com.bexio.manageContacts.AddContactTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DefaultCountryNewPersonTest extends LoginTest {
    public static Logger log = LogManager.getLogger(DefaultCountryNewPersonTest.class.getName());

    @Test
    public void defaultCountryNewPerson(){
        defaultCountry(true);
    }

    public void defaultCountry(boolean newPerson) {
        WebDriverWait wait = new WebDriverWait(driver,10);

        Selectors defaultCountry = new Selectors(driver);
        defaultCountry.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        defaultCountry.addContactButton.click();
        log.info("Tapping on add new contact button");

//        String executionStore = prop.getProperty("store");
        String executionStore = ("#{store}#");
        if(newPerson) {
            if (executionStore.equalsIgnoreCase("android")) {
                defaultCountry.newPerson.click();
            } else {
                AddContactTest addNewPerson = new AddContactTest();
                addNewPerson.newPersonCompanyCoordinates(0.65, 0.45);
            }
            log.info("Tapping on \"New person\" button");
            wait.until(ExpectedConditions.visibilityOf(defaultCountry.lastName));
            defaultCountry.lastName.sendKeys("DefaultCountry");
            log.info("Adding the mandatory 'Last Name' field");
        }else {
            if (executionStore.equalsIgnoreCase("android")) {
                defaultCountry.newCompany.click();
            } else {
                AddContactTest addNewCompany = new AddContactTest();
                addNewCompany.newPersonCompanyCoordinates(0.65, 0.65);
            }
            log.info("Tapping on \"New company\" button");
            wait.until(ExpectedConditions.visibilityOf(defaultCountry.companyName));
            defaultCountry.companyName.sendKeys("DefaultCountry");
            log.info("Adding the mandatory 'Company Name' field");
        }

        scrollPointOption(0.6,0.1);
        scrollPointOption(0.4,0.1);
        log.info("Scrolling down until country field is visible");

        wait.until(ExpectedConditions.visibilityOf(defaultCountry.defaultCountrySwiss));
        Assert.assertTrue(defaultCountry.defaultCountrySwiss.isDisplayed());
        log.info("Verifying that Switzerland has been added by default in country field");

        defaultCountry.addContactSaveButton.click();
        Assert.assertTrue(defaultCountry.countryDetailedView.isDisplayed());
        log.info("Contact has been saved. Contact detailed view is displayed. Verifying default country(Switzerland)");
        defaultCountry.backButtonContactDetailView.click();
        log.info("Tapping on detailed view back button.");
        defaultCountry.homeButton.click();
        log.info("Home button has been tapped. Redirecting in home page");
    }
}
