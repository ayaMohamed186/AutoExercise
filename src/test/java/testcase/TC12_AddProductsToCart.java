package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P08_ProductsPage;
import pages.P09_ProductDetailsPage;
import pages.P10_CartPage;

import static util.Utility.captureScreenshot;

public class TC12_AddProductsToCart extends TestBase {
    String firstProductNameAdded;
    String secondProductNameAdded;
    String firstProductPrice;
    String firstProductQuantity;
    String secondProductPrice;
    String secondProductQuantity;

    @Test
    public void addProductsToCart() {
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickProductsBtn();

        firstProductNameAdded = new P08_ProductsPage(driver).firstProductNameAdded();
        new P08_ProductsPage(driver).hoverOnFirstProduct().clickOnAddToCartFirstProd().clickOnContinueShopping();

        secondProductNameAdded = new P08_ProductsPage(driver).secondProductNameAdded();
        new P08_ProductsPage(driver).hoverOnSecondProduct().clickOnAddToCartSecondProd().clickOnViewCartAtPopupMsg();

        //Assert both products are added to Cart
        Assert.assertEquals(firstProductNameAdded, new P10_CartPage(driver).firstProductAtCartName());
        Assert.assertEquals(secondProductNameAdded, new P10_CartPage(driver).secondProductAtCartName());

        //Assert their prices, quantity and total price
        new P01_HomePage(driver).clickHomeBtn();
        new P08_ProductsPage(driver).clickOnViewProductFirstItem();
        firstProductPrice = new P09_ProductDetailsPage(driver).getFirstProductPrice();
        firstProductQuantity = new P09_ProductDetailsPage(driver).getFirstProductQuantity();
        new P01_HomePage(driver).clickHomeBtn();
        new P08_ProductsPage(driver).clickOnViewProductSecondItem();
        secondProductPrice = new P09_ProductDetailsPage(driver).getFirstProductPrice();
        secondProductQuantity = new P09_ProductDetailsPage(driver).getFirstProductQuantity();

        new P01_HomePage(driver).clickOnCartBtn();
        captureScreenshot(driver,"ProductsAddedToCart");
        Assert.assertEquals(firstProductPrice, new P10_CartPage(driver).firstProductAtCartPrice());
        Assert.assertEquals(secondProductPrice, new P10_CartPage(driver).secondProductAtCartPrice());

        Assert.assertEquals(firstProductQuantity, new P10_CartPage(driver).firstProductAtCartQuantity());
        Assert.assertEquals(secondProductQuantity, new P10_CartPage(driver).secondProductAtCartQuantity());
    }
}
