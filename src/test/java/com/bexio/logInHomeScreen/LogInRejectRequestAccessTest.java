package com.bexio.logInHomeScreen;

import com.bexio.init.DriverInit;
import com.bexio.init.Selectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInRejectRequestAccessTest extends DriverInit {
    public static Logger log = LogManager.getLogger(LogInRejectRequestAccessTest.class.getName());
    @Test    
    public void logInRejectRequestAccess() throws Exception {
        initDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
//        Fulfilling the text boxes and logging in
        Selectors loginPage = new Selectors(driver);

        LoginTest login = new LoginTest();
        login.loginCredentials(secondCompanyName,"reject");

        Assert.assertTrue(loginPage.forgotPassLogInLink.isDisplayed());
        log.info("User is redirected on login page");
    }
}
