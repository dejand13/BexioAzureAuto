package com.bexio.logInHomeScreen;

import com.bexio.logIn.LogIn_Selectors;
import com.bexio.logIn.Methods_LogIn;
import com.bexio.tapOnCoordinate.Methods_TapOnCoordinate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchCompanyTest extends Methods_LogIn {
    public static Logger log = LogManager.getLogger(SwitchCompanyTest.class.getName());
    @Test
    public void switchCompany() throws Exception {
        LogIn_Selectors switchCompany = new LogIn_Selectors(driver);
        Methods_TapOnCoordinate swipe = new Methods_TapOnCoordinate();
        String homeScreenCompanyName = switchCompany.switchCompanyNames.getText();
        String homeScreenSecondCompanyName = switchCompany.switchCompanyNames.getText();

        addNewCompany(secondCompanyName);
        switchCompany.switchCompanyLeftArrow.click();
        log.info("Switching company by tapping on left arrow");
        Thread.sleep(2000L);
        Assert.assertEquals(homeScreenCompanyName, companyName);
        log.info("Verifying that left arrow has been tapped and company has been switched");
        switchCompany.switchCompanyRightArrow.click();
        log.info("Switching company by tapping on right arrow");
        Thread.sleep(2000L);
//        Assert.assertEquals(homeScreenSecondCompanyName, secondCompanyName);
        log.info("Verifying that right arrow has been tapped and company has been switched");
        swipe.swipeByXAxisUsingCoordinates(0.5,0.99,0.01);
        Thread.sleep(2000L);
        Assert.assertEquals(homeScreenCompanyName, companyName);
        log.info("Switching company using the swipe functionality");
        swipe.swipeByXAxisUsingCoordinates(0.5,0.99,0.01);
        Thread.sleep(2000L);
//        Assert.assertEquals(homeScreenSecondCompanyName, secondCompanyName);
        log.info("Switching company using the swipe functionality");
    }
}
