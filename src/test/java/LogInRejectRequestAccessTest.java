import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class LogInRejectRequestAccessTest extends LoginTest{
    @Test    
    public void logInRejectRequestAccess() throws Exception {
        Selectors loginPage = new Selectors(driver);
//        Allowing camera permissions to the app
//        Thread.sleep(6000L);
//        driver.switchTo().alert().dismiss();
//        Navigate in scan documents and verify that permission dialog/camera permission will be displayed/requested
        loginPage.scanDocument.click();
        Thread.sleep(3000L);
        loginPage.getScanSendToInbox().click();
        Assert.assertTrue(loginPage.getPermissionDialogMessageAfterDeny().isDisplayed());
    }
}
