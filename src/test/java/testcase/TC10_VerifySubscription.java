package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import static testcase.TC02_LoginWithValidData.email1;
import static util.Utility.captureScreenshot;

public class TC10_VerifySubscription extends TestBase{

    @Test
    public void verifySubscription(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        SoftAssert softAssert = new SoftAssert();
        captureScreenshot(driver,"subscriptionSecDisplay");
        softAssert.assertTrue(new P01_HomePage(driver).scrollToFooter().validateSubscriptionDisplay());
        softAssert.assertAll();

        new P01_HomePage(driver).fillSubscriptionMail(email1).clickOnSubmitSubscription();
        captureScreenshot(driver,"subscriptionSubmitted");
        Assert.assertTrue(new P01_HomePage(driver).validateSubmitSubscription());
    }
}
