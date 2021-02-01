package com.bexio.manageContacts.NewPerson;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;

public class AddContactTest extends LoginTest {
    public static Logger log = LogManager.getLogger(AddContactTest.class.getName());

    @Test
    public void addNewPerson() throws IOException, InterruptedException {
        addNewPersonCompany(true);
    }

    public void addNewPersonCompany(boolean newPerson) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        Selectors addContact = new Selectors(driver);

        addContact.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        addContact.addContactButton.click();
        log.info("Tapping on add new contact button");
        Thread.sleep(2000L);

        TouchAction touch = new TouchAction(driver);
        if(newPerson) {
            if (executionStore.equalsIgnoreCase("android")) {
                addContact.newPerson.click();
            } else {
                AddContactTest addNewPerson = new AddContactTest();
                addNewPerson.newPersonCompanyCoordinates(0.65, 0.45);
                //        touch.tap(PointOption.point(300,420)).perform();
            }
            addContact.lastName.sendKeys("Last name");
            addContact.firstName.sendKeys("First name");
//        addContact.formOfAddress.click();
//        addContact.formOfAddressMr.click();
//        addContact.title.click();
//        addContact.titleDr.click();
        } else {
            if (executionStore.equalsIgnoreCase("android")) {
                addContact.newCompany.click();
            } else {
                AddContactTest addNewPerson = new AddContactTest();
                addNewPerson.newPersonCompanyCoordinates(0.65, 0.52);
                //        touch.tap(PointOption.point(300,420)).perform();
            }
            addContact.companyName.sendKeys("Company name");
            addContact.nameSuffix.sendKeys("Name suffix");
        }

        addContact.languageOfCorrespondence.click();
        addContact.languageOfCorrItalian.click();
        addContact.email.sendKeys("emailPerson@email.com");
        addContact.email2.sendKeys("email.person@email.com");
        scrollPointOption(0.6,0.1);
        addContact.phone.sendKeys("00358 72 281 1200");
        addContact.phone2.sendKeys("00358 17 281 1210");
        addContact.mobile.sendKeys("00358 66 321 9843");
        addContact.website.sendKeys("www.google.com");
        scrollPointOption(0.6,0.1);
        addContact.address.sendKeys("Torikatu");
        addContact.postcode.sendKeys("70110");
        addContact.city.sendKeys("Kuopio");
        addContact.country.click();
        Thread.sleep(2000L);
        scrollPointOption(0.6,0.1);
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
    public void newPersonCompanyCoordinates(double widthPercentage, double heightPercentage) {
        int widthOfScreen = driver.manage().window().getSize().getWidth();
        int heightOfScreen = driver.manage().window().getSize().getHeight();
        int x = (int) (widthOfScreen * widthPercentage);
        int y = (int) (heightOfScreen * heightPercentage);

        TouchAction touch = new TouchAction(driver);
        touch.tap(PointOption.point(x,y)).perform();
    }
    public void newPersonCompanyDialog() {
        Selectors addContact = new Selectors(driver);
        if (executionStore.equalsIgnoreCase("android")) {
            addContact.newPerson.click();
        } else {
            AddContactTest addNewPerson = new AddContactTest();
            addNewPerson.newPersonCompanyCoordinates(0.65, 0.45);
//        touch.tap(PointOption.point(300,420)).perform();
        }
    }
}
