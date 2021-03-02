package com.bexio.tapOnCoordinate;

import com.bexio.init.DriverInit;
import com.bexio.logIn.LogIn_Selectors;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class Methods_TapOnCoordinate extends DriverInit {
    TouchAction touch = new TouchAction(driver);
    public void tapOnCoordinate(double screenWidthPercentage, double screenHeightPercentage) {
        int widthOfScreen = driver.manage().window().getSize().getWidth();
        int heightOfScreen = driver.manage().window().getSize().getHeight();
        int x = (int) (widthOfScreen * screenWidthPercentage);
        int y = (int) (heightOfScreen * screenHeightPercentage);

        touch.tap(PointOption.point(x,y)).perform();
    }
    public void swipeByYAxisUsingCoordinates(double xAxisPositionPercentage, double yAxisStartPositionPercentage, double yAxisEndPositionPercentage){
        Dimension scrollDown = driver.manage().window().getSize();
        int scroll =(int) (scrollDown.getWidth() * xAxisPositionPercentage);
        int startScroll = (int) (scrollDown.getHeight() * yAxisStartPositionPercentage);
        int endScroll = (int) (scrollDown.getHeight() * yAxisEndPositionPercentage);

        touch.longPress(PointOption.point(scroll,startScroll)).moveTo(PointOption.point(scroll,endScroll)).release().perform();
    }
    public void swipeByXAxisUsingCoordinates(double yAxisPositionPercentage, double xAxisStartPositionPercentage, double xAxisEndPositionPercentage){
        Dimension scrollDown = driver.manage().window().getSize();
        int scroll =(int) (scrollDown.getHeight() * yAxisPositionPercentage);
        int startScroll = (int) (scrollDown.getWidth() * xAxisStartPositionPercentage);
        int endScroll = (int) (scrollDown.getWidth() * xAxisEndPositionPercentage);

        touch.longPress(PointOption.point(startScroll, scroll)).moveTo(PointOption.point(endScroll, scroll)).release().perform();
    }
    public void scrollSettingsMenu() {
        Dimension scrollDown = driver.manage().window().getSize();
        int scroll = (int) 364.1;
//        int startScroll = (int) 23.2;
        int startScroll = (int) (scrollDown.getWidth()*0.0561);
//        int endScroll = (int) 180.3;
        int endScroll = (int) (scrollDown.getHeight()*0.201);
        touch.longPress(PointOption.point(scroll,startScroll)).moveTo(PointOption.point(scroll,endScroll)).release().perform();
    }
    public void disableInternetConnection(){
        LogIn_Selectors noConnection = new LogIn_Selectors(driver);

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
        LogIn_Selectors noConnection = new LogIn_Selectors(driver);

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
    public void createNewPersonOrCompanyDialog(double xAxisPositionPercentage, double yAxisPositionPercentage) {
        LogIn_Selectors addContact = new LogIn_Selectors(driver);
        Methods_TapOnCoordinate tapOnCoordinate = new Methods_TapOnCoordinate();
        if (executionStore.equalsIgnoreCase("android")) {
            addContact.newPerson.click();
        } else {
            tapOnCoordinate.tapOnCoordinate(xAxisPositionPercentage, yAxisPositionPercentage);
        }
    }
    public void scrollFromElementToElement(MobileElement startScroll, MobileElement endScroll) {
        touch.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(startScroll))).moveTo(ElementOption.element(endScroll)).release().perform();
    }
}
