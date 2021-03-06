package com.bexio.logInHomeScreen;

import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendFeedbackTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(SendFeedbackTest.class.getName());

    @Test
    public void sendFeedback() throws InterruptedException {
        LogIn_Selectors sendFeedback = new LogIn_Selectors(driver);
        Assert.assertTrue(sendFeedback.sendFeedback.isDisplayed());
        log.info("Verifying that Send Feedback button is displayed on the screen");
        sendFeedback.sendFeedback.click();
        log.info("Tapping on Send Feedback button");
        Assert.assertTrue(sendFeedback.sendFeedbackWeb.isDisplayed());
        log.info("Verifying that Send feedback web view is opened");
        Thread.sleep(3000L);
        driver.activateApp("com.bexio.bxBexio");
        log.info("Redirecting back to the native app");
        Assert.assertTrue(sendFeedback.sendFeedback.isDisplayed());
        log.info("Verifying that user is navigated on home screen");
    }
}
