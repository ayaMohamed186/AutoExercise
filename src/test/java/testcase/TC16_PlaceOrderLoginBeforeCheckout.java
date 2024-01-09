package testcase;

import com.github.javafaker.CreditCardType;
import org.junit.Assert;
import org.testng.annotations.Test;
import pages.*;

import static testcase.TC02_LoginWithValidData.email1;
import static testcase.TC02_LoginWithValidData.password1;

public class TC16_PlaceOrderLoginBeforeCheckout extends TestBase {
    String checkoutComment = "comment test";
    String cardName = "ayatest";
    String code = "123";
    String CreditCardNumberGenerated = faker.finance().creditCard(CreditCardType.VISA);
    String CardExpireYear = "2025";
    String CardExpireMonth = "06";

    @Test
    public void placeOrderLoginBeforeCheckout() {
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickSingUpLoginButton();
        new P02_SignUpLoginPage(driver).fillEmailFieldForLogin(email1).fillPasswordFieldForLogin(password1).clickOnLoginBtn();
        Assert.assertTrue(new P01_HomePage(driver).validateLoggedAsUserNameDisplay());

        new P01_HomePage(driver).clickProductsBtn();
        new P08_ProductsPage(driver).hoverOnFirstProduct().clickOnAddToCartFirstProd().clickOnContinueShopping();
        new P08_ProductsPage(driver).hoverOnSecondProduct().clickOnAddToCartSecondProd().clickOnViewCartAtPopupMsg();

        new P10_CartPage(driver).clickOnProcessedToCheckoutBtn();
        //11. Verify Address Details and Review Your Order
        new P11_CheckoutPage(driver).fillCommentField(checkoutComment).clickOnPlaceOrder();
        new P12_PaymentPage(driver).fillCardHolderName(cardName).fillCreditCardNumberField(CreditCardNumberGenerated).
                fillCardCVC(code).selectExpireYear(CardExpireYear).selectExpireMonth(CardExpireMonth).clickOnPayBtn();
        Assert.assertTrue(new P12_PaymentPage(driver).validateOrderCreatedSuccess());

    }
}
