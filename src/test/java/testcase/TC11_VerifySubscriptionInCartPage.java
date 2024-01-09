package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;

import static testcase.TC02_LoginWithValidData.email1;
import static util.Utility.captureScreenshot;

public class TC11_VerifySubscriptionInCartPage extends TestBase{

    @Test
    public void verifySubscriptionInCart(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickOnCartBtn().scrollToFooter();
        SoftAssert softAssert = new SoftAssert();
        captureScreenshot(driver,"subscriptionSecDisplayed");
        softAssert.assertTrue(new P01_HomePage(driver).scrollToFooter().validateSubscriptionDisplay());
        softAssert.assertAll();

        new P01_HomePage(driver).fillSubscriptionMail(email1).clickOnSubmitSubscription();
        Assert.assertTrue(new P01_HomePage(driver).validateSubmitSubscription());

    }
}
