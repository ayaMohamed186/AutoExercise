package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_SignUpLoginPage;

import static testcase.TC02_LoginWithValidData.email1;
import static util.Utility.captureScreenshot;

public class TC05_RegisterUserWithExistingEmail extends TestBase{

    String name = "testName";
    @Test
    public void RegisterUserWithExistingEmail(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickSingUpLoginButton();
        Assert.assertEquals(new P02_SignUpLoginPage(driver).validateSignUpHeaderDisplay(), "New User Signup!");

        new P02_SignUpLoginPage(driver).fillNameInputFieldForSignUP(name).fillEmailInputFieldForSignUP(email1).clickOnSIgnUpBtn();
        captureScreenshot(driver,"emailAlreadyRegisterMsg");
        Assert.assertTrue(new P02_SignUpLoginPage(driver).verifyValidationSignUpDisplay());
    }
}
