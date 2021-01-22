package com.bexio.logInHomeScreen;

import com.bexio.init.Selectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveExistingAccountTest extends LoginTest {
    public static Logger log = LogManager.getLogger(RemoveExistingAccountTest.class.getName());

    @Test
    public void removeExistingAccout() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,10);
        Selectors removeAccount = new Selectors(driver);

        SwitchCompanyTest removeTest = new SwitchCompanyTest();
        removeTest.addNewCompany();
        
        wait.until(ExpectedConditions.visibilityOf(removeAccount.myBexioAccounts));
        removeAccount.myBexioAccounts.click();
        log.info("Navigating in my bexio accounts scene");
        wait.until(ExpectedConditions.visibilityOf(removeAccount.myBexioRemove));
        removeAccount.myBexioRemove.click();
        removeAccount.removeButtonDialog.click();
        removeAccount.homeButton.click();
        Assert.assertTrue(removeAccount.myBexioAccounts.isDisplayed());

        removeAccount.myBexioAccounts.click();
        wait.until(ExpectedConditions.visibilityOf(removeAccount.myBexioRemove));
        removeAccount.myBexioRemove.click();
        removeAccount.removeButtonDialog.click();

        Assert.assertTrue(removeAccount.logginButton.isDisplayed());
        log.info("Verifying that login form has been displayed");

//        loginCredentials(prop.getProperty("secondCompanyName"));
        loginCredentials("#{secondCompanyName}#");
    }
}
