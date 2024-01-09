package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P08_ProductsPage;
import pages.P09_ProductDetailsPage;

import static util.Utility.captureScreenshot;

public class TC08_VerifyProductsPage extends TestBase{

    @Test
    public void verifyProductsPage(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickProductsBtn();
        Assert.assertTrue(new P08_ProductsPage(driver).validateProductsPageDisplay());

        // assert The products list is visible
        new P08_ProductsPage(driver).clickOnViewProductFirstItem();
        captureScreenshot(driver,"firstProductDetails");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P09_ProductDetailsPage(driver).validateProductNameVisible());
        softAssert.assertTrue(new P09_ProductDetailsPage(driver).validateProductCategoryVisible());
        softAssert.assertTrue(new P09_ProductDetailsPage(driver).validateProductPriceVisible());
        softAssert.assertTrue(new P09_ProductDetailsPage(driver).validateProductAvailabilityVisible());
        softAssert.assertTrue(new P09_ProductDetailsPage(driver).validateProductConditionVisible());
        softAssert.assertTrue(new P09_ProductDetailsPage(driver).validateProductBrandVisible());
        softAssert.assertAll();

    }
}
