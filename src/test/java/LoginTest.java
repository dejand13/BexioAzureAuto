import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.surefire.api.event.StandardStreamOutEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends DriverInit {
    public static Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void loginTest() throws Exception {
        initDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
//        Fulfilling the text boxes and logging in
        Selectors loginPage = new Selectors(driver);

        try {
            loginPage.allowNotificationDialog.isDisplayed();
            driver.switchTo().alert().accept();
            log.info("Allow notifications dialog has been accepted");
        } catch (Exception e) {
            log.info("Allow notification dialog is not displayed on GP at this point");
        }
            loginPage.password.sendKeys(prop.getProperty("pass"));
            loginPage.username.sendKeys(prop.getProperty("username"));
            loginPage.logginButton.click();
            log.info("Credentials has been added and login button is tapped");

            wait.until(ExpectedConditions.visibilityOf(loginPage.availabilityOfLogInCompanyNamesList));
//        Choosing the desired company from the multiple companies
            String comName = prop.getProperty("companyName");
//        String comName = System.getProperty("companyName");
            Boolean companyFound = false;
                for (int i = 0; i < loginPage.logInCompanyNamesList.size(); i++) {
                    if (loginPage.logInCompanyNamesList.get(i).getText().contains(comName)) {
                        loginPage.logInCompanyNamesList.get(i).click();
                        companyFound = true;
                    }
                }
                if(companyFound == false) {
                    log.error("It appears that the desired company does NOT exist in this account");
                    throw new Exception("It appears that the desired company does NOT exist in this account");
                }

            try {
                loginPage.requestAccessTo.isDisplayed();
                loginPage.rememberMyChoiseCheckBox.click();
                loginPage.allowAccessToCompany.click();
            } catch (Exception e) {
                log.info("User has already granted permissions in this company in some previous login");
            }
            wait.until(ExpectedConditions.visibilityOf(loginPage.allowCameraPermissions));
            driver.switchTo().alert().accept();
            log.info("Allow camera notification dialog has been accepted");
            System.out.println(driver.findElement(By.xpath("///XCUIElementTypeStaticText")));
//        Verifying that user is navigated on the chosen company home screen
            String homeScreenCompanyName = loginPage.homeScreenCompanyName.getText();
            Assert.assertEquals(homeScreenCompanyName, comName);
            System.out.println("checks");
    }
}
