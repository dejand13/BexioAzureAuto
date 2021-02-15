package com.bexio.trackTime;

import com.bexio.logIn.Methods_LogIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogTimeRangeTrackingSavedTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(LogTimeRangeTrackingSavedTest.class.getName());

    @Test
    public void logTimeRangeTrackingSaved() throws InterruptedException {
        Methods_TrackTime trackTime = new Methods_TrackTime();
        Selectors_TrackTime navigateTo = new Selectors_TrackTime(driver);

        navigateTo.trackTime.click();
        log.info("Navigating in Track time scene");
        navigateTo.logTime.click();
        log.info("Tapping on Log Time button on the bottom submenu");
        wait.until(ExpectedConditions.visibilityOf(navigateTo.saveButtonTrackTime));
        trackTime.expandMoreDialog("Log Time - From-To track time");
        trackTime.setDurationOrRangeWheelPickers(false);
        trackTime.saveAndValidateAddedEntryInOverview(false);
//        navigateTo.saveButtonTrackTime.click();
//        log.info("Saving the entry");
//        Assert.assertTrue(navigateTo.savedSymbolTrackTime.isDisplayed());
//        navigateTo.viewTimeTrackToastMessage.click();
//        log.info("Tapping View button on save tracking toast message");
//        Assert.assertTrue(navigateTo.todayCreatedTrackingOverview.isDisplayed());
//        Assert.assertTrue(navigateTo.verifyFromToTrackTimeEntryCreatedInOverview.isDisplayed());
//        navigateTo.homeButton.click();
//        log.info("Tapping on home button");
    }
}
