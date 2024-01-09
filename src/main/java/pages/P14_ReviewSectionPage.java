package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P14_ReviewSectionPage {
    WebDriver driver;

    public P14_ReviewSectionPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By reviewUserName = By.id("name");
    private final By reviewUserMail = By.id("email");
    private final By reviewText = By.id("review");
    private final By submitReview = By.id("button-review");
    private final By reviewSuccessMsg = By.xpath("//div[@class='col-md-12 form-group']/div/span");

    public P14_ReviewSectionPage fillReviewUserName(String userName) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.reviewUserName));
        driver.findElement(this.reviewUserName).sendKeys(userName);
        return this;
    }

    public P14_ReviewSectionPage fillReviewMail(String userEmail) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.reviewUserMail));
        driver.findElement(this.reviewUserMail).sendKeys(userEmail);
        return this;
    }

    public P14_ReviewSectionPage fillReviewText(String text) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.reviewText));
        driver.findElement(this.reviewText).sendKeys(text);
        return this;
    }

    public P14_ReviewSectionPage clickOnSubmitBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.submitReview));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.submitReview).click();
        return this;
    }

    public boolean validateReviewSuccessMsgDisplayed() {
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.reviewSuccessMsg));
        return driver.findElement(this.reviewSuccessMsg).isDisplayed();
    }

}
