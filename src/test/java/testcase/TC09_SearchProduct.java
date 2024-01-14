package testcase;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P08_ProductsPage;

import java.util.List;

import static util.Utility.captureScreenshot;

public class TC09_SearchProduct extends TestBase{

    String productName = "Dress";
    @Test
    public void searchProduct(){
        Assert.assertTrue(new P01_HomePage(driver).validateHomePageIsVisible());

        new P01_HomePage(driver).clickProductsBtn();
        Assert.assertTrue(new P08_ProductsPage(driver).validateProductsPageDisplay());

        new P08_ProductsPage(driver).fillSearchProduct(productName).clickOnSubmitBtn();
        Assert.assertTrue(new P08_ProductsPage(driver).validateSearchedProductDisplay().contains(productName));

        //assert all product display according to search
        captureScreenshot(driver,"AllProductDisplayAccordingSearch");
        List<WebElement> productElements = new P08_ProductsPage(driver).getProductElements(); //list of prod elements
        for (WebElement productElement : productElements) {
            Assert.assertTrue(new P08_ProductsPage(driver).isProductDisplayed(productName));
            System.out.println(" status of product is " +new P08_ProductsPage(driver).isProductDisplayed(productName )) ;

        }
        System.out.println(" final status of product is " +new P08_ProductsPage(driver).isProductDisplayed(productName ));


    }
}
