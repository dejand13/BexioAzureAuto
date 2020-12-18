import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
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
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverInit {

    public static AppiumDriver driver;
    public static Properties prop;
    public static Logger log = LogManager.getLogger(DriverInit.class.getName());

    public static AppiumDriver initDriver() throws IOException {
        prop = new Properties();
        File src = new File("src/data.properties");
        FileInputStream data = new FileInputStream(src);
        prop.load(data);

        String executionStore = prop.getProperty("Store");
//        String executionStore = System.getProperty("Store");

        if (executionStore.equalsIgnoreCase("android")) {
            File source = new File("src");
            File appSrc = new File(source,"app-release.apk");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
            capabilities.setCapability(MobileCapabilityType.APP, appSrc.getAbsolutePath());
//            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.bexio.bxBexio");
//            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.bexio.bxBexio.MainActivity");
//            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("Device"));
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, System.getProperty("Device"));
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
//            Desired cap for simulator
//            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("Device"));
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
//            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"14.2");
//            capabilities.setCapability(MobileCapabilityType.UDID,"D80D1B2B-B319-4BEE-937E-13B2B25E25A2");
//            capabilities.setCapability(MobileCapabilityType.APP,"/Users/dejanadmin/Library/Developer/Xcode/DerivedData/Bexio-beaxqfreoqdxkgcapciliahwotsz/Build/Products/Debug-iphonesimulator/Bexio.app");
//            capabilities.setCapability(MobileCapabilityType.NO_RESET,"true");


//            Desired cap for real device
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"14.2");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("Device"));
            capabilities.setCapability("udid","00008020-0014285C0261002E");
//            capabilities.setCapability("udid","c067963d7b46116377cd47d42caa386319a30736");
            capabilities.setCapability("updatedWDABundleId", "com.bexio.bxBexio");
            capabilities.setCapability("xcodeOrgId", "773CKPZ8CB");
            capabilities.setCapability("xcodeSigningId","iPhone Developer");
            capabilities.setCapability(MobileCapabilityType.APP,"/Users/dejanadmin/Library/Developer/Xcode/DerivedData/Bexio-dnhuxcznhirppkgoeabacqigdhpo/Build/Products/Release-iphoneos/Bexio.app");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        }
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        return driver;
    }
    public static void takeScreenshot(String getMethodName) throws IOException {
        TakesScreenshot takeSS = (TakesScreenshot)driver;
        File src = takeSS.getScreenshotAs(OutputType.FILE);
        String screenShotPath = System.getProperty("user.dir")+"//failureSS//"+getMethodName+".png";
        FileUtils.copyFile(src, new File(screenShotPath));
    }
}