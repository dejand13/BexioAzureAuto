package com.bexio.noConnection;

import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import com.bexio.trackTime.Selectors_TrackTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageFromToSaveTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(NoConnToastMessageFromToSaveTest.class.getName());
    @Test
    public void NoConnToastMessageFromToSave() throws InterruptedException {
        Methods_TapOnCoordinate tapOnCoordinate = new Methods_TapOnCoordinate();
        Selectors_TrackTime noConnection = new Selectors_TrackTime(driver);

        noConnection.trackTime.click();
        log.info("Redirecting in track time scene");
        noConnection.logTime.click();
        log.info("Navigating in Log time sub menu from Track Time");
        noConnection.fromToLogTime.click();
        log.info("Navigating in From-To sub menu from Log Time");
        tapOnCoordinate.disableInternetConnection();
        log.info("Disabling internet connection");
        noConnection.endTimeRangeTrackTime.click();
        log.info("Time wheel picker is opened");
        Thread.sleep(2000L);
        tapOnCoordinate.swipeByYAxisUsingCoordinates(0.256,0.4921,0.396);
        //441 355
        tapOnCoordinate.swipeByYAxisUsingCoordinates(0.647,0.4921,0.396);
        log.info("Changing end time - minutes and hours");
        Thread.sleep(2000L);
        noConnection.saveButtonTrackTime.click();
        log.info("Tapping on wheel picker dialog save button");
        Thread.sleep(2000L);
        noConnection.saveButtonTrackTime.click();
        log.info("Tapping on Log Time, From-To save button");
        Assert.assertTrue(noConnection.savedNotUploadedExplanationMark.isDisplayed());
        tapOnCoordinate.enableInternetConnection();
        log.info("Enabling internet connection");
        Thread.sleep(4000L);
        noConnection.homeButton.click();
        log.info("Tapping on home button");

    }
}
