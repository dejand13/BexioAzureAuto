package com.bexio.trackTime;

import com.bexio.init.DriverInit;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class Methods_TrackTime extends DriverInit {
    public static Logger log = LogManager.getLogger(Methods_TrackTime.class.getName());
    Selectors_TrackTime trackTimeSelector = new Selectors_TrackTime(driver);

    public void expandMoreDialog() throws InterruptedException {
        trackTimeSelector.addDescriptionTrackTime.sendKeys("Stopwatch track time");
        log.info("Adding description");
        driver.hideKeyboard();
        trackTimeSelector.moreTrackTime.click();
        log.info("Expanding the more dialog");
        Thread.sleep(2000L);
        trackTimeSelector.contactTrackTime.click();
        log.info("Tapping on contact");
        trackTimeSelector.searchContactMoreDialogTrackTime.sendKeys("LastName, FirstName");
        driver.hideKeyboard();
        Thread.sleep(2000L);
        trackTimeSelector.tapOnLastNameContactTrackTime.click();
        log.info("Tapping on LastName, FirstName contact");
        trackTimeSelector.activityTrackTime.click();
        log.info("Opening Activity dialog");
        trackTimeSelector.tapOnAdministrationActivityTrackTime.click();
        log.info("Chosing Administration activity");
        trackTimeSelector.projectTrackTime.click();
        log.info("Opening Project dialog");
        trackTimeSelector.melonTestAutomationProjectTrackTime.click();
        log.info("Choosing Melon Test Automation Project");
        trackTimeSelector.workPackageTrackTime.click();
        trackTimeSelector.melonTestAutomationWorkPackageTrackTime.click();
        log.info("Choosing Melon Test Automation Work Package");
        trackTimeSelector.toggleButtonTrueTrackTime.click();
        log.info(("Enabling 'Entry can be invoiced' toggle button"));
        trackTimeSelector.lessTrackTime.click();
        log.info("Tapping on less/Closing the expanded more dialog");
    }
    public void createStopwatchTracking() throws InterruptedException {
        Methods_TapOnCoordinate tapOnCoordinates = new Methods_TapOnCoordinate();
        if (executionStore.contains("android")) {
            trackTimeSelector.playButtonTackTime.click();
        } else {
            tapOnCoordinates.tapOnCoordinate(0.5, 0.6);
        }
        log.info("Tapping on stopwatch play button");
        Thread.sleep(4000L);
        tapOnCoordinates.tapOnCoordinate(0.5, 0.6);
        log.info("Tapping on stopwatch pause button");
        trackTimeSelector.saveButtonTrackTime.click();
        log.info("Tapping on save button");
        Assert.assertTrue(trackTimeSelector.savedSymbolTrackTime.isDisplayed());
        trackTimeSelector.viewTimeTrackToastMessage.click();
        log.info("Tapping View button on save tracking toast message");
        Assert.assertTrue(trackTimeSelector.todayCreatedTrackingOverview.isDisplayed());
    }
}
