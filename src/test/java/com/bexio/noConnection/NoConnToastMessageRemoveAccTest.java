package com.bexio.noConnection;

import com.bexio.init.Selectors;
import com.bexio.logInHomeScreen.LoginTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageRemoveAccTest extends LoginTest {
    public static Logger log = LogManager.getLogger(NoConnToastMessageRemoveAccTest.class.getName());
    @Test
    public void noConnToastMessageRemoveAcc() throws InterruptedException {
        Selectors noConnection = new Selectors(driver);
        NoConnToastMessageMyBexioAddTest connectionStatus = new NoConnToastMessageMyBexioAddTest();
        connectionStatus.disableInternetConnection();

        wait.until(ExpectedConditions.visibilityOf(noConnection.myBexioAccounts));
        noConnection.myBexioAccounts.click();
        noConnection.myBexioRemove.click();
        noConnection.removeButtonDialog.click();
        Assert.assertTrue(noConnection.myBexioNoInternetToastMessage.isDisplayed());
        connectionStatus.enableInternetConnection();
        Thread.sleep(4000L);
        noConnection.homeButton.click();
    }
}
