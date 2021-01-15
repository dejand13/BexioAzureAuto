import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewContactEmailValidationTest extends LoginTest{
    public static Logger log = LogManager.getLogger(AddNewContactEmailValidationTest.class.getName());

    @Test
    public void emailValidation() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,10);
        Selectors validation = new Selectors(driver);

        validation.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        validation.addContactButton.click();
        log.info("Tapping on add new contact button");

        int widthOfScreen = driver.manage().window().getSize().getWidth();
        int heightOfScreen = driver.manage().window().getSize().getHeight();
        int x = (int) (widthOfScreen * 0.65);
        int y = (int) (heightOfScreen * 0.45);

        TouchAction touch = new TouchAction(driver);
        touch.tap(PointOption.point(x,y)).perform();
        log.info("Tapping on \"New person\" button");

        validation.lastName.sendKeys("DDD");
        log.info("Adding last name");
        validation.email.sendKeys("Don");
        log.info("Adding invalid email address");
        validation.addContactSaveButton.click();
        log.info("Tapping on save button");

        Assert.assertTrue(validation.emailAddressValidation.getSize().getHeight()>0);
        log.info(" 'This email address is not valid' error message is displayed");
        validation.invalidEmailTextBox.clear();
        validation.email.sendKeys("email@gmail.com");
        log.info("Adding valid email address for the second email address field");

        validation.email2.sendKeys("email");
        log.info("Adding invalid email address in the second email address field");
        validation.addContactSaveButton.click();
        log.info("Tapping on save button");

        Assert.assertTrue(validation.emailAddressValidation.getSize().getHeight()>0);
        log.info(" 'This email address is not valid' error message is displayed");
        validation.invalidEmail2TextBox.clear();
        validation.email2.sendKeys("email@gmail.com");
        log.info("Adding valid email address for the second email address field");

        validation.addContactSaveButton.click();
        log.info("Tapping on save button");

        wait.until(ExpectedConditions.visibilityOf(validation.editButton));
        Assert.assertTrue(validation.editButton.isDisplayed());
        log.info("Verifying that contact has been added and user is redirected in detailed view screen");
    }
}
