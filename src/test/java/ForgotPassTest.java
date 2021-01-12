import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;

public class ForgotPassTest extends DriverInit{
    @Test
    public void forgotPass() throws IOException, InterruptedException {
        initDriver();
        Selectors forgotPass = new Selectors(driver);
        driver.switchTo().alert().accept();
        forgotPass.forgotPassLogInLink.click();
        Thread.sleep(3000L);
        forgotPass.enterEmailForgotPass.sendKeys(prop.getProperty("invalidEmail"));
        //forgotPass.getEnterEmailForgotPass().sendKeys("#{invalidEmail}#");
        driver.hideKeyboard();
        Assert.assertTrue(forgotPass.notValidEmailAssert.isDisplayed());
        log.info("Invalid email address has been added.");
        forgotPass.enterEmailForgotPass.clear();
        forgotPass.enterEmailForgotPass.sendKeys(prop.getProperty("usernameForgot"));
        //forgotPass.getEnterEmailForgotPass().sendKeys("#{usernameForgot}#");
        driver.hideKeyboard();
        //forgotPass.sendNewPassword.click();
        Assert.assertTrue(forgotPass.linkSuccessfullySentAssert.isDisplayed());
        log.info("Link for password renewal has been sent successfully to the added email address.");
        forgotPass.backToLogInForgotPass.click();
        log.info("User is redirected on login page.");
    }
}
