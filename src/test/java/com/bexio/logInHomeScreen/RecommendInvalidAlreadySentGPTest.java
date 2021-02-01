package com.bexio.logInHomeScreen;

import com.bexio.init.Selectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecommendInvalidAlreadySentGPTest extends LoginTest {
    public static Logger log = LogManager.getLogger(RecommendInvalidAlreadySentGPTest.class.getName());

    @Test
    public void recommendBexioInvalidAlreadySent() throws InterruptedException {
        Selectors recommend = new Selectors(driver);
        recommend.recommendBexio.click();
        log.info("Tapping on Recommend Bexio button");
        recommend.recommendEmailAddress.sendKeys("invalid");
        recommend.recommendSendButton.click();
        log.info("Trying to recommend using invalid email address");
        wait.until(ExpectedConditions.visibilityOf(recommend.invalidEmailToastMessage));
        Assert.assertTrue(recommend.invalidEmailToastMessage.isDisplayed());
        log.info("Verifying that invalid email toas message has been displayed");

//        Closing the recommend bexio popup using X button
        recommend.recommendXbutton.click();
        recommend.recommendBexio.click();
        log.info("Tapping on Recommend Bexio button");
        recommend.recommendEmailAddress.sendKeys("invalid@gmail.com");
        recommend.recommendSendButton.click();
        log.info("Trying to send recommendation using the same email address ");
        wait.until(ExpectedConditions.visibilityOf(recommend.recommentAlreadySentToastMessage));
        Assert.assertTrue(recommend.recommentAlreadySentToastMessage.isDisplayed());

//        Closing the recommend bexio popup using android back button
        recommend.recommendBexio.click();
        log.info("Tapping on Recommend Bexio button");
        driver.navigate().back();
        log.info("Tapping on android back button");

        recommend.myBexioAccounts.click();
        Assert.assertTrue(recommend.myBexioAccAddCompany.isDisplayed());
        log.info("Verifying that recommend bexio dialog has been closed by navigating in my bexio accounts scene");

    }
}
