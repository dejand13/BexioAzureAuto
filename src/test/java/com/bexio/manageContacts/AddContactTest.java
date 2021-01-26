package com.bexio.manageContacts;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import java.io.IOException;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class AddContactTest extends LoginTest {
    public static Logger log = LogManager.getLogger(AddContactTest.class.getName());

    @Test
    public void manageContacts() throws IOException, InterruptedException {
        Selectors addContact = new Selectors(driver);

        addContact.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        addContact.addContactButton.click();
        log.info("Tapping on add new contact button");
        Thread.sleep(2000L);

        TouchAction touch = new TouchAction(driver);

//        String executionStore = prop.getProperty("store");
        String executionStore = ("#{store}#");
        if (executionStore.equalsIgnoreCase("android")) {
            addContact.newPerson.click();
        } else {
            AddContactTest addNewPerson = new AddContactTest();
            addNewPerson.newPersonCompanyCoordinates(0.65, 0.45);
        }
//        touch.tap(PointOption.point(300,420)).perform();

        addContact.lastName.sendKeys("Last name");
        addContact.firstName.sendKeys("First name");
        Thread.sleep(2000L);
        addContact.formOfAddress.click();
        addContact.formOfAddressMr.click();
        Thread.sleep(2000L);
//        addContact.title.click();
//        addContact.titleDr.click();
        addContact.languageOfCorrespondence.click();
        addContact.languageOfCorrItalian.click();

        addContact.email.sendKeys("ddoneski@melontech.com");
        addContact.email2.sendKeys("doneski.dejan@gmail.com");

        addContact.phone.sendKeys("00358 72 281 1200");
        addContact.phone2.sendKeys("00358 17 281 1210");
        addContact.mobile.sendKeys("00358 66 321 9843");

        addContact.website.sendKeys("www.google.com");
        addContact.address.sendKeys("Torikatu");
        addContact.postcode.sendKeys("70110");
        addContact.city.sendKeys("Kuopio");
        addContact.country.click();
        Thread.sleep(2000L);
        newPersonCompanyCoordinates(0.7, 0.001);
        addContact.countryFinland.click();
        addContact.remarks.sendKeys("Add some remarks");
        addContact.category.click();
//        addContact.categoryQA.click();
//        addContact.checkboxSaveButton.click();
//        addContact.sectors.click();
//        addContact.checkboxSaveButton.click();
        addContact.addContactSaveButton.click();
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
}
