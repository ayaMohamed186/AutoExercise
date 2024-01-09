package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P08_ProductsPage;
import pages.P13_CategoryPage;

public class TC19_ViewCartBrandProducts extends TestBase{

    @Test
    public void viewCartBrandProducts(){
        new P01_HomePage(driver).clickProductsBtn();
        Assert.assertTrue(new P08_ProductsPage(driver).validateBrandCategoryDisplayed());

        new P08_ProductsPage(driver).chooseHMBrand();
        Assert.assertEquals("BRAND - H&M PRODUCTS", new P13_CategoryPage(driver).categoryTextDisplayed());

    }
}
