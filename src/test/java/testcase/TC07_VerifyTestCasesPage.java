package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P06_ContactUsPage;
import pages.P07_TestCasesPage;

public class TC07_VerifyTestCasesPage extends TestBase{

    @Test
    public void verifyTcPage(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickTestCaseBtn();
        Assert.assertTrue(new P07_TestCasesPage(driver).validateTestCasePageDisplay());

    }
}
