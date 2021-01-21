import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchCompanyTest extends LoginTest {
    public static Logger log = LogManager.getLogger(SwitchCompanyTest.class.getName());
    @Test
    public void switchCompany() throws Exception {

        Selectors switchCompany = new Selectors(driver);
        addNewCompany();
        switchCompany.switchCompanyLeftArrow.click();
        log.info("Switching company by tapping on left arrow");

        String homeScreenCompanyName = switchCompany.switchCompanyNames.getText();
        Assert.assertEquals(homeScreenCompanyName, prop.getProperty("companyName"));
        log.info("Verifying that left arrow has been tapped and company has been switched");
        switchCompany.switchCompanyRightArrow.click();
        log.info("Switching company by tapping on right arrow");
        String secondHomeScreenCompanyName = switchCompany.switchCompanyNames.getText();
        Assert.assertEquals(secondHomeScreenCompanyName, prop.getProperty("secondCompanyName"));
        log.info("Verifying that left arrow has been tapped and company has been switched");

        Dimension scrollDown = driver.manage().window().getSize();
        int y = scrollDown.getHeight()/2;
        int startScroll = (int) (scrollDown.getWidth()*0.99);
        int endScroll = (int) (scrollDown.getWidth()*0.01);

        TouchAction touch = new TouchAction(driver);
        touch.longPress(PointOption.point(startScroll,y)).moveTo(PointOption.point(endScroll,y)).release().perform();
        Thread.sleep(2000L);
        Assert.assertEquals(homeScreenCompanyName, prop.getProperty("companyName"));
        touch.longPress(PointOption.point(startScroll,y)).moveTo(PointOption.point(endScroll,y)).release().perform();
        Assert.assertEquals(secondHomeScreenCompanyName, prop.getProperty("secondCompanyName"));
    }
    public void addNewCompany() throws Exception {
        Selectors switchCompany = new Selectors(driver);
        switchCompany.myBexioAccounts.click();
        log.info("Navigating in 'My bexio Accounts' scene");
        switchCompany.myBexioAccAddCompany.click();
        log.info("Tapping on add new company/plus button");
        loginCredentials(prop.getProperty("secondCompanyName"));
        log.info("Logging in again to new company");
    }
}
