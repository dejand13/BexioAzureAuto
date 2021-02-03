package com.bexio.noConnection;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import com.bexio.manageContacts.NewPerson.AddContactTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageStopwatchSaveTest extends LoginTest {
    public static Logger log = LogManager.getLogger(NoConnToastMessageStopwatchSaveTest.class.getName());
    @Test
    public void noConnStopwatchSave() throws InterruptedException {
        AddContactTest tapCoordinates = new AddContactTest();
        NoConnToastMessageMyBexioAddTest connectionStatus = new NoConnToastMessageMyBexioAddTest();
        Selectors noConnection = new Selectors(driver);
        noConnection.trackTime.click();
        log.info("Navigating in Track Time scene");
        if(executionStore.contains("android")){
            noConnection.playButtonTackTime.click();
        } else {
            tapCoordinates.newPersonCompanyCoordinates(0.5,0.6);
        }
        log.info("Tapping on stopwatch play button");
        connectionStatus.disableInternetConnection();
        log.info("Disabling the internet connection");
        Thread.sleep(5000L);
//        if(executionStore.contains("android")){
//            noConnection.pauseButtonTrackTime.click();
//        } else {
        tapCoordinates.newPersonCompanyCoordinates(0.5,0.6);
//        }
        log.info("Tapping on stopwatch pause button");
        Assert.assertTrue(noConnection.saveButtonTrackTime.isDisplayed());
        log.info("Verifying that save button has been displayed");
        noConnection.saveButtonTrackTime.click();
        log.info("Tapping on save button");
        wait.until(ExpectedConditions.visibilityOf(noConnection.noConnToastMessageTrackTime));
        Assert.assertTrue(noConnection.noConnToastMessageTrackTime.isDisplayed());
        log.info("Verifying that no internet connection toast message has been displayed");
        connectionStatus.enableInternetConnection();
        Thread.sleep(4000L);
        noConnection.homeButton.click();
        log.info("Tapping on home button");
    }
}
