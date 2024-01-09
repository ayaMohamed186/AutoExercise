package testcase;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_SignUpLoginPage;
import util.Utility;

import java.io.IOException;

public class TC03_LoginWithInValidData extends TestBase{

    String mail = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/InvalidloginData.json", "email");
    String password = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/InvalidloginData.json", "password");

    public TC03_LoginWithInValidData() throws IOException, ParseException {
    }

    @Test
    public void loginWithInValidData(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickSingUpLoginButton();
        Assert.assertTrue(new P02_SignUpLoginPage(driver).validateLoginToAccMsgDisplay());

        new P02_SignUpLoginPage(driver).fillEmailFieldForLogin(mail).fillPasswordFieldForLogin(password).clickOnLoginBtn();
        Assert.assertTrue(new P02_SignUpLoginPage(driver).verifyValidationDisplay());

    }
}
