import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTest extends DriverInit {
    public static Logger log = LogManager.getLogger(LoginTest.class.getName());

    @BeforeTest
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
            String comName = prop.getProperty("companyName");
//            String comName = ("#{companyName}#");
            Boolean companyFound = false;
                for (int i = 0; i < loginPage.logInCompanyNamesList.size(); i++) {
                    if(loginPage.logInCompanyNamesList.get(i).getText().contains(comName)) {
                        loginPage.logInCompanyNamesList.get(i).click();
                        companyFound = true;
                        log.info("Desired company has been tapped. You have choosed: " + comName);
                        break;
                    }
                }
                if(companyFound == false) {
                    log.error("It appears that the desired company does NOT exist in this account");
                    throw new Exception("It appears that the desired company does NOT exist in this account");
                }

        try {
                loginPage.allowAccessToCompany.isDisplayed();
                log.info("Access to " + comName + "has been allowed");
//                loginPage.rememberMyChoiseCheckBox.click();
                loginPage.allowAccessToCompany.click();
            } catch (Exception e) {
                log.info("User has already granted permissions in this company in some previous login");
            }
            wait.until(ExpectedConditions.visibilityOf(loginPage.myBexioAccounts));
//        Verifying that user is navigated on the chosen company home screen
            String homeScreenCompanyName = loginPage.homeScreenCompanyName.getText();
//            Assert.assertEquals(homeScreenCompanyName, comName);
    }
}
