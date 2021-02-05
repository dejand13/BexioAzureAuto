package com.bexio.trackTime;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import com.bexio.manageContacts.NewPerson.AddContactTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StopwatchTrackingSavedTest extends LoginTest {
    public static Logger log = LogManager.getLogger(StopwatchTrackingSavedTest.class.getName());
    @Test
    public void stopwatchTrackingSaved() throws InterruptedException {
        AddContactTest tapCoordinates = new AddContactTest();
        Selectors stopwatchTrack = new Selectors(driver);
        stopwatchTrack.trackTime.click();
        log.info("Navigating in Track time scene");
        stopwatchTrack.addDescriptionTrackTime.sendKeys("Stopwatch track time");
        log.info("Adding description");
        driver.hideKeyboard();
        stopwatchTrack.moreTrackTime.click();
        log.info("Expanding the more dialog");
        Thread.sleep(2000L);
        stopwatchTrack.contactTrackTime.click();
        log.info("Tapping on contact");
        stopwatchTrack.searchContactMoreDialogTrackTime.sendKeys("LastName, FirstName");
        driver.hideKeyboard();
        Thread.sleep(2000L);
        stopwatchTrack.tapOnLastNameContactTrackTime.click();
        log.info("Tapping on LastName, FirstName contact");
        stopwatchTrack.activityTrackTime.click();
        log.info("Opening Activity dialog");
        stopwatchTrack.tapOnAdministrationActivityTrackTime.click();
        log.info("Chosing Administration activity");
        stopwatchTrack.projectTrackTime.click();
        log.info("Opening Project dialog");
        stopwatchTrack.melonTestAutomationProjectTrackTime.click();
        log.info("Choosing Melon Test Automation Project");
        stopwatchTrack.workPackageTrackTime.click();
        stopwatchTrack.melonTestAutomationWorkPackageTrackTime.click();
        log.info("Choosing Melon Test Automation Work Package");
        stopwatchTrack.toggleButtonTrueTrackTime.click();
        log.info(("Enabling 'Entry can be invoiced' toggle button"));
        stopwatchTrack.lessTrackTime.click();
        log.info("Tapping on less/Closing the expanded more dialog");
        Thread.sleep(2000L);
        if(executionStore.contains("android")){
            stopwatchTrack.playButtonTackTime.click();
        } else {
            tapCoordinates.newPersonCompanyCoordinates(0.5,0.6);
        }
        log.info("Tapping on stopwatch play button");
        Thread.sleep(4000L);
        tapCoordinates.newPersonCompanyCoordinates(0.5,0.6);
        log.info("Tapping on stopwatch pause button");
        stopwatchTrack.saveButtonTrackTime.click();
        log.info("Tapping on save button");
        Assert.assertTrue(stopwatchTrack.savedSymbolTrackTime.isDisplayed());
        stopwatchTrack.viewTimeTrackToastMessage.click();
        log.info("Tapping View button on save tracking toast message");
        Assert.assertTrue(stopwatchTrack.todayCreatedTrackingOverview.isDisplayed());
        stopwatchTrack.homeButton.click();
        log.info("Tapping on home button");
    }
}
