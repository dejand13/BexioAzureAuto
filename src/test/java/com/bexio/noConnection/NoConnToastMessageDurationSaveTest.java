package com.bexio.noConnection;

import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import com.bexio.trackTime.Selectors_TrackTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageDurationSaveTest extends Methods_LogIn {
public static Logger log = LogManager.getLogger(NoConnToastMessageDurationSaveTest.class.getName());
    @Test
    public void noConnDurationSave() throws InterruptedException {
        Methods_TapOnCoordinate connectionControler = new Methods_TapOnCoordinate();
        Selectors_TrackTime noConnection = new Selectors_TrackTime(driver);
        noConnection.trackTime.click();
        log.info("Navigating in Track Time scene");
        noConnection.logTime.click();
        log.info("Redirecting in Log time");
        connectionControler.disableInternetConnection();
        log.info("Disabling the internet connection");
        noConnection.saveButtonTrackTime.click();
        log.info("Tapping on save button");
        wait.until(ExpectedConditions.visibilityOf(noConnection.noConnToastMessageTrackTime));
        Assert.assertTrue(noConnection.noConnToastMessageTrackTime.isDisplayed());
        log.info("Verifying that no internet connection toast message has been displayed");
        connectionControler.enableInternetConnection();
        log.info("Enabling the internet connection");
        Thread.sleep(4000L);
        noConnection.homeButton.click();
        log.info("Tapping on home button");
    }
}
