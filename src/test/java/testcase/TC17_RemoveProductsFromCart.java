package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P08_ProductsPage;
import pages.P10_CartPage;

public class TC17_RemoveProductsFromCart extends TestBase {

    @Test
    public void removeProductsFromCart() throws InterruptedException {
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickProductsBtn();
        new P08_ProductsPage(driver).hoverOnFirstProduct().clickOnAddToCartFirstProd().clickOnContinueShopping();
        new P08_ProductsPage(driver).hoverOnSecondProduct().clickOnAddToCartSecondProd().clickOnViewCartAtPopupMsg();
        Assert.assertTrue(new P10_CartPage(driver).validateCartPageOpen());

        new P10_CartPage(driver).clickOnDeleteProductBtn();
        Thread.sleep(1500);

        System.out.println("tesst " + new P10_CartPage(driver).validateProductDisplayAfterDelete());
        Assert.assertFalse(new P10_CartPage(driver).validateProductDisplayAfterDelete());



        ////////////////////////////////////////
    }
}
