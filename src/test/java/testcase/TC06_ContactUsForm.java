package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P06_ContactUsPage;

import static testcase.TC02_LoginWithValidData.email1;
import static testcase.TC02_LoginWithValidData.name1;
import static util.Utility.captureScreenshot;

public class TC06_ContactUsForm extends TestBase{

    String subject = "test subject ";
    String msg = "Massage test ";
    @Test
    public void contactUsForm(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickContactUsBtn();
        Assert.assertTrue(new P06_ContactUsPage(driver).validateGetInTouchMsgDisplay());

        new P06_ContactUsPage(driver).fillNameInputField(name1).fillEmailInputField(email1).fillSubjectInputField(subject).
                fillMsgInputField(msg).uploadFile().clickOnSubmitBtn().clickOnOKAlert();
        captureScreenshot(driver,"contactUsSuccessMsg");
        Assert.assertTrue(new P06_ContactUsPage(driver).validateSuccessMsgDisplayed());

        new P06_ContactUsPage(driver).clickOnHomeBtn();
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());
        
    }
}
