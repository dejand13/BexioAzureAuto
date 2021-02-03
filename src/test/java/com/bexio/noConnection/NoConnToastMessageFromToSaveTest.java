package com.bexio.noConnection;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageFromToSaveTest extends LoginTest {
    public static Logger log = LogManager.getLogger(NoConnToastMessageFromToSaveTest.class.getName());
    @Test
    public void NoConnToastMessageFromToSave() throws InterruptedException {
        LoginTest scroller = new LoginTest();
        NoConnToastMessageMyBexioAddTest connectionStatus = new NoConnToastMessageMyBexioAddTest();
        Selectors noConnection = new Selectors(driver);
        noConnection.trackTime.click();
        log.info("Redirecting in track time scene");
        noConnection.logTime.click();
        log.info("Navigating in Log time sub menu from Track Time");
        noConnection.fromToLogTime.click();
        log.info("Navigating in From-To sub menu from Log Time");
        connectionStatus.disableInternetConnection();
        log.info("Disabling internet connection");
        noConnection.endTimeRangeTrackTime.click();
        log.info("Time wheel picker is opened");
        Thread.sleep(2000L);
        scroller.scrollPointOption(0.256,0.4921,0.396);
        //441 355
        scroller.scrollPointOption(0.647,0.4921,0.396);
        log.info("Changing end time - minutes and hours");
        Thread.sleep(2000L);
        noConnection.saveButtonTrackTime.click();
        log.info("Tapping on wheel picker dialog save button");
        Thread.sleep(2000L);
        noConnection.saveButtonTrackTime.click();
        log.info("Tapping on Log Time, From-To save button");
        Assert.assertTrue(noConnection.savedNotUploadedExplanationMark.isDisplayed());
        connectionStatus.enableInternetConnection();
        log.info("Enabling internet connection");
        Thread.sleep(4000L);
        noConnection.homeButton.click();
        log.info("Tapping on home button");

    }
}
