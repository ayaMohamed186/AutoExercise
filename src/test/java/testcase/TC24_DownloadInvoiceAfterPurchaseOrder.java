package testcase;

import com.github.javafaker.CreditCardType;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.*;

import static util.Utility.generateRandomInt;

public class TC24_DownloadInvoiceAfterPurchaseOrder extends TestBase {

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
    String firstProductNameAdded;
    String secondProductNameAdded;
    String comment = "comment for order ";
    String holderName = "ayatest";
    String CVC = "123";
    String holderNumber = faker.finance().creditCard(CreditCardType.VISA);
    String expireYear = "2025";
    String expireMonth = "06";

    @Test
    public void downloadInvoiceAfterPurchase() {
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickProductsBtn();
        firstProductNameAdded = new P08_ProductsPage(driver).firstProductNameAdded();
        new P08_ProductsPage(driver).hoverOnFirstProduct().clickOnAddToCartFirstProd().clickOnContinueShopping();
        secondProductNameAdded = new P08_ProductsPage(driver).secondProductNameAdded();
        new P08_ProductsPage(driver).hoverOnSecondProduct().clickOnAddToCartSecondProd().clickOnViewCartAtPopupMsg();
        Assert.assertTrue(new P10_CartPage(driver).validateCartPageOpen());

        new P10_CartPage(driver).clickOnProcessedToCheckoutBtn();
        new P11_CheckoutPage(driver).clickOnRegisterLoginBtnCheckout();

        new P02_SignUpLoginPage(driver).fillNameInputFieldForSignUP(name).fillEmailInputFieldForSignUP(email).clickOnSIgnUpBtn();
        new P03_EnterAccountInfoPage(driver).chooseTitle().fillPassword(password).selectDay(day).selectMonth(month).
                selectYear(year).checkOnSignUForNewsletter().checkOnReceiveSpecialOfferCheck().fillFirstName(firstName).
                fillLastName(lastName).fillCompanyDetails(company).fillAddress1(address1).fillAddress2(address2).
                selectCounty(2).fillState(state).fillCity(city).fillZipCodeInputField(zipcode).fillMobileNoInputField(mobileNo).
                clickOnCreateAccBtn();
        Assert.assertEquals(new P03_EnterAccountInfoPage(driver).validateAccountCreatedMsg(), "ACCOUNT CREATED!");

        new P04_AccountCreatedPage(driver).clickOnContinueBtn();
        Assert.assertTrue(new P01_HomePage(driver).validateLoggedAsUserNameDisplay());

        new P01_HomePage(driver).clickOnCartBtn();
        new P10_CartPage(driver).clickOnProcessedToCheckoutBtn();
        Assert.assertEquals(address1, new P11_CheckoutPage(driver).validateAddress1());
        Assert.assertEquals(address2, new P11_CheckoutPage(driver).validateAddress2());
        Assert.assertEquals(firstProductNameAdded, new P10_CartPage(driver).firstProductAtCartName());
        Assert.assertEquals(secondProductNameAdded, new P10_CartPage(driver).secondProductAtCartName());

        new P11_CheckoutPage(driver).fillCommentField(comment).clickOnPlaceOrder();
        new P12_PaymentPage(driver).fillCardHolderName(holderName).fillCreditCardNumberField(holderNumber).fillCardCVC(CVC).
                selectExpireMonth(expireMonth).selectExpireYear(expireYear).clickOnPayBtn();
        Assert.assertTrue(new P12_PaymentPage(driver).validateOrderCreatedSuccess());

        new P15_PaymentDonePage(driver).clickOnDownloadInvoiceBtn();
        ///verify invoice file is downloaded successfully.
        String filePath = "C:\\Users\\ayama\\Downloads";
        String fileName = "invoice.txt";
        Assert.assertTrue(new P15_PaymentDonePage(driver).validateFileDownloaded(filePath, fileName));

        System.out.println(new P15_PaymentDonePage(driver).validateFileDownloaded(filePath, fileName));



    }
}
