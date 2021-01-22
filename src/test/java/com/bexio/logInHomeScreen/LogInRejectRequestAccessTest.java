package com.bexio.logInHomeScreen;

import com.bexio.init.DriverInit;
import com.bexio.init.Selectors;
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
//        Fulfilling the text boxes and logging in
        Selectors loginPage = new Selectors(driver);

        try {
            loginPage.allowNotificationDialog.isDisplayed();
            driver.switchTo().alert().accept();
            log.info("Allow notifications dialog has been accepted");
        } catch (Exception e) {
            log.info("Allow notification dialog is not displayed on android");
        }
//        loginPage.password.sendKeys(prop.getProperty("pass"));
            loginPage.password.sendKeys("#{pass}#");
//        loginPage.username.sendKeys(prop.getProperty("username"));
            loginPage.username.sendKeys("#{username}#");
        loginPage.logginButton.click();
        log.info("Credentials has been added and login button is tapped");

        wait.until(ExpectedConditions.visibilityOf(loginPage.availabilityOfLogInCompanyNamesList));
//        Choosing the desired company from the multiple companies
//        String comName = prop.getProperty("secondCompanyName");
            String comName = ("#{secondCompanyName}#");
        Boolean companyFound = false;
        for (int i = 0; i < loginPage.logInCompanyNamesList.size(); i++) {
            while(loginPage.logInCompanyNamesList.get(i).getText().contains(comName)) {
                loginPage.logInCompanyNamesList.get(i).click();
                companyFound = true;
                break;
            }
        }
        if(companyFound == false) {
            log.error("It appears that the desired company does NOT exist in this account");
            throw new Exception("It appears that the desired company does NOT exist in this account");
        }

        Assert.assertTrue(loginPage.allowAccessToCompany.isDisplayed());

        loginPage.rejectAccess.click();
        log.info("Requested access has been rejected for: " + comName + "company");
        Assert.assertTrue(loginPage.forgotPassLogInLink.isDisplayed());
        log.info("User is redirected on login page");
    }
}
