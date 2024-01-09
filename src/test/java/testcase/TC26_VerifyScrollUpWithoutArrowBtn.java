package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;

public class TC26_VerifyScrollUpWithoutArrowBtn extends TestBase{
    @Test
    public void verifyScrollUpAndDownW(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).scrollToFooter();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P01_HomePage(driver).validateSubscriptionDisplay());
        //softAssert.assertAll();

        new P01_HomePage(driver).clickOnArrowBtnToScrollUp();
        softAssert.assertTrue(new P01_HomePage(driver).validateHomePageMsgDisplay());
        System.out.println(new P01_HomePage(driver).validateHomePageMsgDisplay());
        softAssert.assertAll();

    }
}
