package testcase;

import com.github.javafaker.CreditCardType;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.*;

import static testcase.TC02_LoginWithValidData.*;
import static util.Utility.generateRandomInt;

public class TC15_PlaceOrderRegisterBeforeCheckout extends TestBase{
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
    String checkoutComment = "comment test";
    String cardName = "ayatest";
    String code = "123";
    String CreditCardNumberGenerated = faker.finance().creditCard(CreditCardType.VISA);
    String CardExpireYear = "2025";
    String CardExpireMonth = "06";

    @Test
    public void placeOrderRegisterBeforeCheckout(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickSingUpLoginButton();
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

//12. Verify Address Details and Review Your Order
        new P11_CheckoutPage(driver).fillCommentField(checkoutComment).clickOnPlaceOrder();
        new P12_PaymentPage(driver).fillCardHolderName(cardName).fillCreditCardNumberField(CreditCardNumberGenerated).
                fillCardCVC(code).selectExpireYear(CardExpireYear).selectExpireMonth(CardExpireMonth).clickOnPayBtn();
        Assert.assertTrue(new P12_PaymentPage(driver).validateOrderCreatedSuccess());

        new P01_HomePage(driver).clickDeleteAccBtn();
        Assert.assertTrue(new P05_AccountDeletedPage(driver).validateAccDeletedDisplay());

        new P05_AccountDeletedPage(driver).clickOnContinueBtn();

    }

}
