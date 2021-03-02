package com.bexio.trackTime;

import com.bexio.logIn.Methods_LogIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LogTimeDurationTrackingSavedTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(LogTimeDurationTrackingSavedTest.class.getName());
    @Test
    public void logTimeTrackingSaved() throws InterruptedException {
        Methods_TrackTime trackTime = new Methods_TrackTime();
        Selectors_TrackTime navigateTo = new Selectors_TrackTime(driver);

        navigateTo.trackTime.click();
        log.info("Navigating in Track time scene");
        navigateTo.logTime.click();
        log.info("Tapping on Log Time button on the bottom submenu");
        wait.until(ExpectedConditions.visibilityOf(navigateTo.saveButtonTrackTime));
        trackTime.expandMoreDialog("Log Time - Duration track time");
        trackTime.setDurationOrRangeWheelPickers(true);
        trackTime.saveAndValidateAddedEntryInOverview(true);
    }
}
