package com.bexio.noConnection;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageDurationSaveTest extends LoginTest {
public static Logger log = LogManager.getLogger(NoConnToastMessageDurationSaveTest.class.getName());
    @Test
    public void noConnDurationSave() throws InterruptedException {
        NoConnToastMessageMyBexioAddTest connectionStatus = new NoConnToastMessageMyBexioAddTest();
        Selectors noConnection = new Selectors(driver);
        noConnection.trackTime.click();
        log.info("Navigating in Track Time scene");
        noConnection.logTime.click();
        log.info("Redirecting in Log time");
        connectionStatus.disableInternetConnection();
        log.info("Disabling the internet connection");
        noConnection.saveButtonTrackTime.click();
        log.info("Tapping on save button");
        wait.until(ExpectedConditions.visibilityOf(noConnection.noConnToastMessageTrackTime));
        Assert.assertTrue(noConnection.noConnToastMessageTrackTime.isDisplayed());
        log.info("Verifying that no internet connection toast message has been displayed");
        connectionStatus.enableInternetConnection();
        log.info("Enabling the internet connection");
        Thread.sleep(4000L);
        noConnection.homeButton.click();
        log.info("Tapping on home button");
    }
}
