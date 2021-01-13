import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class ForgotPassTest extends DriverInit{
    public static Logger log = LogManager.getLogger(ForgotPassTest.class.getName());
    @Test
    public void forgotPass() throws IOException, InterruptedException {
        initDriver();
        Selectors forgotPass = new Selectors(driver);
        try {
            forgotPass.allowNotificationDialog.isDisplayed();
            driver.switchTo().alert().accept();
            log.info("Allow notifications dialog has been accepted");
        } catch (Exception e) {
            log.info("Allow notification dialog is not displayed on android");
        }

        forgotPass.forgotPassLogInLink.click();
        Thread.sleep(3000L);
        forgotPass.enterEmailForgotPass.sendKeys(prop.getProperty("invalidEmail"));
        //forgotPass.getEnterEmailForgotPass().sendKeys("#{invalidEmail}#");
        try {
            forgotPass.requestNewPassButton.isDisplayed();
            forgotPass.requestNewPassButton.click();
        } catch (Exception e) {
            log.info("Request new password button is not visible on the screen");
            driver.hideKeyboard();
        }
        Assert.assertTrue(forgotPass.notValidEmailAssert.isDisplayed());
        log.info("Invalid email address has been added.");
        forgotPass.enterEmailForgotPass.clear();
        forgotPass.enterEmailForgotPass.sendKeys(prop.getProperty("usernameForgot"));
        //forgotPass.getEnterEmailForgotPass().sendKeys("#{usernameForgot}#");
        forgotPass.requestNewPassButton.click();
        //forgotPass.sendNewPassword.click();
        Assert.assertTrue(forgotPass.linkSuccessfullySentAssert.isDisplayed());
        log.info("Link for password renewal has been sent successfully to the added email address.");
        forgotPass.backToLogInForgotPass.click();
        log.info("User is redirected on login page.");
    }
}
