package com.bexio.manageContacts;

import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import com.bexio.manageContacts.NewCompany.SearchContactCompanyTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CopiedToClipboardText extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(SearchContactCompanyTest.class.getName());

    @Test
    public void copiedToClipboard() throws InterruptedException {
        LogIn_Selectors copiedToClipboard = new LogIn_Selectors(driver);
        copiedToClipboard.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");

        copiedToClipboard.searchBar.sendKeys("Company name Name suffix");
        log.info("Searching for 'Company name Name suffix' contact");
        driver.hideKeyboard();
        copiedToClipboard.searchCompanyResultName.click();
        log.info("Tapping on the company to open detailed view");

        TouchAction touch = new TouchAction(driver);
        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(copiedToClipboard.copiedToClipboardEmail)).withDuration(Duration.ofSeconds(2))).release().perform();
        Assert.assertTrue(copiedToClipboard.copiedToClipboard.isDisplayed());
        log.info("Email address has been copied");

        Thread.sleep(4000L);
        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(copiedToClipboard.copiedToClipboardEmail2)).withDuration(Duration.ofSeconds(2))).release().perform();
        Assert.assertTrue(copiedToClipboard.copiedToClipboard.isDisplayed());
        log.info("Second email address has been copied");
        Thread.sleep(4000L);

        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(copiedToClipboard.copiedToClipboardPhone)).withDuration(Duration.ofSeconds(2))).release().perform();
        Assert.assertTrue(copiedToClipboard.copiedToClipboard.isDisplayed());
        log.info("Phone number has been copied");
        Thread.sleep(4000L);

        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(copiedToClipboard.copiedToClipboardMobile)).withDuration(Duration.ofSeconds(2))).release().perform();
        Assert.assertTrue(copiedToClipboard.copiedToClipboard.isDisplayed());
        log.info("Mobile number has been copied");
        Thread.sleep(4000L);

        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(copiedToClipboard.copiedToClipboardSwitzerland)).withDuration(Duration.ofSeconds(2))).release().perform();
        Assert.assertTrue(copiedToClipboard.copiedToClipboard.isDisplayed());
        log.info("Location has been copied");
        Thread.sleep(4000L);

        copiedToClipboard.backButtonContactDetailView.click();
        log.info("Navigate back to manage contacts screen");
        copiedToClipboard.homeButton.click();
        log.info("Navigate to home screen");
    }
}
