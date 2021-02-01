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
import org.testng.annotations.Test;

public class SelectDifferentCompanyTest extends DriverInit {
    public static Logger log = LogManager.getLogger(SelectDifferentCompanyTest.class.getName());

    @Test
    public void selectDifferentCompany() throws Exception {
        initDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);

        Selectors selectDiffCompany = new Selectors(driver);

        LoginTest login = new LoginTest();
        login.loginCredentials(secondCompanyName,"differentCompany");

        wait.until(ExpectedConditions.visibilityOf(selectDiffCompany.availabilityOfLogInCompanyNamesList));
//        Choosing the desired company from the multiple companies
        String comName = noContactsCompany;
        Boolean companyFound = false;
        for (int i = 0; i < selectDiffCompany.logInCompanyNamesList.size(); i++) {
            if(selectDiffCompany.logInCompanyNamesList.get(i).getText().contains(comName)) {
                selectDiffCompany.logInCompanyNamesList.get(i).click();
                companyFound = true;
                log.info("Desired company has been tapped. You have chosen: " + comName);
                break;
            }
        }
        if(companyFound == false) {
            log.error("It appears that the desired company does NOT exist in this account");
            throw new Exception("It appears that the desired company does NOT exist in this account");
        }

        Dimension scrollDown = driver.manage().window().getSize();
        int x = scrollDown.getWidth()/2;
        int startScroll = (int) (scrollDown.getHeight()*0.6);
        int endScroll = (int) (scrollDown.getHeight()*0.1);
        TouchAction touch = new TouchAction(driver);

        try{
            selectDiffCompany.viewEditContacts.isDisplayed();
            touch.longPress(PointOption.point(x,startScroll)).moveTo(PointOption.point(x,endScroll)).release().perform();
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
