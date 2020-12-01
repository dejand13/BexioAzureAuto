import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTest extends DriverInit {
   @Test
    public void loginTest() throws IOException, InterruptedException {
        initDriver();
//        Fulfilling the text boxes and logging in
        SelectorsGP loginPage = new SelectorsGP(driver);
        loginPage.getUsername().sendKeys(prop.getProperty("username"));
        loginPage.getPassword().sendKeys(prop.getProperty("pass"));
        loginPage.getLoginButton().click();
        Thread.sleep(4000L);
//        Choosing the desired company from the multiple companies
        String comName = prop.getProperty("companyName");
        for(int i = 0; i<loginPage.getLogInCompanyNamesList().size(); i++) {
            if(loginPage.getLogInCompanyNamesList().get(i).getText().equalsIgnoreCase(comName)){
               loginPage.getLogInCompanyNamesList().get(i).click();
           }
        }
//        Allowing camera permissions to the app
        Thread.sleep(6000L);
        driver.switchTo().alert().accept();
//        Verifying that user is navigated on the chosen company home screen
        String homeScreenCompanyName = loginPage.getHomeScreenCompanyName().getText();
        Assert.assertEquals(homeScreenCompanyName,comName);
    }
}
