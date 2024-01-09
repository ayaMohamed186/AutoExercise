package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import retryTest.Retry;

import static util.Utility.captureScreenshot;
import static util.Utility.generateRandomInt;


public class TC01_Register extends TestBase {
    //String userName = Utility.getSingleJsonData(System.getProperty("user.dir") + "/src/test/resources/data_driven/InvalidloginData.json", "userName");
    // String password = Utility.getExcelData(0, 0, "loginData");
    String name = faker.name().firstName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
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

    @Test(priority = 1, description = " Register with valid data ")
    public void registerWithValidData() {
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickSingUpLoginButton();
        captureScreenshot(driver,"userSignUpForm");
        Assert.assertEquals(new P02_SignUpLoginPage(driver).validateSignUpHeaderDisplay(), "New User Signup!");

        new P02_SignUpLoginPage(driver).fillNameInputFieldForSignUP(name).fillEmailInputFieldForSignUP(email).clickOnSIgnUpBtn();
        captureScreenshot(driver,"signUpPageOpen");
        Assert.assertEquals(new P03_EnterAccountInfoPage(driver).validateEnterAccInfoVisible(), "ENTER ACCOUNT INFORMATION");

        new P03_EnterAccountInfoPage(driver).chooseTitle().fillPassword(password).selectDay(day).selectMonth(month).
                selectYear(year).checkOnSignUForNewsletter().checkOnReceiveSpecialOfferCheck().fillFirstName(firstName).
                fillLastName(lastName).fillCompanyDetails(company).fillAddress1(address1).fillAddress2(address2).
                selectCounty(2).fillState(state).fillCity(city).fillZipCodeInputField(zipcode).fillMobileNoInputField(mobileNo).
                clickOnCreateAccBtn();
        captureScreenshot(driver,"NewAccountCreated");
        Assert.assertEquals(new P03_EnterAccountInfoPage(driver).validateAccountCreatedMsg(), "ACCOUNT CREATED!");

        new P04_AccountCreatedPage(driver).clickOnContinueBtn();
        captureScreenshot(driver,"LoggedUserNameDisplay");
        Assert.assertTrue(new P01_HomePage(driver).validateLoggedAsUserNameDisplay());

        new P01_HomePage(driver).clickDeleteAccBtn();
        captureScreenshot(driver,"NewAccountDeleted");
        Assert.assertTrue(new P05_AccountDeletedPage(driver).validateAccDeletedDisplay());

        new P05_AccountDeletedPage(driver).clickOnContinueBtn();

    }


}
