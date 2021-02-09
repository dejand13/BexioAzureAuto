package com.bexio.logIn;

import com.bexio.init.DriverInit;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Methods_LogIn extends DriverInit {
    public static Logger log = LogManager.getLogger(Methods_LogIn.class.getName());
    public static WebDriverWait wait;

    @BeforeTest
    public void loginTest() throws Exception {
        Methods_LogIn login = new Methods_LogIn();
        initDriver();
        login.loginCredentials(companyName,"allow");
    }
    public void loginCredentials(String comName, String access) throws Exception {
        wait = new WebDriverWait(driver,10);
        Methods_TapOnCoordinate tapOnCoordinate = new Methods_TapOnCoordinate();
//        Fulfilling the text boxes and logging in
        LogIn_Selectors loginPage = new LogIn_Selectors(driver);
        try {
            loginPage.allowNotificationDialog.isDisplayed();
            driver.switchTo().alert().accept();
            log.info("Allow notifications dialog has been accepted");
        } catch (Exception e) {
            log.info("Allow notification dialog is not displayed");
        }

        loginPage.password.sendKeys(password);
        loginPage.username.sendKeys(username);
        loginPage.logginButton.click();
        log.info("Credentials has been added and login button is tapped");
        wait.until(ExpectedConditions.visibilityOf(loginPage.availabilityOfLogInCompanyNamesList));
//        Choosing the desired company from the multiple companies
//        Boolean companyFound = false;
//        for (int i = 0; i < loginPage.logInCompanyNamesList.size(); i++) {
//            if(loginPage.logInCompanyNamesList.get(i).getText().contains(comName)) {
//                loginPage.logInCompanyNamesList.get(i).click();
//                companyFound = true;
//                log.info("Desired company has been tapped. You have chosen: " + comName);
//                break;
//            }
//        }
//        if(companyFound == false) {
//            log.error("It appears that the desired company does NOT exist in this account");
//            throw new Exception("It appears that the desired company does NOT exist in this account");
//        }
        selectCompanyIterator(comName);
        try{
            loginPage.viewEditContacts.isDisplayed();
            tapOnCoordinate.swipeByYAxisUsingCoordinates(0.5,0.6,0.1);
//                touch.longPress(PointOption.point(x,startScroll)).moveTo(PointOption.point(x,endScroll)).release().perform();
            Thread.sleep(2000L);
            if(access.contains("differentCompany")) {
                loginPage.selectDiffCompany.click();
                log.info("Select different company has been tapped");
            } else if(access.contains("reject")){
                loginPage.rejectAccess.click();
                log.info("Access to " + comName + "has been rejected");
            } else {
                loginPage.allowAccessToCompany.click();
                log.info("Access to " + comName + "has been allowed");
            }
        }

        catch (Exception e){
            log.info("User has already granted permissions in this company in some previous login");
        }
    }
    public void selectCompanyIterator(String comName) throws Exception {
        LogIn_Selectors loginPage = new LogIn_Selectors(driver);
        Boolean companyFound = false;
        for (int i = 0; i < loginPage.logInCompanyNamesList.size(); i++) {
            if(loginPage.logInCompanyNamesList.get(i).getText().contains(comName)) {
                loginPage.logInCompanyNamesList.get(i).click();
                companyFound = true;
                log.info("Desired company has been tapped. You have chosen: " + comName);
                break;
            }
        }
        if(companyFound == false) {
            log.error("It appears that the desired company does NOT exist in this account");
            throw new Exception("It appears that the desired company does NOT exist in this account");
        }
    }
    @AfterTest
    public void afterTestMethod() throws Exception {
        LogIn_Selectors afterTest = new LogIn_Selectors(driver);
        afterTest.myBexioAccounts.click();
        log.info("After test - Navigating into my bexio account");
        afterTest.myBexioAccAddCompany.click();
        log.info("Tapping on add new company button");
        Assert.assertTrue(afterTest.logginButton.isDisplayed());
        log.info("Verifying that login form has been displayed");
        driver.closeApp();
        log.info("Closing the app");
    }

    public void addNewCompany(String companyName) throws Exception {
        Methods_LogIn login = new Methods_LogIn();
        LogIn_Selectors switchCompany = new LogIn_Selectors(driver);
        switchCompany.myBexioAccounts.click();
        log.info("Navigating in 'My bexio Accounts' scene");
        switchCompany.myBexioAccAddCompany.click();
        log.info("Tapping on add new company/plus button");
        login.loginCredentials(companyName,"allow");
        log.info("Logging in again to new company");
    }
}
