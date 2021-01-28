package com.bexio.logInHomeScreen;

import com.bexio.init.DriverInit;
import com.bexio.init.Selectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompanyAlreadyAddedTest extends DriverInit {
    public static Logger log = LogManager.getLogger(CompanyAlreadyAddedTest.class.getName());

    @Test
    public void companyAlreadyAdded() throws Exception {
        initDriver();
        Selectors companyAlreadyAdded = new Selectors(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        LoginTest login = new LoginTest();
//        login.loginCredentials(prop.getProperty("secondCompanyName"),"allow");
        login.loginCredentials(("#{companyName}#"),"allow");

        SwitchCompanyTest addCompany = new SwitchCompanyTest();
//        addCompany.addNewCompany(prop.getProperty("companyName"));
        addCompany.addNewCompany("#{secondCompanyName}#");

//        addCompany.addNewCompany(prop.getProperty("secondCompanyName"));
        addCompany.addNewCompany("#{secondCompanyName}#");

        wait.until(ExpectedConditions.visibilityOf(companyAlreadyAdded.companyAddedToastMessage));
        Assert.assertTrue(companyAlreadyAdded.companyAddedToastMessage.isDisplayed());
        log.info(" 'Company already added' toast message has been displayed");
        Thread.sleep(6000L);
        companyAlreadyAdded.homeButton.click();
        login.afterTestMethod();
    }
}
