package com.bexio.noConnection;

import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import com.bexio.trackTime.Selectors_TrackTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageStopwatchSaveTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(NoConnToastMessageStopwatchSaveTest.class.getName());
    @Test
    public void noConnStopwatchSave() throws InterruptedException {
        Methods_TapOnCoordinate connectionControler = new Methods_TapOnCoordinate();
        Selectors_TrackTime noConnection = new Selectors_TrackTime(driver);

        noConnection.trackTime.click();
        log.info("Navigating in Track Time scene");
        if(executionStore.contains("android")){
            noConnection.playButtonTackTime.click();
        } else {
            connectionControler.tapOnCoordinate(0.5, 0.6);
        }
        log.info("Tapping on stopwatch play button");
        connectionControler.disableInternetConnection();
        log.info("Disabling the internet connection");
        Thread.sleep(5000L);
        connectionControler.tapOnCoordinate(0.5, 0.6);
        log.info("Tapping on stopwatch pause button");
        Assert.assertTrue(noConnection.saveButtonTrackTime.isDisplayed());
        log.info("Verifying that save button has been displayed");
        noConnection.saveButtonTrackTime.click();
        log.info("Tapping on save button");
        wait.until(ExpectedConditions.visibilityOf(noConnection.noConnToastMessageTrackTime));
        Assert.assertTrue(noConnection.noConnToastMessageTrackTime.isDisplayed());
        log.info("Verifying that no internet connection toast message has been displayed");
        connectionControler.enableInternetConnection();
        Thread.sleep(4000L);
        noConnection.homeButton.click();
        log.info("Tapping on home button");
    }
}
