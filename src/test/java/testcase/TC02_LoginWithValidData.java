package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_SignUpLoginPage;
import pages.P03_EnterAccountInfoPage;
import pages.P04_AccountCreatedPage;
import static util.Utility.generateRandomInt;

public class TC02_LoginWithValidData extends TestBase{
    static String name1 = faker.name().firstName();
    static String email1 = faker.internet().emailAddress();
    static String password1 = faker.internet().password();
    int day = generateRandomInt(28);
    int month = generateRandomInt(12);
    int year = generateRandomInt(16);
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String company = "test";
    String address1 = faker.address().fullAddress();
    String address2 = faker.address().secondaryAddress();
    String state = faker.address().state();
    String city = faker.address().city();
    String zipcode = faker.address().zipCode();
    String mobileNo = faker.phoneNumber().phoneNumber();
    @Test()
    public void loginWithValidData() throws InterruptedException {
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickSingUpLoginButton();
        Assert.assertTrue(new P02_SignUpLoginPage(driver).validateLoginToAccMsgDisplay());

        // SignUp for new user
        new P02_SignUpLoginPage(driver).fillNameInputFieldForSignUP(name1).fillEmailInputFieldForSignUP(email1).clickOnSIgnUpBtn();
        new P03_EnterAccountInfoPage(driver).chooseTitle().fillPassword(password1).selectDay(day).selectMonth(month).
                selectYear(year).checkOnSignUForNewsletter().checkOnReceiveSpecialOfferCheck().fillFirstName(firstName).
                fillLastName(lastName).fillCompanyDetails(company).fillAddress1(address1).fillAddress2(address2).
                selectCounty(2).fillState(state).fillCity(city).fillZipCodeInputField(zipcode).fillMobileNoInputField(mobileNo).
                clickOnCreateAccBtn();
        new P04_AccountCreatedPage(driver).clickOnContinueBtn();
        new P01_HomePage(driver).clickLogOutBtn();
        //////////

        //login with register user
        new P01_HomePage(driver).clickSingUpLoginButton();
        new P02_SignUpLoginPage(driver).fillEmailFieldForLogin(email1).fillPasswordFieldForLogin(password1).clickOnLoginBtn();
        Assert.assertTrue(new P01_HomePage(driver).validateLoggedAsUserNameDisplay());
    }
}
