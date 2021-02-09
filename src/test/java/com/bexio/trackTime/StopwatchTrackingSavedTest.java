package com.bexio.trackTime;

import com.bexio.logIn.Methods_LogIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class StopwatchTrackingSavedTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(StopwatchTrackingSavedTest.class.getName());
    @Test
    public void stopwatchTrackingSaved() throws InterruptedException {
        Methods_TrackTime trackTime = new Methods_TrackTime();
        Selectors_TrackTime navigateTo = new Selectors_TrackTime(driver);

        navigateTo.trackTime.click();
        log.info("Navigating in Track time scene");
        trackTime.expandMoreDialog();
        trackTime.createStopwatchTracking();
        navigateTo.homeButton.click();
        log.info("Tapping on home button");
    }
}
