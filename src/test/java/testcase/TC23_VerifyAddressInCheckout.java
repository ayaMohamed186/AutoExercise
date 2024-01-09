package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.*;

import static testcase.TC02_LoginWithValidData.*;
import static util.Utility.generateRandomInt;

public class TC23_VerifyAddressInCheckout extends TestBase{
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

    @Test
    public void verifyAddressInCheckout(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickSingUpLoginButton();
        Assert.assertEquals(new P02_SignUpLoginPage(driver).validateSignUpHeaderDisplay(), "New User Signup!");

        new P02_SignUpLoginPage(driver).fillNameInputFieldForSignUP(name).fillEmailInputFieldForSignUP(email).clickOnSIgnUpBtn();
        new P03_EnterAccountInfoPage(driver).chooseTitle().fillPassword(password).selectDay(day).selectMonth(month).
                selectYear(year).checkOnSignUForNewsletter().checkOnReceiveSpecialOfferCheck().fillFirstName(firstName).
                fillLastName(lastName).fillCompanyDetails(company).fillAddress1(address1).fillAddress2(address2).
                selectCounty(2).fillState(state).fillCity(city).fillZipCodeInputField(zipcode).fillMobileNoInputField(mobileNo).
                clickOnCreateAccBtn();
        Assert.assertEquals(new P03_EnterAccountInfoPage(driver).validateAccountCreatedMsg(), "ACCOUNT CREATED!");

        new P04_AccountCreatedPage(driver).clickOnContinueBtn();
        Assert.assertTrue(new P01_HomePage(driver).validateLoggedAsUserNameDisplay());

        new P01_HomePage(driver).clickProductsBtn();
        new P08_ProductsPage(driver).hoverOnFirstProduct().clickOnAddToCartFirstProd().clickOnContinueShopping();
        new P08_ProductsPage(driver).hoverOnSecondProduct().clickOnAddToCartSecondProd().clickOnViewCartAtPopupMsg();
        Assert.assertTrue(new P10_CartPage(driver).validateCartPageOpen());

        new P10_CartPage(driver).clickOnProcessedToCheckoutBtn();
        Assert.assertEquals(address1 , new P11_CheckoutPage(driver).validateAddress1());
        Assert.assertEquals(address2 , new P11_CheckoutPage(driver).validateAddress2());
        System.out.println("expected address1 added by faker " + address1);
        System.out.println("address1 in checkout is " + new P11_CheckoutPage(driver).validateAddress1());
        System.out.println("expected address2 added by faker " + address1);
        System.out.println("address2 in checkout is " + new P11_CheckoutPage(driver).validateAddress2());

        new P01_HomePage(driver).clickDeleteAccBtn();
        Assert.assertTrue(new P05_AccountDeletedPage(driver).validateAccDeletedDisplay());

    }
}
