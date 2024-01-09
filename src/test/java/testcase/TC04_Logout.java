package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_SignUpLoginPage;

import static testcase.TC02_LoginWithValidData.email1;
import static testcase.TC02_LoginWithValidData.password1;
import static util.Utility.captureScreenshot;

public class TC04_Logout extends TestBase{
    String newUrl;
    @Test
    public void logoutFunc(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickSingUpLoginButton();
        Assert.assertTrue(new P02_SignUpLoginPage(driver).validateLoginToAccMsgDisplay());

        new P02_SignUpLoginPage(driver).fillEmailFieldForLogin(email1).fillPasswordFieldForLogin(password1).clickOnLoginBtn();
        Assert.assertTrue(new P01_HomePage(driver).validateLoggedAsUserNameDisplay());

        new P01_HomePage(driver).clickLogOutBtn();
        newUrl = driver.getCurrentUrl();
        captureScreenshot(driver,"userLoggedOut");
        Assert.assertTrue(newUrl.contains("/login")); // Assert expected pattern

    }
}
