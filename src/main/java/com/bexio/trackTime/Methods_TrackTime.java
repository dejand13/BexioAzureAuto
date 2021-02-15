package com.bexio.trackTime;

import com.bexio.init.DriverInit;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Methods_TrackTime extends DriverInit {
    public static Logger log = LogManager.getLogger(Methods_TrackTime.class.getName());
    Selectors_TrackTime trackTimeSelector = new Selectors_TrackTime(driver);
    Methods_TapOnCoordinate tapOnCoordinate = new Methods_TapOnCoordinate();
    public static WebDriverWait wait;

    public void expandMoreDialog(String description) throws InterruptedException {
        trackTimeSelector.addDescriptionTrackTime.sendKeys(description);
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
        wait = new WebDriverWait(driver,10);
        Methods_TapOnCoordinate tapOnCoordinates = new Methods_TapOnCoordinate();
        wait.until(ExpectedConditions.visibilityOf(trackTimeSelector.moreTrackTime));
        if (executionStore.contains("android")) {
            trackTimeSelector.playButtonTackTime.click();
        } else {
            tapOnCoordinates.tapOnCoordinate(0.5, 0.6);
        }
        log.info("Tapping on stopwatch play button");
        Thread.sleep(4000L);
        tapOnCoordinates.tapOnCoordinate(0.5, 0.6);
        log.info("Tapping on stopwatch pause button");
        wait.until(ExpectedConditions.visibilityOf(trackTimeSelector.saveButtonTrackTime));
        trackTimeSelector.saveButtonTrackTime.click();
        log.info("Tapping on save button");
        Assert.assertTrue(trackTimeSelector.savedSymbolTrackTime.isDisplayed());
        trackTimeSelector.viewTimeTrackToastMessage.click();
        log.info("Tapping View button on save tracking toast message");
        Assert.assertTrue(trackTimeSelector.todayCreatedTrackingOverview.isDisplayed());
        Assert.assertTrue(trackTimeSelector.verifyStopwatchTrackTimeEntryCreatedInOverview.isDisplayed());
    }
    public void setDurationOrRangeWheelPickers(boolean durationWheelPickerIsUsed) throws InterruptedException {
        if(durationWheelPickerIsUsed) {
            trackTimeSelector.openDurationTimeWheelPicker.click();
        } else {
            trackTimeSelector.fromToLogTime.click();
            trackTimeSelector.endTimeRangeTrackTime.click();
        }
        Thread.sleep(2000L);
        tapOnCoordinate.swipeByYAxisUsingCoordinates(0.256,0.4921,0.396);
        tapOnCoordinate.swipeByYAxisUsingCoordinates(0.647,0.4921,0.396);
        log.info("Changing end time - minutes and hours");
        Thread.sleep(2000L);
        trackTimeSelector.saveButtonTrackTime.click();
        log.info("Saving entered time for the record and closing the wheel picker dialog");
        Thread.sleep(2000L);

        if(durationWheelPickerIsUsed){
            if(executionStore.contains("android")){
                trackTimeSelector.openDurationDateWheelPicker.click();
            } else{
                tapOnCoordinate.tapOnCoordinate(0.7,0.540);
            }
        } else {
            if(executionStore.contains("android")) {
                trackTimeSelector.openFromToDateWheelPicker.click();
            } else{
                tapOnCoordinate.tapOnCoordinate(0.7,0.598);
            }
        }
        log.info("Opening durationWheelPickerIsUsed date wheel picker");
        Thread.sleep(2000L);
        tapOnCoordinate.swipeByYAxisUsingCoordinates(0.24,0.4921,0.396);
        Thread.sleep(2000L);
        log.info("Changing date");
        tapOnCoordinate.swipeByYAxisUsingCoordinates(0.49,0.4921,0.396);
        Thread.sleep(2000L);
        log.info("Changing month");
        tapOnCoordinate.swipeByYAxisUsingCoordinates(0.756,0.4921,0.396);
        log.info("Changing year");
        Thread.sleep(2000L);
        trackTimeSelector.saveButtonTrackTime.click();
        log.info("Saving entered date for the record and closing the wheel picker dialog");
        Thread.sleep(2000L);
    }
    public void saveAndValidateAddedEntryInOverview(boolean durationTimeTrackingIsUsed){
        trackTimeSelector.saveButtonTrackTime.click();
        log.info("Saving the entry");
        Assert.assertTrue(trackTimeSelector.savedSymbolTrackTime.isDisplayed());
        trackTimeSelector.viewTimeTrackToastMessage.click();
        log.info("Tapping View button on save tracking toast message");
        if(durationTimeTrackingIsUsed){
            Assert.assertTrue(trackTimeSelector.verifyDurationTrackTimeEntryCreatedInOverview.isDisplayed());
        } else {
            Assert.assertTrue(trackTimeSelector.todayCreatedTrackingOverview.isDisplayed());
            Assert.assertTrue(trackTimeSelector.verifyFromToTrackTimeEntryCreatedInOverview.isDisplayed());
        }
        trackTimeSelector.homeButton.click();
        log.info("Tapping on home button");
    }
}
