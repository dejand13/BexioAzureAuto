package com.bexio.logInHomeScreen;

import com.bexio.init.Selectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveExistingAccountTest extends LoginTest {
    public static Logger log = LogManager.getLogger(RemoveExistingAccountTest.class.getName());

    @Test
    public void removeExistingAccout() throws Exception {
        Selectors removeAccount = new Selectors(driver);
        SwitchCompanyTest removeTest = new SwitchCompanyTest();
        removeTest.addNewCompany(secondCompanyName);

        Thread.sleep(3000L);
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

        loginCredentials(secondCompanyName,"allow");
//        loginCredentials(("#{secondCompanyName}#"),"allow");
    }
}
