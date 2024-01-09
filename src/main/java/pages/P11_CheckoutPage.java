package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P11_CheckoutPage {

    WebDriver driver;

    public P11_CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By commentInputField = By.xpath("//textarea[@class='form-control']");
    private final By placeOrderBtn = By.xpath("//a[@href='/payment']");
    private final By address1AtCheckoutPage = By.xpath("(//div[@class='col-xs-12 col-sm-6']/ul/li[4])[1]");
    private final By address2AtCheckoutPage = By.xpath("(//div[@class='col-xs-12 col-sm-6']/ul/li[5])[1]");
    private final By registerLoginBtnInCheckoutPopup = By.xpath("(//p[@class='text-center']/a/u)[1]");



    public P11_CheckoutPage fillCommentField(String comment){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.commentInputField));
        driver.findElement(this.commentInputField).sendKeys(comment);
        return this;
    }

    public P11_CheckoutPage clickOnPlaceOrder() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.placeOrderBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.placeOrderBtn).click();
        return this;
    }
    public String validateAddress1(){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.address1AtCheckoutPage));
        return driver.findElement(this.address1AtCheckoutPage).getText();
    }
    public String validateAddress2(){
        shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.address2AtCheckoutPage));
        return driver.findElement(this.address2AtCheckoutPage).getText();
    }

    public P11_CheckoutPage clickOnRegisterLoginBtnCheckout() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.registerLoginBtnInCheckoutPopup));
        } catch (TimeoutException ex) {
            ex.printStackTrace();//to print error
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.registerLoginBtnInCheckoutPopup).click();
        return this;
    }
}
