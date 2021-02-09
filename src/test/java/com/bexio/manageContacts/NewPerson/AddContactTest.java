package com.bexio.manageContacts.NewPerson;

import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddContactTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(AddContactTest.class.getName());

    @Test
    public void addNewPerson() throws IOException, InterruptedException {
        addNewPersonCompany(true);
    }

    public void addNewPersonCompany(boolean newPerson) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        LogIn_Selectors addContact = new LogIn_Selectors(driver);
        Methods_TapOnCoordinate tapOnCoordinate = new Methods_TapOnCoordinate();

        addContact.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        addContact.addContactButton.click();
        log.info("Tapping on add new contact button");
        Thread.sleep(2000L);

        if(newPerson) {
            tapOnCoordinate.createNewPersonOrCompanyDialog(0.65,0.45);
            addContact.lastName.sendKeys("Last name");
            addContact.firstName.sendKeys("First name");
//        addContact.formOfAddress.click();
//        addContact.formOfAddressMr.click();
//        addContact.title.click();
//        addContact.titleDr.click();
        } else {
            tapOnCoordinate.createNewPersonOrCompanyDialog(0.65,0.52);
            addContact.companyName.sendKeys("Company name");
            addContact.nameSuffix.sendKeys("Name suffix");
        }

        addContact.languageOfCorrespondence.click();
        addContact.languageOfCorrItalian.click();
        addContact.email.sendKeys("emailPerson@email.com");
        addContact.email2.sendKeys("email.person@email.com");
        tapOnCoordinate.swipeByYAxisUsingCoordinates(0.5,0.6,0.1);
        addContact.phone.sendKeys("00358 72 281 1200");
        addContact.phone2.sendKeys("00358 17 281 1210");
        addContact.mobile.sendKeys("00358 66 321 9843");
        addContact.website.sendKeys("www.google.com");
        tapOnCoordinate.swipeByYAxisUsingCoordinates(0.5,0.6,0.1);
        addContact.address.sendKeys("Torikatu");
        addContact.postcode.sendKeys("70110");
        addContact.city.sendKeys("Kuopio");
        addContact.country.click();
        Thread.sleep(2000L);
        tapOnCoordinate.swipeByYAxisUsingCoordinates(0.5,0.6,0.1);
        addContact.countryFinland.click();
        addContact.remarks.sendKeys("Add some remarks");
//        addContact.category.click();
//        addContact.categoryQA.click();
//        addContact.checkboxSaveButton.click();
//        addContact.sectors.click();
//        addContact.sector1B.click();
//        addContact.checkboxSaveButton.click();
        addContact.addContactSaveButton.click();
        wait.until(ExpectedConditions.visibilityOf(addContact.backButtonContactDetailView));
        addContact.backButtonContactDetailView.click();
        addContact.homeButton.click();
    }
}
