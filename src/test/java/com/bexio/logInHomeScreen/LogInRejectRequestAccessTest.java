package com.bexio.logInHomeScreen;

import com.bexio.init.DriverInit;
import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInRejectRequestAccessTest extends DriverInit {
    public static Logger log = LogManager.getLogger(LogInRejectRequestAccessTest.class.getName());
    @Test    
    public void logInRejectRequestAccess() throws Exception {
        initDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        LogIn_Selectors loginPage = new LogIn_Selectors(driver);
        Methods_LogIn login = new Methods_LogIn();

        login.loginCredentials(secondCompanyName,"reject");
        wait.until(ExpectedConditions.visibilityOf(loginPage.forgotPassLogInLink));
        Assert.assertTrue(loginPage.forgotPassLogInLink.isDisplayed());
        log.info("User is redirected on login page");
    }
}
