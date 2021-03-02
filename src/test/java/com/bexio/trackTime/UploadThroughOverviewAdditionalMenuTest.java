package com.bexio.trackTime;

import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadThroughOverviewAdditionalMenuTest extends Methods_LogIn {
    @Test
    public void uploadFailedUploadFromOverview() throws InterruptedException {
        Selectors_TrackTime navigateTo = new Selectors_TrackTime(driver);
        Methods_TrackTime trackTime = new Methods_TrackTime();
        Methods_TapOnCoordinate connectionControler = new Methods_TapOnCoordinate();

        trackTime.generateUploadFailedTracking();
        if(executionStore.contains("android")){
            connectionControler.scrollFromElementToElement(navigateTo.uploadFailedTrackTimeRecord,navigateTo.stopwatchSymbolOverview);
        } else {
            connectionControler.swipeByXAxisUsingCoordinates(0.31, 0.91, 0.24);
        }
        log.info("Opening the additional menu by swiping");
        navigateTo.uploadSymbolOverview.click();
        log.info("Tapping on upload symbol");
        wait.until(ExpectedConditions.visibilityOf(navigateTo.viewTimeTrackToastMessage));
        Assert.assertTrue(navigateTo.viewTimeTrackToastMessage.isDisplayed());
        log.info("Verifying that tracking has been uploaded successfully");
        navigateTo.viewTimeTrackToastMessage.click();
        log.info("Tapping on view");
        navigateTo.homeButton.click();
        log.info("Navigating on home screen");
    }
}
