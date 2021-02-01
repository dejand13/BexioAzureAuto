package com.bexio.logInHomeScreen;

import com.bexio.init.Selectors;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecommendationSentGPTest extends LoginTest {
    public static Logger log = LogManager.getLogger(RecommendationSentGPTest.class.getName());

    @Test
    public void recommendationSent() throws InterruptedException {
        String randomString = RandomStringUtils.randomAlphabetic(8);
        String randomDomain = RandomStringUtils.randomAlphabetic(8);

        Selectors recommend = new Selectors(driver);
        recommend.recommendBexio.click();
        log.info("Tapping on Recommend Bexio button");
        recommend.recommendEmailAddress.sendKeys(randomString + "@" +randomDomain+ ".com");
        log.info("Entering valid email address");
        recommend.recommendSendButton.click();
        wait.until(ExpectedConditions.visibilityOf(recommend.recommendThankYou));
        Assert.assertTrue(recommend.recommendThankYou.isDisplayed());
        log.info("Verifying that recommend has been sent to the email address");

//        Closing the recommend bexio popup using close button
        recommend.recommendCloseButton.click();
        log.info("Tapping on close button");

    }

}
