import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class CopiedToClipboardTest extends LoginTest{
    public static Logger log = LogManager.getLogger(CopiedToClipboardTest.class.getName());

    @Test
    public void copiedToClipboard() throws InterruptedException {
        Selectors copiedToClipboard = new Selectors(driver);
        copiedToClipboard.manageContacts.click();
        copiedToClipboard.searchBar.sendKeys("Automation");
        driver.hideKeyboard();
        copiedToClipboard.searchAutomationContact.click();
        TouchAction touch = new TouchAction(driver);
        touch.longPress(LongPressOptions.longPressOptions().withElement(element(copiedToClipboard.emailAddressAutomationContact)).withDuration(Duration.ofSeconds(2))).release().perform();
        copiedToClipboard.editButton.click();
        touch.longPress(LongPressOptions.longPressOptions().withElement(element(copiedToClipboard.titleScroll)).withDuration(Duration.ofSeconds(2))).moveTo(element(copiedToClipboard.mobileScroll)).release().perform();
        Thread.sleep(2000L);
        touch.longPress(LongPressOptions.longPressOptions().withElement(element(copiedToClipboard.email2)).withDuration(Duration.ofSeconds(2))).release().perform();
        Thread.sleep(2000L);
        touch.tap(PointOption.point(10,150)).perform();
    }
}
