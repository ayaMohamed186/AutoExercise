package testcase;

import org.junit.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P08_ProductsPage;
import pages.P14_ReviewSectionPage;

import static testcase.TC02_LoginWithValidData.email1;
import static testcase.TC02_LoginWithValidData.name1;

public class TC21_AddReviewOnProduct extends TestBase{

    String reviewUserName = name1;
    String reviewMail= email1;
    String reviewText = " review for product is good ";

    @Test
    public void addReviewOnProduct(){
        new P01_HomePage(driver).clickProductsBtn();
        Assert.assertTrue(new P08_ProductsPage(driver).validateProductsPageDisplay());

        new P08_ProductsPage(driver).clickOnViewProductFirstItem();
        new P14_ReviewSectionPage(driver).fillReviewUserName(reviewUserName).fillReviewMail(reviewMail).fillReviewText(reviewText).
                clickOnSubmitBtn();
        Assert.assertTrue(new P14_ReviewSectionPage(driver).validateReviewSuccessMsgDisplayed());

    }
}
