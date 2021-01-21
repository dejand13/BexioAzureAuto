import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewContactLastNameValidationTest extends LoginTest{
    public static Logger log = LogManager.getLogger(AddNewContactLastNameValidationTest.class.getName());

    @Test
    public void lastNameValidation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,10);

        Selectors validation = new Selectors(driver);

        validation.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        validation.addContactButton.click();
        log.info("Tapping on add new contact button");
        Thread.sleep(2000L);

        int widthOfScreen = driver.manage().window().getSize().getWidth();
        int heightOfScreen = driver.manage().window().getSize().getHeight();

        int x = (int) (widthOfScreen * 0.65);
        int y = (int) (heightOfScreen * 0.45);

        TouchAction touch = new TouchAction(driver);
        String executionStore = prop.getProperty("store");
        if(executionStore.equalsIgnoreCase("android")) {
            validation.newPerson.click();
        } else{
            touch.tap(PointOption.point(x,y)).perform();
        }
        log.info("Tapping on \"New person\" button");

        validation.firstName.sendKeys("DDD");
        log.info("Adding first name");
        validation.addContactSaveButton.click();
        log.info("Tapping on save button");
        Assert.assertTrue(validation.lastNameValidation.isDisplayed());

        validation.lastName.sendKeys("Don");
        log.info("Adding last name");
        validation.addContactSaveButton.click();
        log.info("Tapping on save button again");

        wait.until(ExpectedConditions.visibilityOf(validation.editButton));
        Assert.assertTrue(validation.editButton.isDisplayed());
        log.info("Verifing that contact has been added and user is redirected in detailed view screen");
    }
}
