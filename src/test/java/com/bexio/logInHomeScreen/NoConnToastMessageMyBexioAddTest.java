package com.bexio.logInHomeScreen;

import com.bexio.init.Selectors;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoConnToastMessageMyBexioAddTest extends LoginTest {
    public static Logger log = LogManager.getLogger(NoConnToastMessageMyBexioAddTest.class.getName());

    @Test
    public void NoConnToastMessageMyBexioAdd() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Selectors noConnection = new Selectors(driver);
        disableInternetConnection();

        wait.until(ExpectedConditions.visibilityOf(noConnection.myBexioAccounts));
        noConnection.myBexioAccounts.click();
        noConnection.myBexioAccAddCompany.click();
        Assert.assertTrue(noConnection.myBexioNoInternetToastMessage.isDisplayed());

        enableInternetConnection();
        Thread.sleep(4000L);
        noConnection.homeButton.click();
    }
    public void scrollSettingsMenu() {
        TouchAction touch = new TouchAction(driver);
        Dimension scrollDown = driver.manage().window().getSize();
        int scroll = (int) 364.1;
//        int startScroll = (int) 23.2;
        int startScroll = (int) (scrollDown.getWidth()*0.0561);
//        int endScroll = (int) 180.3;
        int endScroll = (int) (scrollDown.getHeight()*0.201);

        touch.longPress(PointOption.point(scroll,startScroll)).moveTo(PointOption.point(scroll,endScroll)).release().perform();
    }
    public void disableInternetConnection(){
        TouchAction touch = new TouchAction(driver);
        Selectors noConnection = new Selectors(driver);

        if (executionStore.contains("android")) {
            ((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
        } else {
            scrollSettingsMenu();
            //        touch.tap(PointOption.point(80,200)).release().perform();
            noConnection.airplaneModeButton.click();
            touch.tap(PointOption.point(351, 115)).release().perform();
        }
    }
    public void enableInternetConnection(){
        TouchAction touch = new TouchAction(driver);
        Selectors noConnection = new Selectors(driver);

        if (executionStore.contains("android")) {
            ((AndroidDriver) driver).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
        } else {
            scrollSettingsMenu();
            noConnection.airplaneModeButton.click();

            try {
                if (noConnection.noSimCardInstalled.isDisplayed()) {
                    noConnection.noSimCardInstalledClose.click();
                    Thread.sleep(2000L);
                    touch.tap(PointOption.point(351, 115)).release().perform();
                    log.info("Tapping outside Settings dialog in order to close it.");
                }
            } catch (Exception e) {
                touch.tap(PointOption.point(351, 115)).release().perform();
                log.info("Tapping outside Settings dialog in order to close it.");
            }
        }
    }
}
