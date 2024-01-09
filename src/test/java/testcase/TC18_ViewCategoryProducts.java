package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P13_CategoryPage;

public class TC18_ViewCategoryProducts extends TestBase{

    @Test
    public void viewCategoryProducts(){
        Assert.assertTrue(new P01_HomePage(driver).validateCategoryDisplayed());

        new P01_HomePage(driver).clickHomeBtn().chooseWomenCategory().chooseWomenDressCategory();
        Assert.assertEquals("WOMEN - DRESS PRODUCTS", new P13_CategoryPage(driver).categoryTextDisplayed());

        new P13_CategoryPage(driver).chooseMenCategory().chooseTShirtSubCategory();
        Assert.assertEquals("MEN - TSHIRTS PRODUCTS", new P13_CategoryPage(driver).categoryTextDisplayed());

    }
}
