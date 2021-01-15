import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class ManageContactsAddContactTest extends LoginTest {
    public static Logger log = LogManager.getLogger(ManageContactsAddContactTest.class.getName());

    @Test
    public void manageContacts() throws IOException, InterruptedException {
        Selectors addContact = new Selectors(driver);

        addContact.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        addContact.addContactButton.click();
        log.info("Tapping on add new contact button");
        Thread.sleep(2000L);

        int widthOfScreen = driver.manage().window().getSize().getWidth();
        int heightOfScreen = driver.manage().window().getSize().getHeight();

        int x = (int) (widthOfScreen * 0.65);
        int y = (int) (heightOfScreen * 0.45);

        TouchAction touch = new TouchAction(driver);
        touch.tap(PointOption.point(x,y)).perform();
//        touch.tap(PointOption.point(300,420)).perform();

        addContact.lastName.sendKeys("Doneski");
        addContact.firstName.sendKeys("Dejan");
        addContact.formOfAddress.click();
        addContact.formOfAddressMr.click();
//        addContact.title.click();
//        addContact.titleDr.click();
//        addContact.languageOfCorrespondence.click();
//        addContact.languageOfCorrItalian.click();
        addContact.email.sendKeys("ddoneski@melontech.com");
        addContact.email2.sendKeys("doneski.dejan@gmail.com");
        touch.longPress(LongPressOptions.longPressOptions().withElement(element(addContact.email2)).withDuration(Duration.ofSeconds(2))).moveTo(element(addContact.country)).release().perform();
        addContact.phone.sendKeys("072/588-848");
        addContact.phone2.sendKeys("046/271-431");
        addContact.mobile.sendKeys("071/663-219");
        addContact.website.sendKeys("www.google.com");
        addContact.address.sendKeys("8th March");
        addContact.postcode.sendKeys("6000");
        addContact.city.sendKeys("Ohrid");
        addContact.country.click();
        touch.longPress(LongPressOptions.longPressOptions().withElement(element(addContact.countryBulgaria)).withDuration(Duration.ofSeconds(2))).moveTo(element(addContact.countryFinland)).release().perform();
        addContact.countryFinland.click();
        addContact.remarks.sendKeys("Add some remarks");
        addContact.category.click();
        touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(addContact.categoryQA))).release().perform();
        addContact.categoryQA.click();
        addContact.checkboxSaveButton.click();
//        touch.longPress(LongPressOptions.longPressOptions().withElement(element(addContact.lastName)).withDuration(Duration.ofSeconds(2))).moveTo(element(addContact.sectors)).release().perform();
//        addContact.sectors.click();
//        touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(addContact.sector1B))).release().perform();
//        addContact.checkboxSaveButton.click();
    }
}
