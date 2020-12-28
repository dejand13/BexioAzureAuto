import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class LogInRejectRequestAccessTest extends DriverInit{
    public void logInRejectRequestAccess() throws IOException, InterruptedException {
        initDriver();
//        Fulfilling the text boxes and logging in
        Selectors loginPage = new Selectors(driver);
        loginPage.username.sendKeys(prop.getProperty("username"));
        loginPage.password.sendKeys(prop.getProperty("pass"));
        loginPage.logginButton.click();
        Thread.sleep(4000L);
//        Choosing the desired company from the multiple companies
        String comName = prop.getProperty("companyName");
//        String comName = System.getProperty("companyName");
        for(int i = 0; i<loginPage.logInCompanyNamesList.size(); i++) {
            if(loginPage.logInCompanyNamesList.get(i).getText().equalsIgnoreCase(comName)){
                loginPage.logInCompanyNamesList.get(i).click();
            }
        }
//        Allowing camera permissions to the app
        Thread.sleep(6000L);
        driver.switchTo().alert().dismiss();
//        Navigate in scan documents and verify that permission dialog/camera permission will be displayed/requested
        loginPage.scanDocument.click();
        loginPage.getScanSendToInbox().click();
        Assert.assertTrue(loginPage.getPermissionDialogMessageAfterDeny().isDisplayed());
    }
}
