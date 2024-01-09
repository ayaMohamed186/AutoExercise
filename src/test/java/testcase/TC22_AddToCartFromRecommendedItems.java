package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P08_ProductsPage;
import pages.P10_CartPage;

public class TC22_AddToCartFromRecommendedItems extends TestBase{

    String productAddedFromRecommendName;
    String productAddedInCart;
    @Test
    public void addToCartFromRecommend(){
        Assert.assertTrue(new P01_HomePage(driver).validateRecommendationSecVisible());

        new P01_HomePage(driver);
        productAddedFromRecommendName = new P08_ProductsPage(driver).firstProductNameAdded(); // product added from recom ( expected)
        new P01_HomePage(driver).clickOnAddToCartForRecommendation();

        new P08_ProductsPage(driver).clickOnViewCartAtPopupMsg();
        productAddedInCart = new P10_CartPage(driver).firstProductAtCartName(); // actual one displayed in cart

        //Verify that product is displayed in cart page
        Assert.assertEquals( productAddedFromRecommendName , productAddedInCart);
    }
}
