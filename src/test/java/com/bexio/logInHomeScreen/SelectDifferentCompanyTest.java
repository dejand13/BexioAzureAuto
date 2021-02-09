package com.bexio.logInHomeScreen;

import com.bexio.init.DriverInit;
import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectDifferentCompanyTest extends DriverInit {
    public static Logger log = LogManager.getLogger(SelectDifferentCompanyTest.class.getName());

    @Test
    public void selectDifferentCompany() throws Exception {
        initDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        LogIn_Selectors selectDiffCompany = new LogIn_Selectors(driver);
        Methods_LogIn login = new Methods_LogIn();
        Methods_TapOnCoordinate swipe = new Methods_TapOnCoordinate();

        login.loginCredentials(secondCompanyName,"differentCompany");
        wait.until(ExpectedConditions.visibilityOf(selectDiffCompany.availabilityOfLogInCompanyNamesList));
//        Choosing the desired company from the multiple companies
        String comName = noContactsCompany;
        login.selectCompanyIterator(comName);
        try{
            selectDiffCompany.viewEditContacts.isDisplayed();
            swipe.swipeByYAxisUsingCoordinates(0.5,0.6,0.1);
            selectDiffCompany.allowAccessToCompany.click();
            log.info("Access to " + comName + "has been allowed");
        }
        catch (Exception e){
            log.info("User has already granted permissions in this company in some previous login");
        }
        wait.until(ExpectedConditions.visibilityOf(selectDiffCompany.myBexioAccounts));
//        Verifying that user is navigated on the chosen company home screen
        String homeScreenCompanyName = selectDiffCompany.homeScreenCompanyName.getText();
        Assert.assertEquals(homeScreenCompanyName, comName);

        login.afterTestMethod();
    }
}
