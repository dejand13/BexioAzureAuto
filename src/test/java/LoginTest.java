import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends DriverInit {
    public static Logger log = LogManager.getLogger(LoginTest.class.getName());

    @BeforeTest
    public void loginTest() throws Exception {
        initDriver();
        loginCredentials(prop.getProperty("companyName"));
    }
    public void loginCredentials(String companyName) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver,10);
//        Fulfilling the text boxes and logging in
        Selectors loginPage = new Selectors(driver);
        try {
            loginPage.allowNotificationDialog.isDisplayed();
            driver.switchTo().alert().accept();
            log.info("Allow notifications dialog has been accepted");
        } catch (Exception e) {
            log.info("Allow notification dialog is not displayed");
        }
        loginPage.password.sendKeys(prop.getProperty("pass"));
//            loginPage.password.sendKeys("#{pass}#");
        loginPage.username.sendKeys(prop.getProperty("username"));
//            loginPage.username.sendKeys("#{username}#");
        loginPage.logginButton.click();
        log.info("Credentials has been added and login button is tapped");

        wait.until(ExpectedConditions.visibilityOf(loginPage.availabilityOfLogInCompanyNamesList));
//        Choosing the desired company from the multiple companies
        String comName = companyName;
//            String comName = ("#{companyName}#");
        Boolean companyFound = false;
        for (int i = 0; i < loginPage.logInCompanyNamesList.size(); i++) {
            if(loginPage.logInCompanyNamesList.get(i).getText().contains(comName)) {
                loginPage.logInCompanyNamesList.get(i).click();
                companyFound = true;
                log.info("Desired company has been tapped. You have chosen: " + comName);
                break;
            }
        }
        if(companyFound == false) {
            log.error("It appears that the desired company does NOT exist in this account");
            throw new Exception("It appears that the desired company does NOT exist in this account");
        }

        Dimension scrollDown = driver.manage().window().getSize();
        int x = scrollDown.getWidth()/2;
        int startScroll = (int) (scrollDown.getHeight()*0.6);
        int endScroll = (int) (scrollDown.getHeight()*0.1);
        TouchAction touch = new TouchAction(driver);

            try{
                loginPage.viewEditContacts.isDisplayed();
                touch.longPress(PointOption.point(x,startScroll)).moveTo(PointOption.point(x,endScroll)).release().perform();
                loginPage.allowAccessToCompany.click();
                log.info("Access to " + comName + "has been allowed");
            }

            catch (Exception e){
               log.info("User has already granted permissions in this company in some previous login");
            }
        wait.until(ExpectedConditions.visibilityOf(loginPage.myBexioAccounts));
//        Verifying that user is navigated on the chosen company home screen
        String homeScreenCompanyName = loginPage.homeScreenCompanyName.getText();
//            Assert.assertEquals(homeScreenCompanyName, comName);
    }

    @AfterTest
    public void afterTestMethod() throws Exception {
        Selectors afterTest = new Selectors(driver);
        afterTest.myBexioAccounts.click();
        log.info("After test - Navigating into my bexio account");
        afterTest.myBexioAccAddCompany.click();
        log.info("Tapping on add new company button");
        Assert.assertTrue(afterTest.logginButton.isDisplayed());
        log.info("Verifying that login form has been displayed");
    }
}
