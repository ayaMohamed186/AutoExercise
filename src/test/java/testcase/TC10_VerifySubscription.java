package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import static testcase.TC02_LoginWithValidData.email1;

public class TC10_VerifySubscription extends TestBase{

    @Test
    public void verifySubscription(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P01_HomePage(driver).scrollToFooter().validateSubscriptionDisplay());
        softAssert.assertAll();

        new P01_HomePage(driver).fillSubscriptionMail(email1).clickOnSubmitSubscription();
        Assert.assertTrue(new P01_HomePage(driver).validateSubmitSubscription());
    }
}
