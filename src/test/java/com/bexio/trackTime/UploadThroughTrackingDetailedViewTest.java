package com.bexio.trackTime;

import com.bexio.logIn.Methods_LogIn;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadThroughTrackingDetailedViewTest extends Methods_LogIn {
    @Test
    public void uploadThroughTrackingDetailedView() throws InterruptedException {
        Selectors_TrackTime navigateTo = new Selectors_TrackTime(driver);
        Methods_TrackTime trackTime = new Methods_TrackTime();

        trackTime.generateUploadFailedTracking();
        navigateTo.uploadFailedTrackTimeRecord.click();
        log.info("Tapping on failed to upload tracking");
        navigateTo.uploadSymbolOverview.click();
        log.info("Tapping on upload symbol inside the Detailed view screen");
        wait.until(ExpectedConditions.visibilityOf(navigateTo.viewTimeTrackToastMessage));
        Assert.assertTrue(navigateTo.viewTimeTrackToastMessage.isDisplayed());
        log.info("Verifying that tracking has been uploaded successfully");
        navigateTo.viewTimeTrackToastMessage.click();
        log.info("Tapping on view");
        navigateTo.homeButton.click();
        log.info("Navigating on home screen");
    }
}
