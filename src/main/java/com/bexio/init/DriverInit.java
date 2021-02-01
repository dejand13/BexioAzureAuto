package com.bexio.init;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverInit {

    public static AppiumDriver driver;
    public static Properties prop;
    public static Logger log = LogManager.getLogger(DriverInit.class.getName());
    public static String executionStore;
    public static String username;
    public static String password;
    public static String companyName;
    public static String secondCompanyName;
    public static String invalidEmail;
    public static String usernameForgot;
    public static String noContactsCompany;

    public static AppiumDriver initDriver() throws IOException {
        prop = new Properties();
        File src = new File("src/data.properties");
        FileInputStream data = new FileInputStream(src);
        prop.load(data);

// ------------- Data Properties -------------
        executionStore = prop.getProperty("store");
        username = prop.getProperty("username");
        password = prop.getProperty("pass");
        companyName = prop.getProperty("companyName");
        secondCompanyName = prop.getProperty("secondCompanyName");
        invalidEmail = prop.getProperty("invalidEmail");
        usernameForgot = prop.getProperty("usernameForgot");
        noContactsCompany = prop.getProperty("noContactsCompany");

// ------------- Azure DevOps variables -------------
//        executionStore = ("#{store}#");
//        username = ("#{username}#");
//        password = ("#{pass}#");
//        companyName = ("#{companyName}#");
//        secondCompanyName = ("#{secondCompanyName}#");
//        invalidEmail = ("invalidEmail");
//        usernameForgot = ("#{usernameForgot}#");
//        noContactsCompany = ("#{noContactsCompany}#");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (executionStore.equalsIgnoreCase("android")) {
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } else {
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public static void takeScreenshot(String getMethodName) throws IOException {
        TakesScreenshot takeSS = (TakesScreenshot)driver;
        File src = takeSS.getScreenshotAs(OutputType.FILE);
        String screenShotPath = System.getProperty("user.dir")+"//failureSS//"+getMethodName+".png";
        FileUtils.copyFile(src, new File(screenShotPath));
    }
}