import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SceneVerificationTest extends LoginTest{
    public static Logger log = LogManager.getLogger(SceneVerificationTest.class.getName());
    @Test
    public void sceneVerification() throws Exception {
        Selectors sceneVerification = new Selectors(driver);
        Assert.assertTrue(sceneVerification.manageContacts.isDisplayed());
        log.info("Verifying that Manage Contacts scene is displayed");
        sceneVerification.manageContacts.click();
        log.info("Navigating in Manage Contacts scene");
        Assert.assertTrue(sceneVerification.searchBar.isDisplayed());
        sceneVerification.homeButton.click();
        log.info("Tapping on home button");

        Assert.assertTrue(sceneVerification.scanDocuments.isDisplayed());
        log.info("Verifying that Scan Documents scene is displayed");
        sceneVerification.scanDocuments.click();
        log.info("Navigating in Scan Documents scene");
        Assert.assertTrue(sceneVerification.scanSendToInbox.isDisplayed());
        sceneVerification.homeButton.click();
        log.info("Tapping on home button");

        Assert.assertTrue(sceneVerification.trackTime.isDisplayed());
        log.info("Verifying that Track Time scene is displayed");
        sceneVerification.trackTime.click();
        log.info("Navigating in Track Time scene");
        Assert.assertTrue(sceneVerification.stopwatch.isDisplayed());
        sceneVerification.homeButton.click();
        log.info("Tapping on home button");
    }
}
