package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P08_ProductsPage;
import pages.P09_ProductDetailsPage;
import pages.P10_CartPage;

public class TC13_VerifyProductQuantityInCart extends TestBase{

    @Test
    public void verifyProductQuantityInCart() throws InterruptedException {
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P08_ProductsPage(driver).clickOnViewProductFirstItem();
        new P09_ProductDetailsPage(driver).increaseProductQuantityTo4().clickOnContinueBtn();
        new P08_ProductsPage(driver).clickOnViewCartAtPopupMsg();

        //assert that product display in cart with quantity 4
        Assert.assertEquals("4" , new P10_CartPage(driver).firstProductAtCartQuantity());
        System.out.println("actual number in cart is "+ new P10_CartPage(driver).firstProductAtCartQuantity() );
        Thread.sleep(5000);
    }
}
