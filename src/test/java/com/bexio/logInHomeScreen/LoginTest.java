package com.bexio.logInHomeScreen;

import com.bexio.init.DriverInit;
import com.bexio.init.Selectors;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LoginTest extends DriverInit {
    public static Logger log = LogManager.getLogger(LoginTest.class.getName());

    @BeforeTest
    public void loginTest() throws Exception {
        initDriver();
//        loginCredentials(prop.getProperty("companyName"),"allow");
        loginCredentials(("#{companyName}#"),"allow");
    }
    public void loginCredentials(String companyName, String access) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,10);
//        Fulfilling the text boxes and logging in
        Selectors loginPage = new Selectors(driver);
        try {
            loginPage.allowNotificationDialog.isDisplayed();
            driver.switchTo().alert().accept();
            log.info("Allow notifications dialog has been accepted");
        } catch (Exception e) {
            log.info("Allow notification dialog is not displayed");
        }
//        loginPage.password.sendKeys(prop.getProperty("pass"));
            loginPage.password.sendKeys("#{pass}#");
//        loginPage.username.sendKeys(prop.getProperty("username"));
            loginPage.username.sendKeys("#{username}#");
        loginPage.logginButton.click();
        log.info("Credentials has been added and login button is tapped");

        wait.until(ExpectedConditions.visibilityOf(loginPage.availabilityOfLogInCompanyNamesList));
//        Choosing the desired company from the multiple companies
        String comName = companyName;
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

            try{
                loginPage.viewEditContacts.isDisplayed();
                scrollPointOption(0.6,0.1);
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
                    wait.until(ExpectedConditions.visibilityOf(loginPage.myBexioAccounts));
//        Verifying that user is navigated on the chosen company home screen
                    String homeScreenCompanyName = loginPage.homeScreenCompanyName.getText();
                    Assert.assertEquals(homeScreenCompanyName, comName);
                }
            }

            catch (Exception e){
               log.info("User has already granted permissions in this company in some previous login");
            }
    }

    public void scrollPointOption(double startPositionPercentage, double endPositionPercentage){
        Dimension scrollDown = driver.manage().window().getSize();
        int scroll = scrollDown.getWidth()/2;
        int startScroll = (int) (scrollDown.getHeight()*startPositionPercentage);
        int endScroll = (int) (scrollDown.getHeight()*endPositionPercentage);

        TouchAction touch = new TouchAction(driver);
        touch.longPress(PointOption.point(scroll,startScroll)).moveTo(PointOption.point(scroll,endScroll)).release().perform();
    }

    @AfterTest
    public void afterTestMethod() throws Exception {
        Selectors afterTest = new Selectors(driver);
        afterTest.myBexioAccounts.click();
        log.info("After test - Navigating into my bexio account");
        afterTest.myBexioAccAddCompany.click();
        log.info("Tapping on add new company button");
        Assert.assertTrue(afterTest.logginButton.isDisplayed());
        log.info("Verifying that login form has been displayed");
        driver.closeApp();
        log.info("Closing the app");
    }
}
