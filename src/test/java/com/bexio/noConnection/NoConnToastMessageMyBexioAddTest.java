package com.bexio.noConnection;

import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageMyBexioAddTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(NoConnToastMessageMyBexioAddTest.class.getName());

    @Test
    public void NoConnToastMessageMyBexioAdd() throws InterruptedException {
        LogIn_Selectors noConnection = new LogIn_Selectors(driver);
        Methods_TapOnCoordinate connectionControler = new Methods_TapOnCoordinate();
        connectionControler.disableInternetConnection();

        wait.until(ExpectedConditions.visibilityOf(noConnection.myBexioAccounts));
        noConnection.myBexioAccounts.click();
        noConnection.myBexioAccAddCompany.click();
        Assert.assertTrue(noConnection.myBexioNoInternetToastMessage.isDisplayed());

        connectionControler.enableInternetConnection();
        Thread.sleep(4000L);
        noConnection.homeButton.click();
    }
}
