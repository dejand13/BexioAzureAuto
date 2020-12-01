import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectorsGP{
    public AppiumDriver driver;
    public SelectorsGP(AppiumDriver driver) {
        this.driver = driver;
    }

    By username = By.xpath("//android.widget.EditText[@resource-id='j_username']");
    public WebElement getUsername(){
        return driver.findElement(username);
    }

    By password = By.xpath("//android.widget.EditText[@resource-id='j_password']");
    public WebElement getPassword(){
        return driver.findElement(password);
    }

    By loginButton = By.className("android.widget.Button");
    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    By logInCompanyNamesList = By.xpath("//android.widget.TextView");
    public List<WebElement> getLogInCompanyNamesList() {
        return driver.findElements(logInCompanyNamesList);
    }

    By homeScreenCompanyName = By.xpath("//android.widget.TextView");
    public WebElement getHomeScreenCompanyName() {
        return driver.findElement(homeScreenCompanyName);
    }

    By scanDocument = By.xpath("//android.widget.TextView[@text='Scan Documents']");
    public WebElement getScanDocument() {
        return driver.findElement(scanDocument);
    }

    By scanSendToInbox = By.xpath("//android.widget.TextView[@index='1']");
    public WebElement getScanSendToInbox() {
        return driver.findElement(scanSendToInbox);
    }

    By permissionDialogMessageAfterDeny = By.id("com.android.permissioncontroller:id/permission_message");
    public WebElement getPermissionDialogMessageAfterDeny() {
        return driver.findElement(permissionDialogMessageAfterDeny);
    }

    By forgotPassLogInLink = By.xpath("//android.widget.TextView");
    public WebElement getForgotPassLogInLink() {
        return driver.findElement(forgotPassLogInLink);
    }

    By enterEmailForgotPass = By.xpath("//android.widget.EditText[@resource-id='recover_password_form_email']");
    public WebElement getEnterEmailForgotPass() {
        return driver.findElement(enterEmailForgotPass);
    }
}
