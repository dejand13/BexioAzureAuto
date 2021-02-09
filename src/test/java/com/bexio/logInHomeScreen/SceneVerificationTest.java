package com.bexio.logInHomeScreen;

import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import com.bexio.trackTime.Selectors_TrackTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SceneVerificationTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(SceneVerificationTest.class.getName());
    @Test
    public void sceneVerification() throws InterruptedException {
        LogIn_Selectors sceneVerification = new LogIn_Selectors(driver);
        Selectors_TrackTime sceneVerificationTT = new Selectors_TrackTime(driver);
        Assert.assertTrue(sceneVerification.manageContacts.isDisplayed());
        log.info("Verifying that Manage Contacts scene is displayed");
        sceneVerification.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        Assert.assertTrue(sceneVerification.searchBar.isDisplayed());
        sceneVerification.homeButton.click();
        log.info("Tapping on home button");

        Thread.sleep(2000L);
        Assert.assertTrue(sceneVerification.scanDocuments.isDisplayed());
        log.info("Verifying that Scan Documents scene is displayed");
        sceneVerification.scanDocuments.click();
        log.info("Navigating in Scan Documents scene");
        Assert.assertTrue(sceneVerification.scanSendToInbox.isDisplayed());
        sceneVerification.homeButton.click();
        log.info("Tapping on home button");

        Thread.sleep(2000L);
        Assert.assertTrue(sceneVerification.trackTime.isDisplayed());
        log.info("Verifying that Track Time scene is displayed");
        sceneVerification.trackTime.click();
        log.info("Navigating in Track Time scene");
        Assert.assertTrue(sceneVerificationTT.stopwatch.isDisplayed());
        sceneVerification.homeButton.click();
        log.info("Tapping on home button");
    }
}
