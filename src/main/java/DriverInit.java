import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
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

    public static AppiumDriver initDriver() throws IOException {
        prop = new Properties();
        File src = new File("src/data.properties");
        FileInputStream data = new FileInputStream(src);
        prop.load(data);

        String executionStore = prop.getProperty("store");
        if (executionStore.equalsIgnoreCase("android")) {
            File source = new File("src");
            File appSrc = new File(source,"app-development.apk");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
            capabilities.setCapability(MobileCapabilityType.APP, appSrc.getAbsolutePath());
//            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.bexio.bxBexio");
//            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.bexio.bxBexio.MainActivity");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung SM-G973F");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}