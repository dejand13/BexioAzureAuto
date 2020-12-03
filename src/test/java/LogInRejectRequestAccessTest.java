import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class LogInRejectRequestAccessTest extends DriverInit{
    @Test
    public void logInRejectRequestAccess() throws IOException, InterruptedException {
        initDriver();
//        Fulfilling the text boxes and logging in
        SelectorsGP loginPage = new SelectorsGP(driver);
//        loginPage.getUsername().sendKeys(prop.getProperty("username"));
        loginPage.getUsername().sendKeys(System.getProperty("username"));
        loginPage.getPassword().sendKeys(prop.getProperty("pass"));
        loginPage.getLoginButton().click();
        Thread.sleep(4000L);
//        Choosing the desired company from the multiple companies
        String comName = prop.getProperty("companyName");
        for(int i = 0; i<loginPage.getLogInCompanyNamesList().size(); i++) {
            if(loginPage.getLogInCompanyNamesList().get(i).getText().equalsIgnoreCase(comName)){
                loginPage.getLogInCompanyNamesList().get(i).click();
            }
        }
//        Allowing camera permissions to the app
        Thread.sleep(6000L);
        driver.switchTo().alert().dismiss();
//        Navigate in scan documents and verify that permission dialog/camera permission will be displayed/requested
        loginPage.getScanDocument().click();
        loginPage.getScanSendToInbox().click();
        Assert.assertTrue(loginPage.getPermissionDialogMessageAfterDeny().isDisplayed());
    }
}
